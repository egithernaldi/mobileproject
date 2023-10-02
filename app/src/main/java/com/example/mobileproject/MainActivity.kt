package com.example.mobileproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btn_switch: Button
    private lateinit var btnMoveWithDataActivity: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_switch = findViewById(R.id.btn_move_activity)
        btn_switch.setOnClickListener(this)

        btnMoveWithDataActivity= findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)

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
        }
    }
}