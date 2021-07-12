package com.example.studentslife

object ItemActiveName {
    var list: List<ItemActive>
    init {
        list = listOf<ItemActive>(
            ItemActive("Телефон", 1, Keys.PHONE_ID,100),
            ItemActive("Планшет", 2, Keys.TABLET_ID,215),
            ItemActive("Компьютер", 3, Keys.PC_ID,440),
            ItemActive("Мак", 4, Keys.MAC_ID, 900),
            ItemActive("Камера", 5, Keys.CAMERA_ID, 2000),
            ItemActive("Микрофон", 6, Keys.MICRO_ID, 4160),
            ItemActive("Хромакей", 7, Keys.CHROMAKEY_ID, 8630)
             )
    }
    fun getInitialCounts() : List<Int> {
        return listOf(100,215,440,900,2000,4160,8630)
    }
}
