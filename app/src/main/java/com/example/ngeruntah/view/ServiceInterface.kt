package com.example.ngeruntah.view

import android.telecom.Call
import retrofit2.Call
import retrofit2.http.*

class ServiceInterface {
    @GET("name")
    fun getData(): Call<List<DataRiwayat>>
    @GET("weight")
    fun getData(): Call<List<DataRiwayat>>
    @GET("date")
    fun getData(): Call<List<DataRiwayat>>
    @GET("address")
    fun getData(): Call<List<DataRiwayat>>
    @GET("note")
    fun getData(): Call<List<DataRiwayat>>

}