package com.example.kotlin_jetpack.bean
import com.google.gson.annotations.SerializedName


class RepoResponse(
    @SerializedName("items") val items: List<Review_song_Bean> = emptyList()
)

data class Review_song_Bean(
    @SerializedName("code")
    val code: Int, // 200
    @SerializedName("commentBanner")
    val commentBanner: Any?, // null
    @SerializedName("comments")
    val comments: List<Comment>,
    @SerializedName("hotComments")
    val hotComments: List<HotComment>,
    @SerializedName("isMusician")
    val isMusician: Boolean, // false
    @SerializedName("more")
    val more: Boolean, // true
    @SerializedName("moreHot")
    val moreHot: Boolean, // true
    @SerializedName("topComments")
    val topComments: List<Any>,
    @SerializedName("total")
    val total: Int, // 2814
    @SerializedName("userId")
    val userId: Int // -1
) {
    data class Comment(
        @SerializedName("beReplied")
        val beReplied: List<BeReplied>,
        @SerializedName("commentId")
        val commentId: Long, // 5665403866
        @SerializedName("commentLocationType")
        val commentLocationType: Int, // 0
        @SerializedName("content")
        val content: String, // 还是煊赫门 嘴甜
        @SerializedName("contentResource")
        val contentResource: Any?, // null
        @SerializedName("decoration")
        val decoration: Decoration,
        @SerializedName("expressionUrl")
        val expressionUrl: Any?, // null
        @SerializedName("grade")
        val grade: Any?, // null
        @SerializedName("liked")
        val liked: Boolean, // false
        @SerializedName("likedCount")
        val likedCount: Int, // 0
        @SerializedName("needDisplayTime")
        val needDisplayTime: Boolean, // true
        @SerializedName("parentCommentId")
        val parentCommentId: Long, // 5641111424
        @SerializedName("pendantData")
        val pendantData: PendantData?,
        @SerializedName("repliedMark")
        val repliedMark: Any?, // null
        @SerializedName("showFloorComment")
        val showFloorComment: Any?, // null
        @SerializedName("status")
        val status: Int, // 0
        @SerializedName("time")
        val time: Long, // 1653048491483
        @SerializedName("timeStr")
        val timeStr: String, // 21分钟前
        @SerializedName("user")
        val user: User
    ) {
        data class BeReplied(
            @SerializedName("beRepliedCommentId")
            val beRepliedCommentId: Long, // 5641111424
            @SerializedName("content")
            val content: String, // 今天抽的什么烟兄弟们 陪一根玉溪
            @SerializedName("expressionUrl")
            val expressionUrl: Any?, // null
            @SerializedName("status")
            val status: Int, // 0
            @SerializedName("user")
            val user: User
        ) {
            data class User(
                @SerializedName("anonym")
                val anonym: Int, // 0
                @SerializedName("authStatus")
                val authStatus: Int, // 0
                @SerializedName("avatarDetail")
                val avatarDetail: Any?, // null
                @SerializedName("avatarUrl")
                val avatarUrl: String, // http://p3.music.126.net/4XrTOkHDzDvpAnj2OY5RWQ==/109951167309126838.jpg
                @SerializedName("commonIdentity")
                val commonIdentity: Any?, // null
                @SerializedName("expertTags")
                val expertTags: Any?, // null
                @SerializedName("experts")
                val experts: Any?, // null
                @SerializedName("followed")
                val followed: Boolean, // false
                @SerializedName("liveInfo")
                val liveInfo: Any?, // null
                @SerializedName("locationInfo")
                val locationInfo: Any?, // null
                @SerializedName("mutual")
                val mutual: Boolean, // false
                @SerializedName("nickname")
                val nickname: String, // 弱水替滄海_Yk
                @SerializedName("remarkName")
                val remarkName: Any?, // null
                @SerializedName("userId")
                val userId: Long, // 395573370
                @SerializedName("userType")
                val userType: Int, // 0
                @SerializedName("vipRights")
                val vipRights: Any?, // null
                @SerializedName("vipType")
                val vipType: Int // 11
            )
        }

        class Decoration

        data class PendantData(
            @SerializedName("id")
            val id: Int, // 5002
            @SerializedName("imageUrl")
            val imageUrl: String // http://p1.music.126.net/tFjGw0GRZ-Oyf6r5vH4kFQ==/109951163313123168.jpg
        )

        data class User(
            @SerializedName("anonym")
            val anonym: Int, // 0
            @SerializedName("authStatus")
            val authStatus: Int, // 0
            @SerializedName("avatarDetail")
            val avatarDetail: Any?, // null
            @SerializedName("avatarUrl")
            val avatarUrl: String, // http://p3.music.126.net/zUVMyebEpAHqfe_SKb-pXQ==/109951166695216467.jpg
            @SerializedName("commonIdentity")
            val commonIdentity: Any?, // null
            @SerializedName("expertTags")
            val expertTags: Any?, // null
            @SerializedName("experts")
            val experts: Any?, // null
            @SerializedName("followed")
            val followed: Boolean, // false
            @SerializedName("liveInfo")
            val liveInfo: Any?, // null
            @SerializedName("locationInfo")
            val locationInfo: Any?, // null
            @SerializedName("mutual")
            val mutual: Boolean, // false
            @SerializedName("nickname")
            val nickname: String, // 丿冂
            @SerializedName("remarkName")
            val remarkName: Any?, // null
            @SerializedName("userId")
            val userId: Long, // 1774305293
            @SerializedName("userType")
            val userType: Int, // 0
            @SerializedName("vipRights")
            val vipRights: VipRights?,
            @SerializedName("vipType")
            val vipType: Int // 11
        ) {
            data class VipRights(
                @SerializedName("associator")
                val associator: Associator?,
                @SerializedName("musicPackage")
                val musicPackage: Any?, // null
                @SerializedName("redVipAnnualCount")
                val redVipAnnualCount: Int, // -1
                @SerializedName("redVipLevel")
                val redVipLevel: Int // 4
            ) {
                data class Associator(
                    @SerializedName("rights")
                    val rights: Boolean, // true
                    @SerializedName("vipCode")
                    val vipCode: Int // 100
                )
            }
        }
    }

    data class HotComment(
        @SerializedName("beReplied")
        val beReplied: List<Any>,
        @SerializedName("commentId")
        val commentId: Long, // 5341111070
        @SerializedName("commentLocationType")
        val commentLocationType: Int, // 0
        @SerializedName("content")
        val content: String, // 以后你们每听一次这首歌 我都会消息+1 好吗
        @SerializedName("contentResource")
        val contentResource: Any?, // null
        @SerializedName("decoration")
        val decoration: Decoration,
        @SerializedName("expressionUrl")
        val expressionUrl: Any?, // null
        @SerializedName("grade")
        val grade: Any?, // null
        @SerializedName("liked")
        val liked: Boolean, // false
        @SerializedName("likedCount")
        val likedCount: Int, // 8901
        @SerializedName("needDisplayTime")
        val needDisplayTime: Boolean, // true
        @SerializedName("parentCommentId")
        val parentCommentId: Int, // 0
        @SerializedName("pendantData")
        val pendantData: Any?, // null
        @SerializedName("repliedMark")
        val repliedMark: Any?, // null
        @SerializedName("showFloorComment")
        val showFloorComment: Any?, // null
        @SerializedName("status")
        val status: Int, // 0
        @SerializedName("time")
        val time: Long, // 1624550470811
        @SerializedName("timeStr")
        val timeStr: String, // 2021-06-25
        @SerializedName("user")
        val user: User
    ) {
        class Decoration

        data class User(
            @SerializedName("anonym")
            val anonym: Int, // 0
            @SerializedName("authStatus")
            val authStatus: Int, // 0
            @SerializedName("avatarDetail")
            val avatarDetail: Any?, // null
            @SerializedName("avatarUrl")
            val avatarUrl: String, // http://p3.music.126.net/7NeUZlZZnI8jByo9wercuA==/109951165075430854.jpg
            @SerializedName("commonIdentity")
            val commonIdentity: Any?, // null
            @SerializedName("expertTags")
            val expertTags: Any?, // null
            @SerializedName("experts")
            val experts: Any?, // null
            @SerializedName("followed")
            val followed: Boolean, // false
            @SerializedName("liveInfo")
            val liveInfo: Any?, // null
            @SerializedName("locationInfo")
            val locationInfo: Any?, // null
            @SerializedName("mutual")
            val mutual: Boolean, // false
            @SerializedName("nickname")
            val nickname: String, // 做你的人质_
            @SerializedName("remarkName")
            val remarkName: Any?, // null
            @SerializedName("userId")
            val userId: Long, // 571765615
            @SerializedName("userType")
            val userType: Int, // 0
            @SerializedName("vipRights")
            val vipRights: Any?, // null
            @SerializedName("vipType")
            val vipType: Int // 0
        )
    }
}