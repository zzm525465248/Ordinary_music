package com.example.kotlin_jetpack.ui.Unit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.kotlin_jetpack.bean.SongUrl_Bean
import com.lzx.starrysky.SongInfo

class SharedViewModel :ViewModel() {
    //播放器播放队列歌单
    var mediaPlayerList : MutableList<SongInfo> = mutableListOf()

    //播放器播放队列歌单
    var nowPlayerList :MutableList<SongInfo> = mutableListOf()

    //获取当前播放音乐的url
    private val _playerSongId = MutableLiveData<String>()
    val playerSongUrl: MutableLiveData<SongUrl_Bean> = MutableLiveData()

//    val playerSongUrlLiveData = Transformations.switchMap(_playerSongId) {
//
//    }

//    fun setPlayerSongId(data: String) {
//        _playerSongId.value = data
//    }
//
//    //当前播放音乐信息
//    private val _nowPlayerSong = MutableLiveData<NowPlayInfo>()
//    val getNowPlayInfo: NowPlayInfo?
//        get() = _nowPlayerSong.value
//    val nowPlayerSongLiveData = Transformations.map(_nowPlayerSong) {
//        _nowPlayerSong
//    }
//
//    fun setNowPlayerSong(data: NowPlayInfo) {
//        _nowPlayerSong.value = data
//    }
//
//    //定义当前音乐播放状态，10代表上一首,11代表没有播放或暂停，12代表正在播放，13代表下一首，15表示暂停
//    private val playStatus = MutableLiveData<Int>(11)
//    val getPlayStatus: Int
//        get() = playStatus.value!!
//    val playStatusLiveData = Transformations.map(playStatus) {
//        it
//    }
//
//    fun changeStatus(data: Int) {
//        playStatus.value = data
//    }
}