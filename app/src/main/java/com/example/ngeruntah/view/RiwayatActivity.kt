package com.example.ngeruntah.view

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ngeruntah.R
import kotlinx.android.synthetic.main.activity_jenis_sampah.toolbar
import kotlinx.android.synthetic.main.activity_riwayat.*

class RiwayatActivity : AppCompatActivity() {
    private lateinit var rvData: RecyclerView
    private var list: ArrayList<DataRiwayat> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riwayat)
        setToolbar()

        rvData = findViewById(R.id.rvHistory)
        rvData.setHasFixedSize(true)
        list.addAll(DataSample.listData)
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