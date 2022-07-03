package com.example.ngeruntah.view

object DataSampleRiwayat {
    private val nama_pengguna = arrayOf(
        "Chandra Ayunda Apta Soemedhy",
        "Akhmad Nur Almasyah",
        "Dwi Puspa",
        "Nawang Anggita"
    )
    private val berat = arrayOf(
        "2.0",
        "1.5",
        "1.0",
        "2.5"
    )
    private val tanggal = arrayOf(
        "1 juli 22",
        "2 juli 22",
        "3 juli 22",
        "4 juli 22"
    )
    private val alamat = arrayOf(
        "Purwokerto selatan",
        "purwokerto utara",
        "purwokerto barat",
        "purwokerto timur"
    )
    private val catatan = arrayOf(
        "semua bisa dijual",
        "Baguss",
        "good",
        "not bad",
        "cool"

    )
    val listData: ArrayList<DataRiwayat>
        get() {
            val listDataku = arrayListOf<DataRiwayat>()
            for (position in nama_pengguna.indices) {
                val data = DataRiwayat()
                data.name = nama_pengguna[position]
                data.weight = berat[position]
                data.date = tanggal[position]
                data.address = alamat[position]
                data.note = catatan[position]
                listDataku.add(data)
            }
            return listDataku
        }

}