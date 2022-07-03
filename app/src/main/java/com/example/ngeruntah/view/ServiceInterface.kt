package com.example.ngeruntah.view

import android.telecom.Call
import retrofit2.Call
import retrofit2.http.*

class ServiceInterface {
    @GET("name")
    fun getData(): retrofit2.Call<List<DataRiwayat>>
    @GET("weight")
    fun getData(): retrofit2.Call<List<DataRiwayat>>
    @GET("date")
    fun getData(): retrofit2.Call<List<DataRiwayat>>
    @GET("address")
    fun getData(): retrofit2.Call<List<DataRiwayat>>
    @GET("note")
    fun getData(): retrofit2.Call<List<DataRiwayat>>

}