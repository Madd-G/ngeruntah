package com.example.ngeruntah.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ngeruntah.R
import kotlinx.android.synthetic.main.activity_login_page.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jemput_sampah.setOnClickListener{
            val intent = Intent(this, InputDataActivity::class.java)
            startActivity(intent)
        }
        jenis_sampah.setOnClickListener{
            val intent = Intent(this, JenisSampahActivity::class.java)
            startActivity(intent)
        }
        saldo_riwayat.setOnClickListener{
            val intent = Intent(this, RiwayatActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setInitLayout() {
        cvInput.setOnClickListener { v: View? ->
            val intent = Intent(this@MainActivity, InputDataActivity::class.java)
            startActivity(intent)
        }

        cvKategori.setOnClickListener { v: View? ->
            val intent = Intent(this@MainActivity, JenisSampahActivity::class.java)
            startActivity(intent)
        }

        cvHistory.setOnClickListener { v: View? ->
            val intent = Intent(this@MainActivity, RiwayatActivity::class.java)
            startActivity(intent)
        }
    }


}