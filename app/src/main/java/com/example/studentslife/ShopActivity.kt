package com.example.studentslife

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.studentslife.one.OneAdapter
import com.example.studentslife.two.TwoAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_shop.*
import kotlinx.android.synthetic.main.item_view.*
import java.util.*
import kotlin.math.pow

class ShopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        var sp = getSharedPreferences(Keys.DATA_ABOUT_APP, Context.MODE_PRIVATE)

        getCountOfMoney(sp)

        rvActiveImprovements.adapter = OneAdapter(ItemActiveName.list, { itemActive: ItemActive, textView: TextView ->
            var counter = sp.getLong(Keys.COUNT_OF_MONEY,0)
            if (counter<itemActive.cost){
                Toast.makeText(this,"У тебя нет денег, иди работай", Toast.LENGTH_SHORT).show()
            }
            else{
                sp.edit().apply {
                    putLong(Keys.COUNT_OF_MONEY,counter-itemActive.cost)
                    putInt(itemActive.id,sp.getInt(itemActive.id,0)+1)
                    putLong(Keys.CLICK_INCREASE_MONEY,
                        sp.getLong(Keys.CLICK_INCREASE_MONEY,0)+itemActive.upgrade)
                    apply()
                }
                textView.text = sp.getInt(itemActive.id,0).toString()
                itemActive.cost = (itemActive.cost*1.2).toInt()
                shopMoneyField.text = "${sp.getLong(Keys.COUNT_OF_MONEY,0)}"
            }
        },
            { itemActive: ItemActive, textView: TextView ->
                var sp = getSharedPreferences(Keys.DATA_ABOUT_APP, Context.MODE_PRIVATE)
                if(ItemActiveName.getInitialCounts().contains(itemActive.cost)) {
                    itemActive.cost =
                        (1.2.pow(sp.getInt(itemActive.id, 0).toDouble()) * itemActive.cost).toInt()
                }
                textView.text = sp.getInt(itemActive.id,0).toString()
        })

        rvPassiveImprovements.adapter = TwoAdapter(ItemPassiveName.list, { itemPassive: ItemPassive, textView: TextView ->
            var counter = sp.getLong(Keys.COUNT_OF_MONEY,0)
            if (counter<itemPassive.cost){
                Toast.makeText(this,"У тебя нет денег, иди работай",Toast.LENGTH_SHORT).show()
            }
            else {
                sp.edit().apply {
                    putLong(Keys.COUNT_OF_MONEY, counter - itemPassive.cost)
                    putInt(itemPassive.id, sp.getInt(itemPassive.id, 0) + 1)
                    putLong(Keys.INCREASE_MONEY,
                        sp.getLong(Keys.INCREASE_MONEY,0)+itemPassive.upgrade)
                    apply()
                }
                textView.text = sp.getInt(itemPassive.id, 0).toString()
                itemPassive.cost = (itemPassive.cost*1.2).toInt()
                shopMoneyField.text = "${sp.getLong(Keys.COUNT_OF_MONEY,0)}"
            }
        },
            {
                itemPassive: ItemPassive, textView: TextView ->
                var sp = getSharedPreferences(Keys.DATA_ABOUT_APP,Context.MODE_PRIVATE)
                if(ItemPassiveName.getInitialCosts().contains(itemPassive.cost)) {
                    itemPassive.cost = (1.2.pow(
                        sp.getInt(itemPassive.id, 0).toDouble()
                    ) * itemPassive.cost).toInt()
                }
                textView.text = sp.getInt(itemPassive.id, 0).toString()
            })


        btnGoToMain.setOnClickListener {
            onBackPressed()
        }
    }

    private fun getCountOfMoney(sp: SharedPreferences) {
        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                var counter = sp.getLong(Keys.COUNT_OF_MONEY,0)
                runOnUiThread(Runnable {
                    shopMoneyField.text = "${counter}"
                })
            }
        }, 0, 1100)
    }

}