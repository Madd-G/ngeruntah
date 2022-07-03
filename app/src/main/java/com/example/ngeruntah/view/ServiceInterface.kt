import com.example.ngeruntah.view.DataRiwayat
import com.example.ngeruntah.view.DataSignup
import retrofit2.Call
import retrofit2.http.*

interface ServiceInterface {
    @GET("/")
    fun getData(): Call<List<DataRiwayat>>

    @POST("/create_order/")
    fun postData(@Body dataRiwayat: DataRiwayat) : Call<DataRiwayat>

    @POST("/signup/")
    fun postData(@Body dataSignup: DataSignup) : Call<DataSignup>

//    @FormUrlEncoded
//    @HTTP(method="PUT", path="/update_order", hasBody = true)
//    fun updateKontak(
//        @Field("weight") weight: Int,
//        @Field("date") date: String,
//        @Field("address") address: String,
//        @Field("note") note: String): Call<DataRiwayat>
}