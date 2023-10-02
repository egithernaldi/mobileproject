package com.example.mobileproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var inputpanjang: EditText
    private lateinit var inputlebar: EditText
    private lateinit var inputtinggi: EditText
    private lateinit var btn: Button
    private lateinit var tekshasil: TextView

    companion object{
        private const val STATE_RESULT  = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        inisial Variable
        inputpanjang = findViewById(R.id.panjang)
        inputlebar = findViewById(R.id.lebar)
        btn = findViewById(R.id.tombol)
        inputtinggi = findViewById(R.id.height)
        tekshasil = findViewById(R.id.hasil)

        btn.setOnClickListener(this)

        if (savedInstanceState != null) {
            tekshasil.text = savedInstanceState.getString(STATE_RESULT)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tekshasil.text.toString())
    }

    override fun onClick(v: View?) {
        if (v?.id==R.id.tombol){
            val panjang = inputpanjang.text.toString().trim()
            val lebar = inputlebar.text.toString().trim()
            val tinggi = inputtinggi.text.toString()
            val volume = panjang.toDouble()*lebar.toDouble()*tinggi.toDouble()
            tekshasil.text = volume.toString()
        }
    }
}