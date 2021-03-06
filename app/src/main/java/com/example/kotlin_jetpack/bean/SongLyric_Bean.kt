package com.example.kotlin_jetpack.bean

data class SongLyric_Bean(
    val code: Int,
    val klyric: Klyric,
    val lrc: Lrc,
    val qfy: Boolean,
    val sfy: Boolean,
    val sgc: Boolean,
    val tlyric: Tlyric
)

data class Klyric(
    val lyric: String,
    val version: Int
)

data class Lrc(
    val lyric: String,
    val version: Int
)

data class Tlyric(
    val lyric: String,
    val version: Int
)