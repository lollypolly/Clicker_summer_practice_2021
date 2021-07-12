package com.example.studentslife

object ItemPassiveName {
    var list: List<ItemPassive>

    init {
        list = listOf<ItemPassive>(
            ItemPassive("Шаверма",1,Keys.SHAVERMA_ID,1000),
            ItemPassive("Ремонт обуви",2,Keys.SHOESREPAIR_ID,2250),
            ItemPassive("Шашлычка",3,Keys.SHASHLIK_ID,5000),
            ItemPassive("Пятерочка", 4, Keys.SHOPFIVE_ID, 11000),
            ItemPassive("Салон связи", 5, Keys.COMMUNICATIONSSHOP_ID, 25000),
            ItemPassive("Официант", 6, Keys.WAITER_ID, 57000),
            ItemPassive("Банк", 7, Keys.BANK_ID, 125000)
        )
    }
    fun getInitialCosts() : List<Int> {
        return listOf(1000,2250,5000,11000,25000,57000,125000)
    }
}