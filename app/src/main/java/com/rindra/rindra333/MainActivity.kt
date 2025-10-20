package com.rindra.rindra333

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.rindra.rindra333.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSubmit.setOnClickListener {
            val fullName = binding.etFullName.text.toString()
            val username = binding.etUsername.text.toString()
            val age = binding.etAge.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val confirmPassword = binding.etConfirmPassword.text.toString()
            val gender = if (binding.rbLakiLaki.isChecked) "Laki-laki" else "Perempuan"
            if (fullName.isEmpty() || username.isEmpty() || age.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Semua kolom wajib diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password != confirmPassword) {
                Toast.makeText(this, "Password tidak cocok!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(this, ResultActivity::class.java).apply {
                putExtra(DATA_FULL_NAME, fullName)
                putExtra(DATA_USERNAME, username)
                putExtra(DATA_AGE, age)
                putExtra(DATA_EMAIL, email)
                putExtra(DATA_GENDER, gender)
            }
            startActivity(intent)
        }
    }
    companion object {
        const val DATA_FULL_NAME = "data_full_name"
        const val DATA_USERNAME = "data_username"
        const val DATA_AGE = "data_age"
        const val DATA_EMAIL = "data_email"
        const val DATA_GENDER = "data_gender"
    }
}
