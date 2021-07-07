package com.example.studentslife

object ItemActiveName {
    var list: List<ItemActive>
    init {
        list = listOf<ItemActive>(
            ItemActive("Телефон", 1, Keys.COLLEAGUE_ID,100),
            ItemActive("Компьютер ", 2, Keys.DIPPER_ID,200),
            ItemActive("Мак", 3, Keys.BOER_ID,300)
        )
    }
    fun getInitialCounts() : List<Int> {
        return listOf(100,200,300)
    }
}