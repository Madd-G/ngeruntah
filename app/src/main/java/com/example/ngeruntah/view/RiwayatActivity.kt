package com.example.ngeruntah.view

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ngeruntah.R
import com.example.ngeruntah.view.network.Repository
import kotlinx.android.synthetic.main.activity_jenis_sampah.toolbar
import kotlinx.android.synthetic.main.activity_riwayat.*
import retrofit2.Response
import javax.security.auth.callback.Callback

class RiwayatActivity : AppCompatActivity() {
    private lateinit var rvData: RecyclerView
    private var list: ArrayList<DataRiwayat> = arrayListOf()

    lateinit var rvdata: RecyclerView
    lateinit var apiService: ServiceInterface
    private var ambilDatabase: ArrayList<DataRiwayat> = arrayListOf()
    lateinit var btnAdd: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riwayat)
        setToolbar()

        rvData = findViewById(R.id.rvHistory)
        rvData.setHasFixedSize(true)
        list.addAll(DataSampleRiwayat.listData)
        apiService = Repository.getDataAPI().create(ServiceInterface::class.java)
        apiService.getData().enqueue(object : Callback<List<DataRiwayat>> {
            override fun onResponse(
                call: retrofit2.Call<List<DataRiwayat>>,
                response: Response<List<DataRiwayat>>
            ) {
            }
            override fun onFailure(call: retrofit2.Call<List<DataRiwayat>>, t: Throwable) {
            }

        })

        showRecyclerViewCard()


        btnCheckout.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showRecyclerViewCard() {
        rvData.layoutManager = LinearLayoutManager(this)
        val adapterku = HistoryAdapter(list)
        rvData.adapter = adapterku
    }

    private fun setToolbar() {
        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowTitleEnabled(false)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}