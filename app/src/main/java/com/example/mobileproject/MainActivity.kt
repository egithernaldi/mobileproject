package com.example.mobileproject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btn_switch: Button
    private lateinit var btnMoveWithDataActivity: Button
    private lateinit var btnMoveWithObject: Button
    private lateinit var btnDialPhone: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_switch = findViewById(R.id.btn_move_activity)
        btn_switch.setOnClickListener(this)

        btnMoveWithDataActivity= findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        btnMoveWithObject= findViewById(R.id.btn_move_activity_object)
        btnMoveWithObject.setOnClickListener(this)

        btnDialPhone= findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MainActivityV2::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_activity_data -> {
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Egit Hernaldi")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 21)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_PRODI, "PTI")
                startActivity(moveWithDataIntent)
            }
            R.id.btn_move_activity_object -> {
                val person = Person(
                    "Egit Hernaldi",
                    21,
                    "egithrnld29@gmail.com",
                    "Padang"
                )
                val moveWithObjectIntent = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }
            R.id.btn_dial_number -> {
                val phoneNumber = "085278063571"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
        }
    }
}