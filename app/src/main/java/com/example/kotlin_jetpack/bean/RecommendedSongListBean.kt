package com.example.kotlin_jetpack.bean

data class RecommendedSongListBean(
    val category: Int,
    val code: Int,
    val hasTaste: Boolean,
    val result: List<Results>
)

data class Results(
    val alg: String,
    val canDislike: Boolean,
    val copywriter: String,
    val highQuality: Boolean,
    val id: Long,
    val name: String,
    val picUrl: String,
    val playCount: Int,
    val trackCount: Int,
    val trackNumberUpdateTime: Long,
    val type: Int
)