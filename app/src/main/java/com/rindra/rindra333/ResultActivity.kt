package com.rindra.rindra333

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rindra.rindra333.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fullName = intent.getStringExtra(MainActivity.DATA_FULL_NAME)
        val username = intent.getStringExtra(MainActivity.DATA_USERNAME)
        val age = intent.getStringExtra(MainActivity.DATA_AGE)
        val email = intent.getStringExtra(MainActivity.DATA_EMAIL)
        val gender = intent.getStringExtra(MainActivity.DATA_GENDER)

        binding.apply {
            tvFullNameResult.text = "Full Name: $fullName"
            tvUsernameResult.text = "Username: $username"
            tvAgeResult.text = "Age: $age"
            tvEmailResult.text = "Email: $email"
            tvGenderResult.text = "Gender: $gender"

            if (gender == "Laki-laki") {
                tvGenderResult.setTextColor(Color.BLUE)
            } else {
                tvGenderResult.setTextColor(Color.MAGENTA)
            }
        }
    }

    companion object {
        const val  DATA_NAMA = "data_nama"
        const val  DATA_JK = "data_jk"
        const val  DATA_SETUJU = "data_setuju"
    }

}
