package com.example.kotlin_jetpack.Api




import android.content.Context
import com.example.kotlin_jetpack.bean.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*


interface ApiService {

    companion object{
        const val BASE_URL="http://47.101.205.65:3000/"
        const val SONG_URL="https://music.163.com/song/media/outer/url?id="



    }

    @GET("shop/onSell/{page}")
    suspend   fun getAppUser_Data(@Path("page") page:Int): Call<SongUser>


    //搜索
    @GET("search/multimatch")
     fun getAppUser_Data4(@Query("keywords") name:String): Call<SongUser>

    //轮播图
     @GET("banner?type=1")
     fun getBanner_list():Call<Banner>


     //推荐歌单
     @GET("personalized?limit=6")
     fun getRecommendedSongList():Call<RecommendedSongListBean>

     //首页数据
     @GET("homepage/block/page")
     fun  getHomeList() :Call<Home_bean>

     //获取歌取曲URL
     @GET("song/url")
     fun getSongUrl(@Query("id") id:Int): Call<SongUrl_Bean>

     //获取歌词
     @GET("lyric")
     fun getSongLyric(@Query("id") id:Int) :Call<SongLyric_Bean>

     //首页全部服务
     @GET("homepage/dragon/ball")
     fun getHomeQbfw() :Call<Qbfw_Bean>

     //歌单详情页信息
     @GET("playlist/detail")
     fun getSongsheet_details(@Query("id") id :Long,@Query("cookie") cookie:String) :Call<Songsheet_details_Bean>

     //歌单全部歌曲
     @GET("playlist/track/all")
     fun getSongSheet_list(@Query("id") id: Long, @Query("offset") page:Int, @Query("limit") size:Int,@Query("cookie") cookie:String) :Call<SongSheet_List_Bean>

     //获取歌曲URL数组
     @GET("song/url")
     fun getSongList_Url(@Query("id") id: String) :Call<SongUrl_Bean>

     //发送验证码
     @GET("captcha/sent")
     fun getCode(@Query("phone") phone:Long) :Call<YzCode_Bean>

     //登录 验证码
     @GET("login/cellphone")
     fun login(@Query("phone") phone:Long,@Query("captcha") captcha:Int) :Call<Login_bena>

//     //验证验证码
//     @GET("captcha/verify")
//     fun yzCode(@Query("phone") phone: Long,@Query("captcha") captcha:Int) :Call<Login_Bean>

     //登录状态
     @GET("login/status")
     fun login_status(@Query("cookie") cookie:String):Call<Login_statue_Bean>

     //获取账户信息
     @GET("user/detail")
     fun get_User(@Query("uid") uid:Int) :Call<User_Bean>

     //获取喜欢列表
     @GET("likelist")
     fun get_Love_List(@Query("uid") uid: Int,@Query("cookie") cookie:String) :Call<Love_Bean>

     //获取歌曲详情
     @GET("song/detail")
     fun get_song_details(@Query("ids")  ids: String) :Call<Song_details_Bean>

     //获取用户歌单
     @GET("user/playlist")
     fun get_user_playlist(@Query("uid") uid: Int) :Call<User_PlayList_Bean>

     //获取歌曲分类
     @GET("playlist/hot")
     fun get_songsheet_classification() :Call<Songsheet_classification_Bean.data>

     //获取每日推荐歌单
     @GET("recommend/resource")
     fun get_Recommended_song_list(@Query("cookie") cookie: String) :Call<Recommended_song_list_Bean>

     //获取歌单
     @GET("/top/playlist")
     fun get_songsheet_list(@Query("cat") cat:String,@Query("limit") limit:Int,@Query("offset") page:Int):Call<SongSheetList_Bean>

     //获取歌单评论
     @GET("comment/music")
     fun get_song_review(@Query("id") id:Int,@Query("limit") limit: Int,@Query("offset") page: Int) :Call<Review_song_Bean>

     //获取歌单评论2
     @GET("comment/new")
     fun get_song_review2(@Query("id") id:Int, @Query("type") type:Int, @Query("pageNo") page: Int, @Query("pageSize") pagesize:Int, @Query("sortType") sorttype:Int, @Query("cursor") time: Long?)  :Call<Review2_song_Bean>
 }