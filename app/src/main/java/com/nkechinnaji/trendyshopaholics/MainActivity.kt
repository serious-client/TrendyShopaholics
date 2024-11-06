package com.nkechinnaji.trendyshopaholics

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.nkechinnaji.trendyshopaholics.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val viewBinding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding.salesMsg.setOnClickListener{
            Toast.makeText(this, "Happy Sales Day", Toast.LENGTH_LONG).show()
        }

        viewBinding.storesAround.setOnClickListener{
            Toast.makeText(this, "Find a store you like!", Toast.LENGTH_LONG).show()
        }

        viewBinding.news.setOnClickListener{
            Toast.makeText(this, "Get latest news!", Toast.LENGTH_LONG).show()
        }
    }
}