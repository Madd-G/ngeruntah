package com.example.ngeruntah.view

object DataSampleRiwayat {
    private val nama_pengguna = arrayOf(
        "Chandra Ayunda Apta Soemedhy",
        "Akhmad Nur Almasyah",
        "Dwi Puspa",
        "Nawang Anggita"
    )
    private val jenis_sampah = arrayOf(
        "Organik",
        "Anorganik",
        "Organik",
        "Anorganik"
    )
    private val berat = arrayOf(
        "2",
        "1.5",
        "1",
        "2.5"
    )
    private val tanggal = arrayOf(
        "1-07-22",
        "2-07-22",
        "3-07-22",
        "4-07-22"
    )
    private val alamat = arrayOf(
        "Purwokerto selatan",
        "purwokerto utara",
        "purwokerto barat",
        "purwokerto timur"
    )
    private val catatan = arrayOf(
<<<<<<< HEAD
        "semua bisa dijual"
=======
        "Baguss",
        "good",
        "not bad",
        "cool"
>>>>>>> 76a988292c3b7f758114906540d38c0528c9797a

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