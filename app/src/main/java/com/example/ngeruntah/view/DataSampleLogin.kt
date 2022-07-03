package com.example.ngeruntah.view

object DataSampleLogin {
    private val email = arrayOf(
    )
    private val password = arrayOf(
    )

    val listData: ArrayList<DataLogin>
        get() {
            val listDataku = arrayListOf<DataLogin>()
            for (position in email.indices) {
                val data = DataLogin()
                data.emaildata = email[position]
                data.passworddata = password[position]
                listDataku.add(data)
            }
            return listDataku
        }

}