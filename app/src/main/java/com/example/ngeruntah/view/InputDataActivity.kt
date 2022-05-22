package com.example.ngeruntah.view

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.ngeruntah.R
import com.example.ngeruntah.view.InputDataActivity.FunctionHelper.rupiahFormat
import kotlinx.android.synthetic.main.activity_input_data.*
import kotlinx.android.synthetic.main.activity_jenis_sampah.toolbar
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*


class InputDataActivity : AppCompatActivity() {

    lateinit var inputDataViewModel: InputDataViewModel
    lateinit var strNama: String
    lateinit var strTanggal: String
    lateinit var strAlamat: String
    lateinit var strCatatan: String
    lateinit var strKategoriSelected: String
    lateinit var strHargaSelected: String
    lateinit var strKategori: Array<String>
    lateinit var strHarga: Array<String>
    var countTotal = 0
    var countBerat = 0
    var countHarga = 0

    object FunctionHelper {

        fun rupiahFormat(price: Int): String {
            val formatter = DecimalFormat("#,###")
            return "Rp " + formatter.format(price.toLong())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_data)
        setToolbar()
        setInitLayout()
        setInputData()

        btnCheckout.setOnClickListener{
            val intent = Intent(this, RiwayatActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setToolbar() {
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowTitleEnabled(false)
        }
    }

    private fun setInitLayout() {
        strKategori = resources.getStringArray(R.array.kategori_sampah)
        strHarga = resources.getStringArray(R.array.harga_perkilo)

        inputDataViewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(this.application)
        ).get(InputDataViewModel::class.java)

        val arrayBahasa =
            ArrayAdapter(this@InputDataActivity, android.R.layout.simple_list_item_1, strKategori)
        arrayBahasa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spKategori.setAdapter(arrayBahasa)

        spKategori.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                strKategoriSelected = parent.getItemAtPosition(position).toString()
                strHargaSelected = strHarga[position]
                spKategori.setEnabled(true)
                countHarga = strHargaSelected.toInt()
                if (inputBerat.getText().toString() != "") {
                    countBerat = inputBerat.getText().toString().toInt()
//                    setTotalPrice(countBerat)
                }
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        })

        inputBerat.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(editable: Editable) {
            }
        })

        inputTanggal.setOnClickListener { view: View? ->
            val tanggalJemput = Calendar.getInstance()
            val date =
                DatePickerDialog.OnDateSetListener { view1: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                    tanggalJemput[Calendar.YEAR] = year
                    tanggalJemput[Calendar.MONTH] = monthOfYear
                    tanggalJemput[Calendar.DAY_OF_MONTH] = dayOfMonth
                    val strFormatDefault = "d MMMM yyyy"
                    val simpleDateFormat = SimpleDateFormat(strFormatDefault, Locale.getDefault())
                    inputTanggal.setText(simpleDateFormat.format(tanggalJemput.time))
                }
            DatePickerDialog(
                this@InputDataActivity, date,
                tanggalJemput[Calendar.YEAR],
                tanggalJemput[Calendar.MONTH],
                tanggalJemput[Calendar.DAY_OF_MONTH]
            ).show()
        }
    }


    private fun setTotalPrice(berat: Int) {
        countTotal = countHarga * berat
        inputHarga.setText(rupiahFormat(countTotal))
    }

    private fun setInputData() {
        btnCheckout.setOnClickListener { v: View? ->
            strNama = inputNama.text.toString()
            strTanggal = inputTanggal.text.toString()
            strAlamat = inputAlamat.text.toString()
            strCatatan = inputTambahan.text.toString()
            if (strNama.isEmpty() or strTanggal.isEmpty() or strAlamat.isEmpty() or (strKategori.size == 0) or (countBerat == 0) or (countHarga == 0)) {
                Toast.makeText(
                    this@InputDataActivity,
                    "Data tidak boleh ada yang kosong!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                inputDataViewModel.addDataSampah(
                    strNama,
                    strKategoriSelected,
                    countBerat,
                    countHarga,
                    strTanggal,
                    strAlamat,
                    strCatatan
                )
                Toast.makeText(
                    this@InputDataActivity,
                    "Pesanan Anda sedang diproses, cek di menu riwayat",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
            if (item.itemId == android.R.id.home) {
                finish()
                return true
            }
            return super.onOptionsItemSelected(item)
        }

        companion object {
            fun setWindowFlag(activity: Activity, bits: Int, on: Boolean) {
                val window = activity.window
                val layoutParams = window.attributes
                if (on) {
                    layoutParams.flags = layoutParams.flags or bits
                } else {
                    layoutParams.flags = layoutParams.flags and bits.inv()
                }
                window.attributes = layoutParams
            }
        }

}