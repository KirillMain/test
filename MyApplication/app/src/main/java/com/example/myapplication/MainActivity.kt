package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ActionMenuView
import android.widget.TextView
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//    val - считывание
//    var - считывание и записывание
//    val zxc:Int = 5
//    val qwe:Float = 5.6f

    lateinit var bindingClass : ActivityMainBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        var num = ""
        var res : Double = 0.0

        fun Calculations() : String {
            var ind: Int
            var num1: Double
            var num2: Double
            var bool = false

            if (num.indexOf("-") != -1 && num.indexOf("-") == 0) {
                bool = true
                num = num.substring(1, num.length)
            }

            if (num.indexOf("%") != -1) {
                ind = num.indexOf("%")
                num1 = num.substring(0, ind).toDouble()
                res = num1 / 100
            }
            if (num.indexOf("+") != -1) {
                ind = num.indexOf("+")
                num1 = num.substring(0, ind).toDouble()
                if (bool) {
                    var xer = "-"
                    xer += num1.toString()
                    num1 = xer.toDouble()
                }
                num2 = num.substring(ind + 1, num.length).toDouble()
                res = num1 + num2
            }
            if (num.indexOf("/") != -1) {
                ind = num.indexOf("/")
                num1 = num.substring(0, ind).toDouble()
                if (bool) {
                    var xer = "-"
                    xer += num1.toString()
                    num1 = xer.toDouble()
                }
                num2 = num.substring(ind + 1, num.length).toDouble()
                res = num1 / num2
            }
            if (num.indexOf("*") != -1) {
                ind = num.indexOf("*")
                num1 = num.substring(0, ind).toDouble()
                if (bool) {
                    var xer = "-"
                    xer += num1.toString()
                    num1 = xer.toDouble()
                }
                num2 = num.substring(ind + 1, num.length).toDouble()
                res = num1 * num2
            }
            if (num.indexOf("-") != -1  &&  num.indexOf("-") != 0) {
                ind = num.indexOf("-")
                num1 = num.substring(0, ind).toDouble()
                if (bool) {
                    var xer = "-"
                    xer += num1.toString()
                    num1 = xer.toDouble()
                }
                num2 = num.substring(ind + 1, num.length).toDouble()
                res = num1 - num2
            }

            num = res.toString()
            if (num.indexOf("0") == num.length-1  &&  num.indexOf(".") == num.length-2)
                num = num.substring(0, num.length - 2)

            if (num.length >= 8) {
                bindingClass.textViewRes.text = num.substring(0, 7)
                bindingClass.textViewVvod.text = num.substring(0, 7)
            }
            else {
                bindingClass.textViewRes.text = num
                bindingClass.textViewVvod.text = num
            }
            return num
        }

        fun Check(num : String) : String{
            var numX = ""

            if (num.indexOf("+") == num.length-1
                || num.indexOf("-") == num.length-1
                || num.indexOf("/") == num.length-1
                || num.indexOf("*") == num.length-1 ) {
                numX = num.substring(0, num.length-1)
                return numX
            }
            else if (num.indexOf("+") != -1 || num.indexOf("-") != -1 || num.indexOf("/") != -1 || num.indexOf("%") != -1 || num.indexOf("*") != -1) {
                numX = Calculations()
                return numX
            }
            else
                return num
        }

        bindingClass.button0.setOnClickListener {
                if (num != "0")
                    num += "0"
                bindingClass.textViewVvod.text = num
        }

        bindingClass.button1.setOnClickListener {
                num += "1"
                bindingClass.textViewVvod.text = num
        }

        bindingClass.button2.setOnClickListener {
                num += "2"
                bindingClass.textViewVvod.text = num
        }

        bindingClass.button3.setOnClickListener {
                num += "3"
                bindingClass.textViewVvod.text = num
        }

        bindingClass.button4.setOnClickListener {
                num += "4"
                bindingClass.textViewVvod.text = num
        }

        bindingClass.button5.setOnClickListener {
                num += "5"
                bindingClass.textViewVvod.text = num
        }

        bindingClass.button6.setOnClickListener {
                num += "6"
                bindingClass.textViewVvod.text = num
        }

        bindingClass.button7.setOnClickListener {
                num += "7"
                bindingClass.textViewVvod.text = num
        }

        bindingClass.button8.setOnClickListener {
                num += "8"
                bindingClass.textViewVvod.text = num
        }

        bindingClass.button9.setOnClickListener {
                num += "9"
                bindingClass.textViewVvod.text = num
        }

        bindingClass.buttonDel.setOnClickListener {
            if (num == "") {
                bindingClass.textViewVvod.text = "0"
            }
            else {
                num = num.substring(0, num.length - 1)
                bindingClass.textViewVvod.text = num
            }
        }

        bindingClass.buttonPlus.setOnClickListener {
            num = Check(num)
            num += "+"
            bindingClass.textViewVvod.text = num
        }

        bindingClass.buttonMinus.setOnClickListener {
            num = Check(num)
            num += "-"
            bindingClass.textViewVvod.text = num
        }

        bindingClass.buttonYmnoz.setOnClickListener {
            num = Check(num)
            num += "*"
            bindingClass.textViewVvod.text = num
        }

        bindingClass.buttonProcent.setOnClickListener {
            num = Check(num)
            num += "%"
            bindingClass.textViewVvod.text = num
        }

        bindingClass.buttonDelen.setOnClickListener {
            num = Check(num)
            num += "/"
            bindingClass.textViewVvod.text = num
        }

        bindingClass.buttonZap.setOnClickListener {
            num += "."
            bindingClass.textViewVvod.text = num
        }

        bindingClass.buttonRavn.setOnClickListener {
            if (num != "")
                Check(num)
            else
                bindingClass.textViewRes.text = "Eblan?"
        }

        bindingClass.buttonAC.setOnClickListener {
            num = ""
            res = 0.0
            bindingClass.textViewRes.text = "0"
            bindingClass.textViewVvod.text = "0"
        }

        bindingClass.buttonScobki.setOnClickListener{
            bindingClass.textViewVvod.text = "Иди на хуй"
            bindingClass.textViewRes.text = "долго делать"
        }
    }
}
