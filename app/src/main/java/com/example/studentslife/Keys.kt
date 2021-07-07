package com.example.studentslife

class Keys {
    companion object {
        val DATA_ABOUT_APP = "data" // Название файла SharedPreferences

        val COUNT_OF_MONEY = "money" // Значение в SharedPreferenec, которое соответсвует текущему значению
                                 //     валюты

        val INCREASE_MONEY = "increase" // Значение пассивного дохода в SharedPref. То число, на которое
                                      //    каждую секунду будет расти счётчик

        val CLICK_INCREASE_MONEY = "click_increase" // Значение, на которое будет увеличиваться счётчик
                                                  //    валюты при клике на кнопку
        val COLLEAGUE_ID = "colleague"

        val DIPPER_ID = "dipper"

        val BOER_ID = "boer"

        val MINE_ID = "mine"

        val LINER_ID = "liner"

        val COMPANY_ID = "company"

    }
}