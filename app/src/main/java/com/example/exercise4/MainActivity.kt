package com.example.exercise4

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var age = 0
    var invest = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val c: Calendar = Calendar.getInstance()
        val mYear = c.get(Calendar.YEAR)
        val mMonth = c.get(Calendar.MONTH)
        val mDay = c.get(Calendar.DAY_OF_MONTH)


        txtDOB.setOnClickListener(){
            val dpd = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener{
                    view, year, monthOfYear, dayOfMonth ->
                    //display selected date in txtview
                    age = mYear - year
                    txtDOB.setText("%d-%d-%d".format(dayOfMonth, monthOfYear, year))
                }, mYear, mMonth, mDay)
            dpd.show()
        }

        btnOK.setOnClickListener(){
            txtAge.setText(age.toString())
            invest = getBasicSaving()
            txtMin.setText(invest.toString())
            txtInvest.setText((invest*0.3).toString())

        }

        btnReset.setOnClickListener(){
            txtDOB.setText("Select")
            txtAge.setText("")
            txtMin.setText("")
            txtInvest.setText("")
        }

    }

    fun getBasicSaving():Double{
        var value = 0.00
        if(age>=16 && age<=20)
            value = 5000.00
        else if(age>=21 && age<=25)
            value = 14000.00
        else if(age>=26 && age<=30)
            value = 29000.00
        else if(age>=31 && age<=35)
            value = 50000.00
        else if(age>=36 && age<=40)
            value = 78000.00
        else if(age>=41 && age<=45)
            value = 116000.00
        else if(age>=46 && age<=50)
            value = 165000.00
        else if(age>=51 && age<=55)
            value = 228000.00
        else
            value = 0.00
        return value
    }
}
