package com.example.calcapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.content.Intent
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.support.design.widget.Snackbar
import kotlin.system.exitProcess
import android.util.Log as Log

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        //初期設定
        var intent = Intent(this, SecondActivity::class.java)
        var input1 = edittext1.text.toString()
        var input2 = edittext2.text.toString()
        var output: Double

        //数値が正しく入力されている場合
        if (input1.isNotEmpty() && input1 != "." &&
            input2.isNotEmpty() && input2 != ".") {
            //足し算
            if (v.id == R.id.button1) {
                output = input1.toDouble() + input2.toDouble()
            //引き算
            } else if (v.id == R.id.button2) {
                output = input1.toDouble() - input2.toDouble()
            //掛け算
            } else if (v.id == R.id.button3) {
                output = input1.toDouble() * input2.toDouble()
            //割り算
            } else {
                    output = input1.toDouble() / input2.toDouble()
            }
            //SecondActivityに引き渡し
            //0除算の場合は、エラーメッセージを表示
            if (output.isInfinite()) {
                var snack = Snackbar.make(v, "0で割ろうとしています", Snackbar.LENGTH_LONG)
                snack.show()
            //outputの引き渡し
            }else {
                intent.putExtra("VALUE1", output)
                startActivity(intent)
            }
        //数値が未入力の場合
        } else {
            var snack = Snackbar.make(v, "何か数値を入力してください", Snackbar.LENGTH_LONG)
            snack.show()
        }
    }
}