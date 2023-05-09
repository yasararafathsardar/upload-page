package com.lbdev.billapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class ConfirmUpload : AppCompatActivity() {
    lateinit var docImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_upload)

        docImage = findViewById(R.id.selected_image)
        val confirmUploadBtn = findViewById<Button>(R.id.confirm_btn)
        val retakeBtn = findViewById<Button>(R.id.retake_btn)
        val uriString = intent.getStringExtra("doc_img")
        val imageUri = if (uriString != null) {
            Uri.parse(uriString)
        } else {
            null
        }
        docImage.setImageURI(imageUri)

        confirmUploadBtn.setOnClickListener{
            Toast.makeText(this, "Document Uploaded", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        retakeBtn.setOnClickListener{
            val intent = Intent()
            intent.action = Intent.ACTION_GET_CONTENT
            intent.type = "image/*"
            startActivityForResult(intent, 555)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 555){
            docImage.setImageURI(data?.data)
        }
    }
}