package com.lbdev.billapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var documentName: String? = null
        val continueBtn = findViewById<Button>(R.id.continue_btn)
        val radioGroup = findViewById<RadioGroup>(R.id.radio_group)


        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val radioButton = findViewById<RadioButton>(checkedId)
            if (radioButton.text == "Utility Bill") {
                documentName = "Utility Bill"
            } else if (radioButton.text == "Bank Statement") {
                documentName = "Bank Statement"
            } else if (radioButton.text == "Loan Statement") {
                documentName = "Loan Statement"
            } else if (radioButton.text == "Credit Card Statement") {
                documentName = "Credit Card Statement"
            }
        }
        continueBtn.setOnClickListener {
            if (documentName!=null)
            {
                val intent = Intent(this, UploadDocument::class.java)
                intent.putExtra("text_key", documentName)
                startActivity(intent)
                finish()
            }
            else {
                Toast.makeText(this, "Select Document Type", Toast.LENGTH_SHORT).show()
            }
        }

    }
}