package com.example.studentslife

object ItemPassiveName {
    var list: List<ItemPassive>

    init {
        list = listOf<ItemPassive>(
            ItemPassive("Шаверма",1,Keys.MINE_ID,1000),
            ItemPassive("Ремонт обуви",2,Keys.LINER_ID,5000),
            ItemPassive("Шашлычка",3,Keys.COMPANY_ID,10000)
        )
    }
    fun getInitialCosts() : List<Int> {
        return listOf(1000,5000,10000)
    }
}