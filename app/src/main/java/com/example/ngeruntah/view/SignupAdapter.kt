package com.example.ngeruntah.view

import ServiceInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ngeruntah.R
import com.example.ngeruntah.view.network.Repository

class HistoryAdapter(private val listData: ArrayList<DataRiwayat>) :
RecyclerView.Adapter<HistoryAdapter.CardViewHolder>() {
    inner class CardViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvUsername: TextView = itemView.findViewById(R.id.tvUsername)
        var tvEmail: TextView = itemView.findViewById(R.id.tvEmail)
        var tvNotelepon: TextView = itemView.findViewById(R.id.tvNotelepon)
        var tvJeniskelamin: TextView = itemView.findViewById(R.id.tvJeniskelamin)
        var tvPassword: TextView = itemView.findViewById(R.id.tvPassword)
        var apiIterface: ServiceInterface? = Repository.getDataAPI().create(ServiceInterface::class.java)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_riwayat, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryAdapter.CardViewHolder, position: Int) {
        val dataku = listData[position]

        holder.tvUsername.text = dataku.username
        holder.tvEmail.text = dataku.email
        holder.tvNotelepon.text = dataku.no_telepon
        holder.tvJeniskelamin.text = dataku.jenis_kelamin
        holder.tvPassword.text = dataku.password

    }

    override fun getItemCount(): Int {
        return listData.size
    }
    {

}