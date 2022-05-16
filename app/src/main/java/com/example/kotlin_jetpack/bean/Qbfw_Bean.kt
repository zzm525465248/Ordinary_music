package com.example.kotlin_jetpack.bean

data class Qbfw_Bean(
    val code: Int,
    val `data`: List<Datas>,
    val message: String
)

data class Datas(
    val homepageMode: String,
    val iconUrl: String,
    val id: Int,
    val name: String,
    val skinSupport: Boolean,
    val url: String
)