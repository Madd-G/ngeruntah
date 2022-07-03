package com.example.ngeruntah.view

object DataSampleRiwayat {
    private val nama_pengguna = arrayOf(
    )
    private val jenis_sampah = arrayOf(
    )
    private val berat = arrayOf(
    )
    private val tanggal = arrayOf(
    )
    private val alamat = arrayOf(
    )
    private val catatan = arrayOf(
    )
    val listData: ArrayList<DataRiwayat>
        get() {
            val listDataku = arrayListOf<DataRiwayat>()
            for (position in nama_pengguna.indices) {
                val data = DataRiwayat()
                data.nama_pengguna = nama_pengguna[position]
                data.jenis_sampah = jenis_sampah[position]
                data.berat = berat[position]
                data.tanggal = tanggal[position]
                data.alamat = alamat[position]
                data.catatan = catatan[position]
                listDataku.add(data)
            }
            return listDataku
        }

}