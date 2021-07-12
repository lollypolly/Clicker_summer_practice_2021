package com.example.studentslife

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.studentslife.IncreaseCountOfMoney
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var am = getSharedPreferences(Keys.DATA_ABOUT_APP, Context.MODE_PRIVATE)

        checkSharedPref(am)

        startService()

        getCountOfMoney(am)

        btnGoToShop.setOnClickListener {
            startActivity(Intent(this, ShopActivity::class.java))
        }

        btnClick.setOnClickListener {
            var counter = am.getLong(Keys.COUNT_OF_MONEY,0)
            counter += am.getLong(Keys.CLICK_INCREASE_MONEY,0)
            am.edit().apply {
                putLong(Keys.COUNT_OF_MONEY, counter)
                apply()
            }
            tvMoneyCounter.text = "${am.getLong(Keys.COUNT_OF_MONEY,0)}"
        }


    }

    private fun getCountOfMoney(am : SharedPreferences) {
        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                var counter = am.getLong(Keys.COUNT_OF_MONEY,0)
                runOnUiThread(Runnable {
                    tvMoneyCounter.text = "${counter}"
                })
            }
        }, 0, 1100)
    }
    private fun startService() {
        var service = IncreaseCountOfMoney::class.java
        if(!isMyServiceRunning(service)) {
            startService(Intent(this, IncreaseCountOfMoney::class.java).apply {
                action = "start"
            })
        }
    }
    private fun checkSharedPref(am: SharedPreferences) {
        if(!am.contains(Keys.COUNT_OF_MONEY)) {
            am.edit().apply {
                putLong(Keys.COUNT_OF_MONEY,0)
                putLong(Keys.INCREASE_MONEY,0)
                putLong(Keys.CLICK_INCREASE_MONEY,1)
                apply()
            }
        }
    }
    private fun isMyServiceRunning(serviceClass: Class<*>): Boolean {
        val manager =
            getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        for (service in manager.getRunningServices(Int.MAX_VALUE)) {
            if (serviceClass.name == service.service.className) {
                return true
            }
        }
        return false
    }


}