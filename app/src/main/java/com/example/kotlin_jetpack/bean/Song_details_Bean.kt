package com.example.kotlin_jetpack.bean
import com.google.gson.annotations.SerializedName


data class Song_details_Bean(
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
        val cp: Int, // 0
        @SerializedName("cs")
        val cs: Boolean, // false
        @SerializedName("dl")
        val dl: Int, // 0
        @SerializedName("dlLevel")
        val dlLevel: String, // none
        @SerializedName("downloadMaxBrLevel")
        val downloadMaxBrLevel: String, // lossless
        @SerializedName("downloadMaxbr")
        val downloadMaxbr: Int, // 999000
        @SerializedName("fee")
        val fee: Int, // 1
        @SerializedName("fl")
        val fl: Int, // 0
        @SerializedName("flLevel")
        val flLevel: String, // none
        @SerializedName("flag")
        val flag: Int, // 260
        @SerializedName("freeTrialPrivilege")
        val freeTrialPrivilege: FreeTrialPrivilege,
        @SerializedName("id")
        val id: Int, // 347230
        @SerializedName("maxBrLevel")
        val maxBrLevel: String, // lossless
        @SerializedName("maxbr")
        val maxbr: Int, // 999000
        @SerializedName("payed")
        val payed: Int, // 0
        @SerializedName("pl")
        val pl: Int, // 0
        @SerializedName("plLevel")
        val plLevel: String, // none
        @SerializedName("playMaxBrLevel")
        val playMaxBrLevel: String, // lossless
        @SerializedName("playMaxbr")
        val playMaxbr: Int, // 999000
        @SerializedName("preSell")
        val preSell: Boolean, // false
        @SerializedName("rscl")
        val rscl: Any?, // null
        @SerializedName("sp")
        val sp: Int, // 0
        @SerializedName("st")
        val st: Int, // 0
        @SerializedName("subp")
        val subp: Int, // 0
        @SerializedName("toast")
        val toast: Boolean // false
    ) {
        data class ChargeInfo(
            @SerializedName("chargeMessage")
            val chargeMessage: Any?, // null
            @SerializedName("chargeType")
            val chargeType: Int, // 1
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
        val copyright: Int, // 1
        @SerializedName("cp")
        val cp: Int, // 7002
        @SerializedName("crbt")
        val crbt: Any?, // null
        @SerializedName("djId")
        val djId: Int, // 0
        @SerializedName("dt")
        val dt: Int, // 326000
        @SerializedName("entertainmentTags")
        val entertainmentTags: Any?, // null
        @SerializedName("fee")
        val fee: Int, // 1
        @SerializedName("ftype")
        val ftype: Int, // 0
        @SerializedName("h")
        val h: H,
        @SerializedName("hr")
        val hr: Any?, // null
        @SerializedName("id")
        val id: Int, // 347230
        @SerializedName("l")
        val l: L,
        @SerializedName("m")
        val m: M,
        @SerializedName("mark")
        val mark: Long, // 8192
        @SerializedName("mst")
        val mst: Int, // 9
        @SerializedName("mv")
        val mv: Int, // 376199
        @SerializedName("name")
        val name: String, // 海阔天空
        @SerializedName("no")
        val no: Int, // 1
        @SerializedName("noCopyrightRcmd")
        val noCopyrightRcmd: Any?, // null
        @SerializedName("originCoverType")
        val originCoverType: Int, // 1
        @SerializedName("originSongSimpleData")
        val originSongSimpleData: Any?, // null
        @SerializedName("pop")
        val pop: Int, // 100
        @SerializedName("pst")
        val pst: Int, // 0
        @SerializedName("publishTime")
        val publishTime: Long, // 746812800000
        @SerializedName("resourceState")
        val resourceState: Boolean, // true
        @SerializedName("rt")
        val rt: String, // 600902000004240302
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
        val sq: Sq,
        @SerializedName("st")
        val st: Int, // 0
        @SerializedName("t")
        val t: Int, // 0
        @SerializedName("tagPicList")
        val tagPicList: Any?, // null
        @SerializedName("tns")
        val tns: List<String>,
        @SerializedName("v")
        val v: Int, // 112
        @SerializedName("version")
        val version: Int // 112
    ) {
        data class Al(
            @SerializedName("id")
            val id: Int, // 34209
            @SerializedName("name")
            val name: String, // 海阔天空
            @SerializedName("pic")
            val pic: Long, // 109951165796899180
            @SerializedName("pic_str")
            val picStr: String, // 109951165796899183
            @SerializedName("picUrl")
            val picUrl: String, // https://p1.music.126.net/8y8KJC1eCSO_vUKf2MyZwA==/109951165796899183.jpg
            @SerializedName("tns")
            val tns: List<String>
        )

        data class Ar(
            @SerializedName("alias")
            val alias: List<Any>,
            @SerializedName("id")
            val id: Int, // 11127
            @SerializedName("name")
            val name: String, // Beyond
            @SerializedName("tns")
            val tns: List<Any>
        )

        data class H(
            @SerializedName("br")
            val br: Int, // 320001
            @SerializedName("fid")
            val fid: Int, // 0
            @SerializedName("size")
            val size: Int, // 13042460
            @SerializedName("sr")
            val sr: Int, // 44100
            @SerializedName("vd")
            val vd: Float // -5649
        )

        data class L(
            @SerializedName("br")
            val br: Int, // 128001
            @SerializedName("fid")
            val fid: Int, // 0
            @SerializedName("size")
            val size: Int, // 5217010
            @SerializedName("sr")
            val sr: Int, // 44100
            @SerializedName("vd")
            val vd: Double // -1486
        )

        data class M(
            @SerializedName("br")
            val br: Int, // 192001
            @SerializedName("fid")
            val fid: Int, // 0
            @SerializedName("size")
            val size: Int, // 7825493
            @SerializedName("sr")
            val sr: Int, // 44100
            @SerializedName("vd")
            val vd: Float // -3083
        )

        data class Sq(
            @SerializedName("br")
            val br: Int, // 798710
            @SerializedName("fid")
            val fid: Int, // 0
            @SerializedName("size")
            val size: Int, // 32547445
            @SerializedName("sr")
            val sr: Int, // 44100
            @SerializedName("vd")
            val vd: Int // -5601
        )
    }
}