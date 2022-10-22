package com.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TimePicker

class TimePickerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_picker)
         val timePicker=findViewById<TimePicker>(R.id.timePicker1)


    }
}