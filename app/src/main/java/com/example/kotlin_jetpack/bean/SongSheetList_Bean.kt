package com.example.kotlin_jetpack.bean
import com.google.gson.annotations.SerializedName



data class SongSheetList_Bean(
    @SerializedName("cat")
    val cat: String, // 华语
    @SerializedName("code")
    val code: Int, // 200
    @SerializedName("more")
    val more: Boolean, // false
    @SerializedName("playlists")
    val playlists: List<Playlists>,
    @SerializedName("total")
    val total: Int // 1505
) {
    data class Playlists(
        @SerializedName("adType")
        val adType: Int, // 0
        @SerializedName("alg")
        val alg: String, // alg_sq_offline
        @SerializedName("anonimous")
        val anonimous: Boolean, // false
        @SerializedName("cloudTrackCount")
        val cloudTrackCount: Int, // 0
        @SerializedName("commentCount")
        val commentCount: Int, // 0
        @SerializedName("commentThreadId")
        val commentThreadId: String, // A_PL_0_6661852776
        @SerializedName("coverImgId")
        val coverImgId: Long, // 109951165881754000
        @SerializedName("coverImgId_str")
        val coverImgIdStr: String, // 109951165881753993
        @SerializedName("coverImgUrl")
        val coverImgUrl: String, // http://p2.music.126.net/nonvBWl_UelBvs4bI9SuBg==/109951165881753993.jpg
        @SerializedName("coverStatus")
        val coverStatus: Int, // 3
        @SerializedName("createTime")
        val createTime: Long, // 1615783000674
        @SerializedName("creator")
        val creator: Creator,
        @SerializedName("description")
        val description: String, // 最能打动人心的还是那些经典老歌
        @SerializedName("highQuality")
        val highQuality: Boolean, // false
        @SerializedName("id")
        val id: Long, // 6661852776
        @SerializedName("name")
        val name: String, // 经典不朽｜原谅我这一生不羁放纵爱自由
        @SerializedName("newImported")
        val newImported: Boolean, // false
        @SerializedName("ordered")
        val ordered: Boolean, // true
        @SerializedName("playCount")
        val playCount: Long, // 23753
        @SerializedName("privacy")
        val privacy: Int, // 0
        @SerializedName("recommendInfo")
        val recommendInfo: Any?, // null
        @SerializedName("shareCount")
        val shareCount: Int, // 0
        @SerializedName("specialType")
        val specialType: Int, // 0
        @SerializedName("status")
        val status: Int, // 0
        @SerializedName("subscribed")
        val subscribed: Boolean, // false
        @SerializedName("subscribedCount")
        val subscribedCount: Int, // 78
        @SerializedName("subscribers")
        val subscribers: List<Subscriber>,
        @SerializedName("tags")
        val tags: List<String>,
        @SerializedName("totalDuration")
        val totalDuration: Int, // 0
        @SerializedName("trackCount")
        val trackCount: Int, // 68
        @SerializedName("trackNumberUpdateTime")
        val trackNumberUpdateTime: Long, // 1641828471519
        @SerializedName("trackUpdateTime")
        val trackUpdateTime: Long, // 1652149387266
        @SerializedName("tracks")
        val tracks: Any?, // null
        @SerializedName("updateTime")
        val updateTime: Long, // 1641828500441
        @SerializedName("userId")
        val userId: Long // 283996843
    ) {
        data class Creator(
            @SerializedName("accountStatus")
            val accountStatus: Int, // 0
            @SerializedName("anchor")
            val anchor: Boolean, // false
            @SerializedName("authStatus")
            val authStatus: Int, // 1
            @SerializedName("authenticationTypes")
            val authenticationTypes: Int, // 1581128
            @SerializedName("authority")
            val authority: Int, // 0
            @SerializedName("avatarDetail")
            val avatarDetail: AvatarDetail,
            @SerializedName("avatarImgId")
            val avatarImgId: Long, // 109951166924535490
            @SerializedName("avatarImgIdStr")
            val avatarImgIdStr: String, // 109951166924535481
            @SerializedName("avatarImgId_str")
            val avatarImgIdStr1: String, // 109951166924535481
            @SerializedName("avatarUrl")
            val avatarUrl: String, // http://p1.music.126.net/4zKuAYoaWuAOzP7Ef7QXQQ==/109951166924535481.jpg
            @SerializedName("backgroundImgId")
            val backgroundImgId: Long, // 109951166677541230
            @SerializedName("backgroundImgIdStr")
            val backgroundImgIdStr: String, // 109951166677541228
            @SerializedName("backgroundUrl")
            val backgroundUrl: String, // http://p1.music.126.net/I24fnucgA5tALwdAbdtdGQ==/109951166677541228.jpg
            @SerializedName("birthday")
            val birthday: Long, // 1066198346237
            @SerializedName("city")
            val city: Int, // 640100
            @SerializedName("defaultAvatar")
            val defaultAvatar: Boolean, // false
            @SerializedName("description")
            val description: String,
            @SerializedName("detailDescription")
            val detailDescription: String,
            @SerializedName("djStatus")
            val djStatus: Int, // 10
            @SerializedName("expertTags")
            val expertTags: Any?, // null
            @SerializedName("experts")
            val experts: Any?, // null
            @SerializedName("followed")
            val followed: Boolean, // false
            @SerializedName("gender")
            val gender: Int, // 1
            @SerializedName("mutual")
            val mutual: Boolean, // false
            @SerializedName("nickname")
            val nickname: String, // 少年的杂货铺
            @SerializedName("province")
            val province: Int, // 640000
            @SerializedName("remarkName")
            val remarkName: Any?, // null
            @SerializedName("signature")
            val signature: String, // 人生若只如初见，何事秋风悲画扇
            @SerializedName("userId")
            val userId: Long, // 283996843
            @SerializedName("userType")
            val userType: Int, // 200
            @SerializedName("vipType")
            val vipType: Int // 11
        ) {
            data class AvatarDetail(
                @SerializedName("identityIconUrl")
                val identityIconUrl: String, // https://p5.music.126.net/obj/wo3DlcOGw6DClTvDisK1/4761340159/e2c1/6fb5/f49b/353e6d1857f7c5f46426beb533427e53.png
                @SerializedName("identityLevel")
                val identityLevel: Int, // 2
                @SerializedName("userType")
                val userType: Int // 200
            )
        }

        data class Subscriber(
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
            val avatarImgId: Long, // 109951165647004060
            @SerializedName("avatarImgIdStr")
            val avatarImgIdStr: String, // 109951165647004069
            @SerializedName("avatarImgId_str")
            val avatarImgIdStr1: String, // 109951165647004069
            @SerializedName("avatarUrl")
            val avatarUrl: String, // http://p1.music.126.net/SUeqMM8HOIpHv9Nhl9qt9w==/109951165647004069.jpg
            @SerializedName("backgroundImgId")
            val backgroundImgId: Long, // 109951162868128400
            @SerializedName("backgroundImgIdStr")
            val backgroundImgIdStr: String, // 109951162868128395
            @SerializedName("backgroundUrl")
            val backgroundUrl: String, // http://p1.music.126.net/2zSNIqTcpHL2jIvU6hG0EA==/109951162868128395.jpg
            @SerializedName("birthday")
            val birthday: Long, // -2209017600000
            @SerializedName("city")
            val city: Int, // 320100
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
            val nickname: String, // 郭小康0127
            @SerializedName("province")
            val province: Int, // 320000
            @SerializedName("remarkName")
            val remarkName: Any?, // null
            @SerializedName("signature")
            val signature: String,
            @SerializedName("userId")
            val userId: Long, // 2092501277
            @SerializedName("userType")
            val userType: Int, // 0
            @SerializedName("vipType")
            val vipType: Int // 0
        )
    }
}