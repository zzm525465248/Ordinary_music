package com.example.kotlin_jetpack.bean
import com.google.gson.annotations.SerializedName


data class Review2_song_Bean(
    @SerializedName("code")
    val code: Int, // 200
    @SerializedName("data")
    val `data`: Data
) {
    data class Data(
        @SerializedName("comments")
        val comments: List<Comment>,
        @SerializedName("commentsTitle")
        val commentsTitle: String, // 全部评论
        @SerializedName("currentComment")
        val currentComment: Any?, // null
        @SerializedName("currentCommentTitle")
        val currentCommentTitle: String, // 当前评论
        @SerializedName("cursor")
        val cursor: String, // 1653136528805
        @SerializedName("hasMore")
        val hasMore: Boolean, // true
        @SerializedName("sortType")
        val sortType: Int, // 99
        @SerializedName("sortTypeList")
        val sortTypeList: List<SortType>,
        @SerializedName("totalCount")
        val totalCount: Int // 196206
    ) {
        data class Comment(
            @SerializedName("args")
            val args: String, // {"reason_tags":"hot","recall_sorter":"tophot_sorter","algs":"hot","audit_reason":"tophot","recall_score":"1.0"}
            @SerializedName("beReplied")
            val beReplied: Any?, // null
            @SerializedName("commentId")
            val commentId: Long, // 2037823002
            @SerializedName("commentLocationType")
            val commentLocationType: Int, // 0
            @SerializedName("commentVideoVO")
            val commentVideoVO: CommentVideoVO,
            @SerializedName("content")
            val content: String, // 网易云音乐的朋友们  欢迎收听我的新歌《麻雀》
            @SerializedName("contentPicNosKey")
            val contentPicNosKey: Any?, // null
            @SerializedName("contentPicUrl")
            val contentPicUrl: Any?, // null
            @SerializedName("contentResource")
            val contentResource: Any?, // null
            @SerializedName("decoration")
            val decoration: Decoration,
            @SerializedName("expressionUrl")
            val expressionUrl: Any?, // null
            @SerializedName("extInfo")
            val extInfo: ExtInfo,
            @SerializedName("grade")
            val grade: Any?, // null
            @SerializedName("liked")
            val liked: Boolean, // false
            @SerializedName("likedCount")
            val likedCount: Int, // 680029
            @SerializedName("needDisplayTime")
            val needDisplayTime: Boolean, // true
            @SerializedName("parentCommentId")
            val parentCommentId: Int, // 0
            @SerializedName("pendantData")
            val pendantData: Any?, // null
            @SerializedName("repliedMark")
            val repliedMark: Boolean, // false
            @SerializedName("replyCount")
            val replyCount: Int, // 16314
            @SerializedName("resourceSpecialType")
            val resourceSpecialType: Any?, // null
            @SerializedName("showFloorComment")
            val showFloorComment: ShowFloorComment,
            @SerializedName("source")
            val source: Any?, // null
            @SerializedName("status")
            val status: Int, // 0
            @SerializedName("tag")
            val tag: Tag,
            @SerializedName("time")
            val time: Long, // 1575475473536
            @SerializedName("timeStr")
            val timeStr: String, // 2019-12-05
            @SerializedName("user")
            val user: User
        ) {
            data class CommentVideoVO(
                @SerializedName("allowCreation")
                val allowCreation: Boolean, // true
                @SerializedName("creationOrpheusUrl")
                val creationOrpheusUrl: String?, // orpheus://nm/mlog/commentVideoTemplate?commentId=2037823002&threadId=R_SO_4_1407551413
                @SerializedName("forbidCreationText")
                val forbidCreationText: String, // 作者未开放制作权限
                @SerializedName("playOrpheusUrl")
                val playOrpheusUrl: String?, // orpheus://nm/MLog/videoDetailV2?type=0&id=0&recommendType=49&extInfo=%7B%22commentId%22%3A2037823002%2C%22songId%22%3A1407551413%7D
                @SerializedName("showCreationEntrance")
                val showCreationEntrance: Boolean, // true
                @SerializedName("videoCount")
                val videoCount: Int // 0
            )

            class Decoration

            class ExtInfo

            data class ShowFloorComment(
                @SerializedName("comments")
                val comments: Any?, // null
                @SerializedName("replyCount")
                val replyCount: Int, // 16314
                @SerializedName("showReplyCount")
                val showReplyCount: Boolean, // true
                @SerializedName("target")
                val target: Any?, // null
                @SerializedName("topCommentIds")
                val topCommentIds: Any? // null
            )

            data class Tag(
                @SerializedName("datas")
                val datas: List<Any>?,
                @SerializedName("extDatas")
                val extDatas: List<Any>,
                @SerializedName("relatedCommentIds")
                val relatedCommentIds: Any? // null
            )

            data class User(
                @SerializedName("anonym")
                val anonym: Int, // 0
                @SerializedName("authStatus")
                val authStatus: Int, // 1
                @SerializedName("avatarDetail")
                val avatarDetail: AvatarDetail?,
                @SerializedName("avatarUrl")
                val avatarUrl: String, // http://p4.music.126.net/6qELnB2Zk0rPqczY9LbSoQ==/109951165693670160.jpg
                @SerializedName("commonIdentity")
                val commonIdentity: Any?, // null
                @SerializedName("expertTags")
                val expertTags: Any?, // null
                @SerializedName("experts")
                val experts: Any?, // null
                @SerializedName("followed")
                val followed: Boolean, // false
                @SerializedName("isHug")
                val isHug: Boolean, // false
                @SerializedName("liveInfo")
                val liveInfo: Any?, // null
                @SerializedName("locationInfo")
                val locationInfo: Any?, // null
                @SerializedName("nickname")
                val nickname: String, // 李荣浩
                @SerializedName("relationTag")
                val relationTag: Any?, // null
                @SerializedName("remarkName")
                val remarkName: Any?, // null
                @SerializedName("userId")
                val userId: Long, // 6228671
                @SerializedName("userType")
                val userType: Int, // 2
                @SerializedName("vipRights")
                val vipRights: Any?, // null
                @SerializedName("vipType")
                val vipType: Int // 0
            ) {
                data class AvatarDetail(
                    @SerializedName("identityIconUrl")
                    val identityIconUrl: String, // https://p5.music.126.net/obj/wo3DlcOGw6DClTvDisK1/4788940880/1a1f/68f5/b59a/b444b81b88567108ba88194fa29144f5.png
                    @SerializedName("identityLevel")
                    val identityLevel: Int, // 1
                    @SerializedName("userType")
                    val userType: Int // 2
                )
            }
        }

        data class SortType(
            @SerializedName("sortType")
            val sortType: Int, // 1
            @SerializedName("sortTypeName")
            val sortTypeName: String, // 按推荐排序
            @SerializedName("target")
            val target: String // order_by_alg
        )
    }
}