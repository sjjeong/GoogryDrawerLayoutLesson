package com.googry.googrydrawerlayoutlesson

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_open_left.setOnClickListener {
            dl_root.openDrawer(fl_left_side)
        }
        btn_open_left_non_animate.setOnClickListener {
            dl_root.openDrawer(fl_left_side, false)
        }
    }
}
