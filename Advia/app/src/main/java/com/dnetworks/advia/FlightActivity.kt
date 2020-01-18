package com.dnetworks.advia

import android.app.DatePickerDialog
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_flight.*
import java.util.*

class FlightActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        attaching Flight layout to kotlin file
        setContentView(R.layout.activity_flight)

        //calendar
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)

        depart.setOnClickListener {
            val dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { datePicker, iyear,imonth, iday ->
                val tempMonth=1+imonth
                depart.setText(""+iyear+"-"+iday+"-"+tempMonth)
            },year,month,day)
            dpd.show()
        }
        returnBut.setOnClickListener {
            val dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { datePicker, iyear,imonth, iday ->
                val tempMonth=1+imonth
                returnBut.setText(""+iyear+"-"+iday+"-"+tempMonth)
            },year,month,day)
            dpd.show()
        }

//        search Button
        search_button.setOnClickListener {

            val inboundDate = returnBut.text.toString()
            val cabinClass="business"
            val children="0"
            val infants ="0"
            val country ="US"
            val currency ="USD"
            val locale="en-US"
            val originPlace =startingPoint.text.toString()
            val destinationPlace =destination.text.toString()
            val outboundDate =depart.text.toString()
            val adults="1"
            if(destinationPlace.equals("") and originPlace.equals("")){
                Toast.makeText(this,"Invalid input",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,inboundDate+outboundDate+originPlace+destinationPlace,Toast.LENGTH_SHORT).show()
            }

        }
    }

}