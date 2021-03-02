package com.example.androiddevchallenge

class DogRepository {

    val list = listOf<Dog>(
        Dog("taro", 0, R.drawable.dog1, "生まれたばかりのかわいい柴犬"),
        Dog("jiro", 2, R.drawable.dog2, "細めた目がかわいい柴犬"),
        Dog("sabro", 5, R.drawable.dog3, "きりっとした顔がかわいい柴犬"),
        Dog("siro", 4, R.drawable.dog4, "出した舌がかわいい柴犬"),
        Dog("goro", 2, R.drawable.dog5, "コロンとした姿がかわいい柴犬")
    )

    fun getDogData(): List<Dog> {
        return list
    }
}

data class Dog(val name: String, val age: Int, val image: Int, val descript: String)