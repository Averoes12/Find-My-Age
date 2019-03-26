package com.averoes.daff.findmyage

import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("STATE", "Strarting")

        //todo 1 Membuat parent view

        verticalLayout {
            topPadding = 20
            gravity = Gravity.CENTER_HORIZONTAL

            //todo 2 membuat edit text untuk tanggal lahir

            val birthDay = editText {
                hint = "Enter Year"
                inputType = InputType.TYPE_CLASS_NUMBER
            }.lparams {
                width = matchParent
                height = wrapContent
                gravity = Gravity.CENTER
                leftMargin = 16
                rightMargin = 16
            }
            //todo membuat parent view baru untuk hasil umur dan button
            linearLayout {
                orientation = LinearLayout.HORIZONTAL

                //todo 3 membuat textview untuk menampilkan umur sekarang

                val resultAge = textView {
                    text = "Your Age"
                    textSize = 16F
                    typeface = Typeface.DEFAULT_BOLD
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                }.lparams {
                    width = matchParent
                    height = wrapContent
                    weight = 1F
                }

                //todo 4 membuat Button hitung untuk mengetahui umur kita

                val btn_find = button {
                    text = "My Age Now"
                    //memberi event onclick pada button
                    setOnClickListener {
                        val year = birthDay.text.toString().toInt()
                        //mengambil tanggal sekarang
                        val age = Calendar.getInstance().get(Calendar.YEAR) - year
                        //set Hasil nya ke textview
                        resultAge.text = age.toString()

                        when (age.toString().toInt()) {

                            in 0..13 -> Toast.makeText(this@MainActivity, "Hello Child", Toast.LENGTH_LONG).show()
                            in 14..25 -> Toast.makeText(this@MainActivity, "Hello Young", Toast.LENGTH_LONG).show()
                            in 26..50 -> Toast.makeText(this@MainActivity, "Hello Parent", Toast.LENGTH_LONG).show()
                            in 51..100 -> Toast.makeText(this@MainActivity, "Hello GrandParent", Toast.LENGTH_LONG).show()
                        }
                    }
                }.lparams {
                    width = matchParent
                    height = wrapContent
                    weight = 1F
                }
            }.lparams {
                width = matchParent
                height = wrapContent
                topMargin = 16
            }

        }
    }
}
