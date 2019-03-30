package com.googry.googrydrawerlayoutlesson

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dl_root.addDrawerListener(object :
            DrawerLayout.DrawerListener {
            override fun onDrawerStateChanged(newState: Int) {
                // 현재 멈춘상태인지, 스크롤이 되고있는 상태인지
//                DrawerLayout.STATE_IDLE
//                DrawerLayout.STATE_DRAGGING
//                DrawerLayout.STATE_SETTLING

                when (newState) {
                    DrawerLayout.STATE_IDLE -> {
                        Log.d("googry", "DrawerLayout.STATE_IDLE")
                    }
                    DrawerLayout.STATE_DRAGGING -> {
                        Log.d("googry", "DrawerLayout.STATE_DRAGGING")
                    }
                    DrawerLayout.STATE_SETTLING -> {
                        Log.d("googry", "DrawerLayout.STATE_SETTLING")
                    }
                }

            }

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                // Drawer Slide 되고 있을 때.
                Log.d("googry", "slideOffset $slideOffset")
                // 밀기
                when (drawerView.id) {
                    R.id.fl_left_side -> {
                        cl_main_content.translationX = slideOffset * cl_main_content.width / 2
                    }
                    R.id.fl_right_side -> {
                        cl_main_content.translationX = -slideOffset * cl_main_content.width / 2
                    }
                }

                // 회전
                when (drawerView.id) {
                    R.id.fl_left_side -> {
                        cl_main_content.rotationY = (-slideOffset * 15)
                    }
                    R.id.fl_right_side -> {
                        cl_main_content.rotationY = (+slideOffset * 15)
                    }
                }

                // 크기
                cl_main_content.scaleX = (1 - (slideOffset * 0.2)).toFloat()
                cl_main_content.scaleY = (1 - (slideOffset * 0.2)).toFloat()

            }

            override fun onDrawerClosed(drawerView: View) {
                // Drawer 닫혔을때
                Log.d("googry", "Drawer 닫혔을때")
            }

            override fun onDrawerOpened(drawerView: View) {
                // Drawer 열렸을때
                Log.d("googry", "Drawer 열렸을때")
            }
        })
        
        btn_open_left.setOnClickListener {
            dl_root.openDrawer(fl_left_side)
        }
        btn_open_left_non_animate.setOnClickListener {
            dl_root.openDrawer(fl_left_side, false)
        }
        btn_open_right.setOnClickListener {
            dl_root.openDrawer(fl_right_side)
        }
        btn_open_right_non_animate.setOnClickListener {
            dl_root.openDrawer(fl_right_side, false)
        }
    }
}
