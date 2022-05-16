package com.example.kotlin_jetpack.bean
import com.google.gson.annotations.SerializedName


data class User_PlayList_Bean(
    @SerializedName("code")
    val code: Int, // 200
    @SerializedName("more")
    val more: Boolean, // false

    @SerializedName("playlist")
    val playlist: List<Playlist>,
    @SerializedName("version")
    val version: String // 1651307010737
) {

    data class Playlist(
        @SerializedName("adType")
        val adType: Int, // 0
        @SerializedName("anonimous")
        val anonimous: Boolean, // false
        @SerializedName("artists")
        val artists: Any?, // null
        @SerializedName("backgroundCoverId")
        val backgroundCoverId: Long, // 0
        @SerializedName("backgroundCoverUrl")
        val backgroundCoverUrl: Any?, // null
        @SerializedName("cloudTrackCount")
        val cloudTrackCount: Int, // 2
        @SerializedName("commentThreadId")
        val commentThreadId: String, // A_PL_0_167139576
        @SerializedName("coverImgId")
        val coverImgId: Long, // 109951165775918640
        @SerializedName("coverImgId_str")
        val coverImgIdStr: String?, // 109951165775918644
        @SerializedName("coverImgUrl")
        val coverImgUrl: String, // https://p1.music.126.net/bmmSUoJVa_DffwUJz1DQeQ==/109951165775918644.jpg
        @SerializedName("createTime")
        val createTime: Long, // 1454997221690
        @SerializedName("creator")
        val creator: Creator,
        @SerializedName("description")
        val description: Any?, // null
        @SerializedName("englishTitle")
        val englishTitle: Any?, // null
        @SerializedName("highQuality")
        val highQuality: Boolean, // false
        @SerializedName("id")
        val id: Long, // 167139576
        @SerializedName("name")
        val name: String, // 白瓷梅子汤吖喜欢的音乐
        @SerializedName("newImported")
        val newImported: Boolean, // false
        @SerializedName("opRecommend")
        val opRecommend: Boolean, // false
        @SerializedName("ordered")
        val ordered: Boolean, // false
        @SerializedName("playCount")
        val playCount: Int, // 12334
        @SerializedName("privacy")
        val privacy: Int, // 0
        @SerializedName("recommendInfo")
        val recommendInfo: Any?, // null
        @SerializedName("shareStatus")
        val shareStatus: Any?, // null
        @SerializedName("sharedUsers")
        val sharedUsers: Any?, // null
        @SerializedName("specialType")
        val specialType: Int, // 5
        @SerializedName("status")
        val status: Int, // 0
        @SerializedName("subscribed")
        val subscribed: Boolean, // false
        @SerializedName("subscribedCount")
        val subscribedCount: Int, // 0
        @SerializedName("subscribers")
        val subscribers: List<Any>,
        @SerializedName("tags")
        val tags: List<String>,
        @SerializedName("titleImage")
        val titleImage: Long, // 0
        @SerializedName("titleImageUrl")
        val titleImageUrl: Any?, // null
        @SerializedName("totalDuration")
        val totalDuration: Int, // 0
        @SerializedName("trackCount")
        val trackCount: Int, // 502
        @SerializedName("trackNumberUpdateTime")
        val trackNumberUpdateTime: Long, // 1649846456491
        @SerializedName("trackUpdateTime")
        val trackUpdateTime: Long, // 1651307008898
        @SerializedName("tracks")
        val tracks: Any?, // null
        @SerializedName("updateFrequency")
        val updateFrequency: Any?, // null
        @SerializedName("updateTime")
        val updateTime: Long, // 1649846456491
        @SerializedName("userId")
        val userId: Int // 132819237
    ) {
        data class Creator(
            @SerializedName("accountStatus")
            val accountStatus: Int, // 0
            @SerializedName("anchor")
            val anchor: Boolean, // false
            @SerializedName("authStatus")
            val authStatus: Int, // 0
            @SerializedName("authenticationTypes")
            val authenticationTypes: Int, // 0
            @SerializedName("authority")
            val authority: Int, // 0
            @SerializedName("avatarDetail")
            val avatarDetail: Any?, // null
            @SerializedName("avatarImgId")
            val avatarImgId: Long, // 109951165563967020
            @SerializedName("avatarImgIdStr")
            val avatarImgIdStr: String, // 109951165563967026
            @SerializedName("avatarImgId_str")
            val avatarImgId_Str: String, // 109951165563967026
            @SerializedName("avatarUrl")
            val avatarUrl: String, // http://p1.music.126.net/OP0T91-VDliBxpP53lyRew==/109951165563967026.jpg
            @SerializedName("backgroundImgId")
            val backgroundImgId: Long, // 109951165563972540
            @SerializedName("backgroundImgIdStr")
            val backgroundImgIdStr: String, // 109951165563972541
            @SerializedName("backgroundUrl")
            val backgroundUrl: String, // http://p1.music.126.net/U6VbBjR2EILYAA5znpY13A==/109951165563972541.jpg
            @SerializedName("birthday")
            val birthday: Int, // 0
            @SerializedName("city")
            val city: Int, // 341000
            @SerializedName("defaultAvatar")
            val defaultAvatar: Boolean, // false
            @SerializedName("description")
            val description: String,
            @SerializedName("detailDescription")
            val detailDescription: String,
            @SerializedName("djStatus")
            val djStatus: Int, // 0
            @SerializedName("expertTags")
            val expertTags: Any?, // null
            @SerializedName("experts")
            val experts: Any?, // null
            @SerializedName("followed")
            val followed: Boolean, // false
            @SerializedName("gender")
            val gender: Int, // 0
            @SerializedName("mutual")
            val mutual: Boolean, // false
            @SerializedName("nickname")
            val nickname: String, // 白瓷梅子汤吖
            @SerializedName("province")
            val province: Int, // 340000
            @SerializedName("remarkName")
            val remarkName: Any?, // null
            @SerializedName("signature")
            val signature: String, // 灵魂自由，从不附庸
            @SerializedName("userId")
            val userId: Int, // 132819237
            @SerializedName("userType")
            val userType: Int, // 0
            @SerializedName("vipType")
            val vipType: Int // 0
        )
    }
}