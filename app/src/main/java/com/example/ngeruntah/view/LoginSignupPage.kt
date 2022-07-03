package com.example.ngeruntah.view

import ServiceInterface
import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ngeruntah.R
import com.example.ngeruntah.view.network.Repository
import kotlinx.android.synthetic.main.activity_jemput_sampah.*
import kotlinx.android.synthetic.main.activity_jenis_sampah.*
import kotlinx.android.synthetic.main.activity_login_signup_page.*
import kotlinx.android.synthetic.main.activity_riwayat.*
import kotlinx.android.synthetic.main.activity_riwayat.toolbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class LoginSignupPage : AppCompatActivity() {

    lateinit var btnSubmit: Button

    lateinit var inputDataViewModel: InputDataViewModel
    lateinit var etUsername: EditText
    lateinit var etEmail: EditText
    lateinit var etNotelepon: EditText
    lateinit var etJeniskelamin: EditText
    lateinit var etPassword: EditText
    lateinit var apiService: ServiceInterface
    lateinit var btnadd: View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_signup_page)

        signin_signup_btn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        signin.setOnClickListener {
            signin.setTextColor(Color.parseColor("#FFFFFF"))
            signin.setBackgroundColor(Color.parseColor("#B75F43"))
            signup.setTextColor(Color.parseColor("#B75F43"))
            signup.setBackgroundResource(R.drawable.bordershape)
            circleImageView.setImageResource(R.drawable.signin_boy_img)
            signin_signup_txt.text = "Sign In"
            signin_signup_btn.text = "Sign In"
            forgot_password.visibility = View.VISIBLE
        }
        signup.setOnClickListener {
            signup.setTextColor(Color.parseColor("#FFFFFF"))
            signup.setBackgroundColor(Color.parseColor("#B75F43"))
            signin.setTextColor(Color.parseColor("#B75F43"))
            signin.setBackgroundResource(R.drawable.bordershape)
            circleImageView.setImageResource(R.drawable.signup_boy_img)
            signin_signup_txt.text = "Sign Up"
            signin_signup_btn.text = "Sign Up"
            forgot_password.visibility = View.INVISIBLE
        }

        forgot_password.setOnClickListener {
            signup.setTextColor(Color.parseColor("#FFFFFF"))
            signup.setBackgroundColor(Color.parseColor("#FF2729C3"))
            signin.setTextColor(Color.parseColor("#FF2729C3"))
            signin.setBackgroundResource(R.drawable.bordershape)
            circleImageView.setImageResource(R.drawable.signup_boy_img)
            signin_signup_txt.text = "Sign Up"
            signin_signup_btn.text = "Sign Up"
            forgot_password.visibility = View.INVISIBLE
        }

      /*  btnadd = findViewById(R.id.btnCheckout)
        btnadd.setOnClickListener {
            val arraySignup = DataSignup()
            arraySignup.username = etUsername.text.toString()
            arraySignup.email = etEmail.text.toString()
            arraySignup.no_telepon= etNotelepon.text.toString()
            arraySignup.jenis_kelamin = etJeniskelamin.text.toString()
            arraySignup.password = etPassword.text.toString()
            apiService.postData(arraySignup).enqueue(object : Callback<DataSignup> {
                override fun onResponse(call: Call<DataSignup>, response: Response<DataSignup>) {
                    startActivity(Intent(this@LoginSignupPage, LoginSignupPage::class.java))
                    Toast.makeText(baseContext, "Add Data Success", Toast.LENGTH_SHORT).show()

                }

                override fun onFailure(call: Call<DataSignup>, t: Throwable) {
                    Toast.makeText(baseContext, "Add Data Failed", Toast.LENGTH_SHORT).show()
                }

            })
            startActivity(Intent(this, LoginSignupPage::class.java))
        }

        btnSubmit = findViewById(R.id.btnCheckout)
        etUsername = findViewById(R.id.username)
        etEmail = findViewById(R.id.email)
        etNotelepon = findViewById(R.id.no_telepon)
        etJeniskelamin = findViewById(R.id.jenis_kelamin)
        etPassword = findViewById(R.id.password)
        apiService = Repository.getDataAPI().create(ServiceInterface::class.java)

       */
    }
}