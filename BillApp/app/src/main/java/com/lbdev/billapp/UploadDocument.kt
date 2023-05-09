package com.lbdev.billapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class UploadDocument : AppCompatActivity() {
    private lateinit var cameraOpenId: Button
    lateinit var clickImageId: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_document)
        val message = intent.getStringExtra("text_key")
        cameraOpenId = findViewById(R.id.camera_button)
        clickImageId = findViewById(R.id.click_image)

        val doc_text = findViewById<TextView>(R.id.textView_document)
        doc_text.text = message

        cameraOpenId.setOnClickListener{
            val intent = Intent()
            intent.action = Intent.ACTION_GET_CONTENT
            intent.type = "image/*"
            startActivityForResult(intent, 555)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 555){
            clickImageId.setImageURI(data?.data)
            val intent = Intent(this, ConfirmUpload::class.java)
            intent.putExtra("doc_img", data?.data.toString())
            startActivity(intent)
            finish()
        }
    }
}