package com.example.kotlin_jetpack.bean

data class SongUrl_Bean(
    val code: Int,
    val `data`: List<Data1>
)

data class Data1(
    val br: Int,
    val canExtend: Boolean,
    val code: Int,
    val encodeType: String,
    val expi: Int,
    val fee: Int,
    val flag: Int,
    val freeTimeTrialPrivilege: FreeTimeTrialPrivilege,
    val freeTrialInfo: Any,
    val freeTrialPrivilege: FreeTrialPrivilege1,
    val gain: Double,
    val id: Long,
    val level: String,
    val md5: String,
    val payed: Int,
    val size: Int,
    val type: String,
    val uf: Any,
    val url: String,
    val urlSource: Int
)

data class FreeTimeTrialPrivilege(
    val remainTime: Int,
    val resConsumable: Boolean,
    val type: Int,
    val userConsumable: Boolean
)

data class FreeTrialPrivilege1(
    val listenType: Any,
    val resConsumable: Boolean,
    val userConsumable: Boolean
)