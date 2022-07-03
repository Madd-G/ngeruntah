import com.example.ngeruntah.view.DataRiwayat
import retrofit2.Call
import retrofit2.http.*

interface ServiceInterface {
    @GET("/")
    fun getData(): Call<List<DataRiwayat>>
}