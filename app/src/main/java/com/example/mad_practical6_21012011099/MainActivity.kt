package com.example.mad_practical6_21012011099

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var play:FloatingActionButton = findViewById(R.id.play)
        var stop:FloatingActionButton = findViewById(R.id.stop)
        var Flag:Boolean=false

        play.setOnClickListener(){
            if(Flag==false)
            {
                play.setImageDrawable(resources.getDrawable(R.drawable.baseline_pause_24))
                Flag=true
            }
            else
            {
                play.setImageDrawable(resources.getDrawable(R.drawable.baseline_play_arrow_24))
                Flag=false
            }
            play()
        }

        stop.setOnClickListener(){
            if(Flag==true)
            {
                play.setImageDrawable(resources.getDrawable(R.drawable.baseline_play_arrow_24))
                Flag=false
            }
            stop()
        }
    }

    fun play(){
        Intent(applicationContext,MyService::class.java).putExtra(MyService.PLAYERKEY,MyService.PLAYERVALUE).apply{
            startService(this)
        }
    }
    fun stop(){
        Intent(applicationContext,MyService::class.java).putExtra(MyService.PLAYERKEY,MyService.PLAYERVALUE).apply{
            stopService(this)
        }
    }
}