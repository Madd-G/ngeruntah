package com.example.ngeruntah.view

object DataSampleRiwayat {
    private val email = arrayOf(
    )
    private val password = arrayOf(
    )

    val listData: ArrayList<DataLogin>
        get() {
            val listDataku = arrayListOf<DataLogin>()
            for (position in email.indices) {
                val data = DataLogin()
                data.email = email[position]
                data.password = password[position]
                listDataku.add(data)
            }
            return listDataku
        }

}