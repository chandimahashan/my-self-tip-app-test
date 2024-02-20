package com.example.my1stprojecttipapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var youAmountEnter: EditText
    private lateinit var tipAmountYouAdd: TextView
    private lateinit var totalAmountYouPly: TextView
    private lateinit var enterPercentage: EditText
    private lateinit var button1: Button
    private var enterAmount = "0"
    private var enterPercentageStore = "0"
    private var defaultTip = 1000
    private val tag = "my test"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        youAmountEnter = findViewById(R.id.YouAmountEnter)
        tipAmountYouAdd = findViewById(R.id.TipAmountYouAdd)
        totalAmountYouPly = findViewById(R.id.TotalAmountYouPly)
        enterPercentage = findViewById(R.id.EnterPercentage)


        enterPercentage.setText("5")

        youAmountEnter.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                if (p0.toString().isNotEmpty()) {
                    Log.i(tag, "Enter $p0")
                    enterAmount = p0.toString()
                    if (defaultTip==1000){
                        setTipAndTotalAmount(5)
                    }else {
                        setTipAndTotalAmount(enterPercentageStore.toInt())
                    }
                } else {
                    Log.i(tag, "Enter number $p0")
                    enterAmount = "0"
                    setTipAndTotalAmount(enterPercentageStore.toInt())
                }
            }
        })

        enterPercentage.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                   defaultTip =2000
                if (p0.toString().isNotEmpty()) {
                    Log.i(tag, "enter percentage if $p0")
                    enterPercentageStore = p0.toString()
                    setTipAndTotalAmount(enterPercentageStore.toInt())
                } else {

                    Log.i(tag, "enter percentage else $p0")
                    enterPercentageStore = "0"
                    setTipAndTotalAmount(0)
                }
            }
        })

    }

    private fun setTipAndTotalAmount(enterPercentageStore: Int) {
        Log.i(tag, "SetTipAndTotalAmount enterTip $enterPercentageStore")
        Log.i(tag, "SetTipAndTotalAmount enterAmount $enterAmount")
        tipAmountYouAdd.text = "${enterAmount.toInt() * enterPercentageStore / 100}"
        totalAmountYouPly.text = "${enterAmount.toInt() * enterPercentageStore / 100 + enterAmount.toInt()}"
    }

    fun defaultTipButton(view: View) {
        when(view.id){
            R.id.button1 -> enterPercentage.setText("10")
            R.id.button2 -> enterPercentage.setText("15")
            R.id.button3 -> enterPercentage.setText("20")
            R.id.button4 -> enterPercentage.setText("25")
            R.id.button5 -> enterPercentage.setText("30")
            R.id.button6 -> enterPercentage.setText("35")

        }
    }

}