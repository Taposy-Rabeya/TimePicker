package com.example.timepicker

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import com.example.timepicker.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.timePicker.setIs24HourView(true)

       // val calendar = Calendar.getInstance()

        binding.btnSelect.setOnClickListener {
            binding.apply {

//                var time = "${timePicker.currentHour} : ${timePicker.currentMinute} ${formattedDate}"
//                tvResult.setText(time)

                onTimeSet(binding.timePicker, timePicker.currentHour, timePicker.currentMinute)

            }

//        binding.btnSelect.setOnClickListener {
//            val timeSetListener = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
//                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
//                calendar.set(Calendar.MINUTE, minute)
//                binding.tvResult.text = SimpleDateFormat("HH:mm").format(calendar.time)
//            }
//            TimePickerDialog(this, timeSetListener, calendar.get(Calendar.HOUR_OF_DAY),
//                calendar.get(Calendar.MINUTE), true).show()
//        }

//        binding.timePicker.setOnTimeChangedListener { view, hourOfDay, minute ->
//            val dayHour = when {
//                hourOfDay == 0 -> {
//                    hourOfDay + 12
//                }
//                hourOfDay > 12 -> {
//                    hourOfDay - 12
//                }
//                else -> hourOfDay
//            }
//            val format = when {
//                hourOfDay >= 12 -> {
//                    "PM"
//                }
//                else -> "AM"
//            }
//            val hour = if (dayHour < 10) "0$dayHour" else dayHour
//            val min = if (minute < 10) "0$minute" else minute
//            val currentTime =
//                getString(R.string.selected_time) + " " + hour + " : " + min + " " + format
//            binding.tvResult.text = currentTime
        }

    }


    fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        var am_pm = ""
        val datetime: Calendar = Calendar.getInstance()
        datetime.set(Calendar.HOUR_OF_DAY, hourOfDay)
        datetime.set(Calendar.MINUTE, minute)
        if (datetime.get(Calendar.AM_PM) === Calendar.AM) am_pm = "AM" else if (datetime.get(
                Calendar.AM_PM
            ) === Calendar.PM
        ) am_pm = "PM"
        var strHrsToShow =
            if (datetime.get(Calendar.HOUR) === 0) "12" else Integer.toString(datetime.get(Calendar.HOUR))

//        if (strHrsToShow.length <= 1){
//            strHrsToShow == "0$strHrsToShow"
//        }
        binding.tvResult.setText(

            strHrsToShow + ":" + datetime.get(
                Calendar.MINUTE
            ) + " " + am_pm
        )
    }
}

