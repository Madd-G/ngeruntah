package com.example.ngeruntah.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ngeruntah.R

class HistoryAdapter(private val listData: ArrayList<DataRiwayat>) :
        RecyclerView.Adapter<HistoryAdapter.CardViewHolder>() {
        inner class CardViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
                var tvNamaPengguna: TextView = itemView.findViewById(R.id.tvNamaPengguna)
                var tvJenisSampah: TextView = itemView.findViewById(R.id.tvJenisSampah)
                var tvBerat: TextView = itemView.findViewById(R.id.tvBerat)
                var tvTanggal: TextView = itemView.findViewById(R.id.tvTanggal)
                var tvCatatan: TextView = itemView.findViewById(R.id.tvStatus)
        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_riwayat, parent, false)
                return CardViewHolder(view)
        }

        override fun onBindViewHolder(holder: HistoryAdapter.CardViewHolder, position: Int) {
                val dataku = listData[position]

                holder.tvNamaPengguna.text = dataku.nama_pengguna
                holder.tvTanggal.text = dataku.tanggal.toString()
                holder.tvJenisSampah.text = dataku.jenis_sampah
                holder.tvBerat.text = dataku.berat.toString()
                holder.tvCatatan.text = dataku.catatan

        }

        override fun getItemCount(): Int {
                return listData.size
        }

}