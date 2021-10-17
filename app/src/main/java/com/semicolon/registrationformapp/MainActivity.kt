package com.semicolon.registrationformapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpSpinner()
        setUpButton()
    }

    private fun setUpSpinner() {
        val titles = arrayOf("Miss", "Mrs", "Ms", "Mr", "Mx", "Dr", "Prof")
        val titleAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, titles)
        spinner_title.adapter = titleAdapter

    }

    private fun setUpButton() {
        button_create_account.setOnClickListener {
            createAccount()
        }

    }

    private fun createAccount(){
        val user = User(
            spinner_title.selectedItem as String,
            text_input_edit_text_first_name.text.toString(),
            text_input_edit_text_last_name.text.toString(),
            text_input_edit_text_email.text.toString(),
            text_input_edit_text_phone_number.text.toString(),
            text_input_edit_text_password.text.toString()
        )

        val intent = Intent(this, SummaryActivity::class.java)
        intent.putExtra("User", user)
        startActivity(intent)
    }
}