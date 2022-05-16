
import com.google.gson.annotations.SerializedName


 class Songsheet_classification_Bean{
     data class data(
    @SerializedName("code")
    val code: Int, // 200
    @SerializedName("tags")
    val tags: List<Tag>
) {
    data class Tag(
        @SerializedName("activity")
        val activity: Boolean, // false
        @SerializedName("category")
        val category: Int, // 0
        @SerializedName("createTime")
        val createTime: Long, // 1378707544870
        @SerializedName("hot")
        val hot: Boolean, // true
        @SerializedName("id")
        val id: Int, // 5001
        @SerializedName("name")
        val name: String, // 华语
        @SerializedName("playlistTag")
        val playlistTag: PlaylistTag,
        @SerializedName("position")
        val position: Int, // 1
        @SerializedName("type")
        val type: Int, // 1
        @SerializedName("usedCount")
        val usedCount: Int // 8129721
    ) {
        data class PlaylistTag(
            @SerializedName("category")
            val category: Int, // 0
            @SerializedName("createTime")
            val createTime: Long, // 1378707544870
            @SerializedName("highQuality")
            val highQuality: Int, // 1
            @SerializedName("highQualityPos")
            val highQualityPos: Int, // 1
            @SerializedName("id")
            val id: Int, // 5001
            @SerializedName("name")
            val name: String, // 华语
            @SerializedName("officialPos")
            val officialPos: Int, // 1
            @SerializedName("position")
            val position: Int, // 1
            @SerializedName("type")
            val type: Int, // 0
            @SerializedName("usedCount")
            val usedCount: Int // 8129721
        )
    }
}
 }
