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

        var sp = getSharedPreferences(Keys.DATA_ABOUT_APP, Context.MODE_PRIVATE)

        checkSharedPref(sp)

        startService() // если уже запущен, то повторного запуска не будет(смотреть реализацию)

        getCountOfOil(sp)

        btnGoToShop.setOnClickListener {
            startActivity(Intent(this, ShopActivity::class.java))
        }

        btnClick.setOnClickListener {
            var counter = sp.getLong(Keys.COUNT_OF_MONEY,0)
            counter += sp.getLong(Keys.CLICK_INCREASE_MONEY,0)
            sp.edit().apply {
                putLong(Keys.COUNT_OF_MONEY, counter)
                apply()
            }
            tvMoneyCounter.text = "${sp.getLong(Keys.COUNT_OF_MONEY,0)}"
        }


    }

    private fun getCountOfOil(sp: SharedPreferences) {
        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                var counter = sp.getLong(Keys.COUNT_OF_MONEY,0)
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
    private fun checkSharedPref(sp: SharedPreferences) {
        if(!sp.contains(Keys.COUNT_OF_MONEY)) {
            sp.edit().apply {
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