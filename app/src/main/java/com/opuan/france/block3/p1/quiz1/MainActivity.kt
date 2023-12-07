package com.opuan.france.block3.p1.quiz1


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var timer: TextView
    lateinit var clicks: TextView

    lateinit var btn_start: Button
    lateinit var btn_click: Button

    var currentTime = 10
    var currentClicks = 0

    lateinit var time: CountDownTimer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timer = findViewById(R.id.timer)
        clicks = findViewById(R.id.clicks)

        btn_start = findViewById(R.id.btn_start)
        btn_click = findViewById(R.id.btn_click)

        btn_click.isEnabled = false

        btn_start.setOnClickListener{

            currentTime = 10
            currentClicks = 0

            timer.text = "Time: $currentTime"
            clicks.text = "Clicks: $currentClicks"

            btn_start.isEnabled = false
            btn_click.isEnabled = true

            time.start()

        }

        btn_click.setOnClickListener{
            currentClicks++;
            clicks.text = "Clicks: $currentClicks"

        }

        time = object : CountDownTimer(10000, 1000){
            override fun onTick(p0: Long) {
                currentTime--
                val Tmr = currentTime + 1
                timer.text = "Time: $Tmr"

            }

            override fun onFinish() {
                timer.text = "Time: 0"

                btn_start.isEnabled = true
                btn_click.isEnabled = false
            }

        }
    }

}