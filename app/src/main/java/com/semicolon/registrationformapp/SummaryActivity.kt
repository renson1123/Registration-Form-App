package com.semicolon.registrationformapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_summary.*

class SummaryActivity : AppCompatActivity() {

    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)
        retrieveUser()
        dispayUser()
        setUpClickListeners()


    }

    private fun retrieveUser() {
        user = intent.getSerializableExtra("User") as User

    }

    private fun dispayUser() {
        text_view_user_full_name.text = user.getFullName()
        text_view_email.text = user.email
        text_view_phone_number.text = user.phone
    }

    private fun setUpClickListeners() {
        text_view_email.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:${user.email}")
            startActivity(intent)
        }

        text_view_phone_number.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${user.phone}")
            startActivity(intent)

        }

    }
}