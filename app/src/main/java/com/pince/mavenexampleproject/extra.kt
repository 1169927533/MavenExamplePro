package com.pince.mavenexampleproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

/**
 * @Author Yu
 * @Date 2021/1/18 16:06
 * @Description TODO
 */
inline fun <reified T : AppCompatActivity> AppCompatActivity.startActivity(context: Context) {
    startActivity(Intent(context, T::class.java))
}