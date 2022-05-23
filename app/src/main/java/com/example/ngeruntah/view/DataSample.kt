package com.example.ngeruntah.view

object DataSample {
    private val nama_pengguna = arrayOf(
        "John Doe",
        "Jane Doe",
    )
    private val jenis_sampah = arrayOf(
        "Plastik",
        "Logam",
    )
    private val berat = doubleArrayOf(
        5.5,
        7.0,
    )
    private val tanggal = arrayOf(
        "24 May 2022",
        "12 June 2022",
    )
    private val alamat = arrayOf(
        "Purwokerto",
        "Cilacap",
    )
    private val catatan = arrayOf(
        "Sudah dikonfirmasi",
        "Sudah dikonfirmasi",
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