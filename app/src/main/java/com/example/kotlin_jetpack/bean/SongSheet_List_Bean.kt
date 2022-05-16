package com.example.kotlin_jetpack.bean

import com.google.gson.annotations.SerializedName

data class SongSheet_List_Bean(
    @SerializedName("code")
    val code: Int, // 200
    @SerializedName("privileges")
    val privileges: List<Privilege>,
    @SerializedName("songs")
    val songs: List<Song>
) {
    data class Privilege(
        @SerializedName("chargeInfoList")
        val chargeInfoList: List<ChargeInfo>,
        @SerializedName("cp")
        val cp: Int, // 1
        @SerializedName("cs")
        val cs: Boolean, // false
        @SerializedName("dl")
        val dl: Int, // 0
        @SerializedName("dlLevel")
        val dlLevel: String, // none
        @SerializedName("downloadMaxBrLevel")
        val downloadMaxBrLevel: String, // exhigh
        @SerializedName("downloadMaxbr")
        val downloadMaxbr: Int, // 320000
        @SerializedName("fee")
        val fee: Int, // 8
        @SerializedName("fl")
        val fl: Int, // 128000
        @SerializedName("flLevel")
        val flLevel: String, // standard
        @SerializedName("flag")
        val flag: Int, // 5
        @SerializedName("freeTrialPrivilege")
        val freeTrialPrivilege: FreeTrialPrivilege,
        @SerializedName("id")
        val id: Int, // 4447409
        @SerializedName("maxBrLevel")
        val maxBrLevel: String, // exhigh
        @SerializedName("maxbr")
        val maxbr: Int, // 320000
        @SerializedName("payed")
        val payed: Int, // 0
        @SerializedName("pl")
        val pl: Int, // 128000
        @SerializedName("plLevel")
        val plLevel: String, // standard
        @SerializedName("playMaxBrLevel")
        val playMaxBrLevel: String, // exhigh
        @SerializedName("playMaxbr")
        val playMaxbr: Int, // 320000
        @SerializedName("preSell")
        val preSell: Boolean, // false
        @SerializedName("rscl")
        val rscl: Any?, // null
        @SerializedName("sp")
        val sp: Int, // 7
        @SerializedName("st")
        val st: Int, // 0
        @SerializedName("subp")
        val subp: Int, // 1
        @SerializedName("toast")
        val toast: Boolean // false
    ) {
        data class ChargeInfo(
            @SerializedName("chargeMessage")
            val chargeMessage: Any?, // null
            @SerializedName("chargeType")
            val chargeType: Int, // 0
            @SerializedName("chargeUrl")
            val chargeUrl: Any?, // null
            @SerializedName("rate")
            val rate: Int // 128000
        )

        data class FreeTrialPrivilege(
            @SerializedName("listenType")
            val listenType: Any?, // null
            @SerializedName("resConsumable")
            val resConsumable: Boolean, // false
            @SerializedName("userConsumable")
            val userConsumable: Boolean // false
        )
    }

    data class Song(
        @SerializedName("a")
        val a: Any?, // null
        @SerializedName("al")
        val al: Al,
        @SerializedName("alia")
        val alia: List<Any>,
        @SerializedName("ar")
        val ar: List<Ar>,
        @SerializedName("cd")
        val cd: String, // 1
        @SerializedName("cf")
        val cf: String,
        @SerializedName("copyright")
        val copyright: Int, // 2
        @SerializedName("cp")
        val cp: Int, // 743010
        @SerializedName("crbt")
        val crbt: Any?, // null
        @SerializedName("djId")
        val djId: Int, // 0
        @SerializedName("dt")
        val dt: Int, // 228173
        @SerializedName("entertainmentTags")
        val entertainmentTags: Any?, // null
        @SerializedName("fee")
        val fee: Int, // 8
        @SerializedName("ftype")
        val ftype: Int, // 0
        @SerializedName("h")
        val h: H,
        @SerializedName("hr")
        val hr: Any?, // null
        @SerializedName("id")
        val id: Int, // 4447409
        @SerializedName("l")
        val l: L,
        @SerializedName("m")
        val m: M?,
        @SerializedName("mark")
        val mark: Int, // 270464
        @SerializedName("mst")
        val mst: Int, // 9
        @SerializedName("mv")
        val mv: Int, // 0
        @SerializedName("name")
        val name: String, // Up in the Sky
        @SerializedName("no")
        val no: Int, // 2
        @SerializedName("noCopyrightRcmd")
        val noCopyrightRcmd: Any?, // null
        @SerializedName("originCoverType")
        val originCoverType: Int, // 0
        @SerializedName("originSongSimpleData")
        val originSongSimpleData: Any?, // null
        @SerializedName("pop")
        val pop: Int, // 30
        @SerializedName("pst")
        val pst: Int, // 0
        @SerializedName("publishTime")
        val publishTime: Long, // 1297353600007
        @SerializedName("resourceState")
        val resourceState: Boolean, // true
        @SerializedName("rt")
        val rt: String?,
        @SerializedName("rtUrl")
        val rtUrl: Any?, // null
        @SerializedName("rtUrls")
        val rtUrls: List<Any>,
        @SerializedName("rtype")
        val rtype: Int, // 0
        @SerializedName("rurl")
        val rurl: Any?, // null
        @SerializedName("s_id")
        val sId: Int, // 0
        @SerializedName("single")
        val single: Int, // 0
        @SerializedName("songJumpInfo")
        val songJumpInfo: Any?, // null
        @SerializedName("sq")
        val sq: Any?, // null
        @SerializedName("st")
        val st: Int, // 0
        @SerializedName("t")
        val t: Int, // 0
        @SerializedName("tagPicList")
        val tagPicList: Any?, // null
        @SerializedName("v")
        val v: Int, // 17
        @SerializedName("version")
        val version: Int // 17
    ) {
        data class Al(
            @SerializedName("id")
            val id: Int, // 448710
            @SerializedName("name")
            val name: String, // Up in the Sky
            @SerializedName("pic")
            val pic: Long, // 109951164788991310
            @SerializedName("pic_str")
            val picStr: String, // 109951164788991316
            @SerializedName("picUrl")
            val picUrl: String, // https://p1.music.126.net/Ae0c57ZeP4jKy_QD3FX-Kg==/109951164788991316.jpg
            @SerializedName("tns")
            val tns: List<Any>
        )

        data class Ar(
            @SerializedName("alias")
            val alias: List<Any>,
            @SerializedName("id")
            val id: Int, // 105983
            @SerializedName("name")
            val name: String, // 77 Bombay Street
            @SerializedName("tns")
            val tns: List<Any>
        )

        data class H(
            @SerializedName("br")
            val br: Int, // 320000
            @SerializedName("fid")
            val fid: Int, // 0
            @SerializedName("size")
            val size: Int, // 9129317
            @SerializedName("sr")
            val sr: Int, // 44100
            @SerializedName("vd")
            val vd: Int // -60985
        )

        data class L(
            @SerializedName("br")
            val br: Int, // 128000
            @SerializedName("fid")
            val fid: Int, // 0
            @SerializedName("size")
            val size: Int, // 3651753
            @SerializedName("sr")
            val sr: Int, // 44100
            @SerializedName("vd")
            val vd: Int // -56779
        )

        data class M(
            @SerializedName("br")
            val br: Int, // 192000
            @SerializedName("fid")
            val fid: Int, // 0
            @SerializedName("size")
            val size: Int, // 5477608
            @SerializedName("sr")
            val sr: Int, // 44100
            @SerializedName("vd")
            val vd: Int // -58412
        )
    }
}