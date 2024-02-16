package com.example.my1stprojecttipapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.widget.addTextChangedListener


class MainActivity : AppCompatActivity() {

    private lateinit var youAmountEnter: EditText
    private lateinit var setTipChange: SeekBar
    private lateinit var setTip: TextView
    private lateinit var tipAmountYouAdd: TextView
    private lateinit var totalAmountYouPly: TextView
    private lateinit var enterPercentage:EditText
    private  var enterAmount = "0"
    private var enterTip = 0
    private var enterPercentageStore = "0"

    private val tag = "my test"
    //private val tipProgress = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        youAmountEnter = findViewById(R.id.YouAmountEnter)
        setTipChange = findViewById(R.id.SetTipChange)
        setTip = findViewById(R.id.SetTip)
        tipAmountYouAdd = findViewById(R.id.TipAmountYouAdd)
        totalAmountYouPly = findViewById(R.id.TotalAmountYouPly)
        enterPercentage = findViewById(R.id.EnterPercentage)

        youAmountEnter.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                if (p0.toString().isNotEmpty()){
                    Log.i(tag, "Enter $p0")
                    enterAmount = p0.toString()
                    SetTipAndTotalAmount(enterTip)

                }
                else{
                    Log.i(tag, "Enter number $p0")
                    enterAmount = "0"
                    SetTipAndTotalAmount(enterTip)

                }
            }
        })
     //  setTipChange.progress = enterPercentageStore.toInt()
//        setTip.text = " Set Tip $tipProgress%"
         // SetTipAndTotalAmount(enterPercentageStore.toInt())
        setTipChange.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                Log.i(tag, "Enter Seek bar $p1")
                val setTipValue = p1.toString()
                setTip.text = "Set Tip Percentage = $setTipValue%"
                enterTip = p1
                SetTipAndTotalAmount(enterTip)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })
        enterPercentage.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {


                if (p0.toString().isNotEmpty()){
                    enterPercentageStore =p0.toString()
                    setTipChange.progress = enterPercentageStore.toInt()
                    SetTipAndTotalAmount(enterPercentageStore.toInt())

                }
                else{

                    setTipChange.progress = 0
                    SetTipAndTotalAmount(0)

                }
            }
        })


    }

    private fun SetTipAndTotalAmount(enterTip: Int) {
        tipAmountYouAdd.text = "${enterAmount.toInt()*enterTip/100}"
        totalAmountYouPly.text = "${enterAmount.toInt()*enterTip/100+enterAmount.toInt()}"
    }


}