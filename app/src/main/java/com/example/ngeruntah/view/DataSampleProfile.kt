package com.example.ngeruntah.view

object DataSampleProfile {
    private val username = arrayOf(
    )
    private val email = arrayOf(
    )
    private val no_telepon = arrayOf(
    )
    private val jenis_kelamin = arrayOf(
    )
    val listData: ArrayList<DataProfile>
        get() {
            val listDataku = arrayListOf<DataProfile>()
            for (position in username.indices) {
                val data = DataProfile()
                data.username = username[position]
                data.email = email[position]
                data.no_telepon = no_telepon[position]
                data.jenis_kelamin = jenis_kelamin[position]
                listDataku.add(data)
            }
            return listDataku
        }
}