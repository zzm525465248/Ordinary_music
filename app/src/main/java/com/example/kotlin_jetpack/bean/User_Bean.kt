package com.example.kotlin_jetpack.bean
import android.util.Log
import com.google.gson.annotations.SerializedName


data class User_Bean(
    val adValid: Boolean,
    val bindings: List<Binding2>,
    val code: Int,
    val createDays: Int,
    val createTime: Long,
    val level: Int,
    val listenSongs: Int,
    val mobileSign: Boolean,
    val pcSign: Boolean,
    val peopleCanSeeMyPlayRecord: Boolean,
    val profile: Profile2,
    val profileVillageInfo: ProfileVillageInfo,
    val userPoint: UserPoint
)

data class Binding2(
    val bindingTime: Long,
    val expired: Boolean,
    val expiresIn: Int,
    val id: Long,
    val refreshTime: Int,
    val tokenJsonStr: Any,
    val type: Int,
    val url: String,
    val userId: Int
)

data class Profile2(
    val accountStatus: Int,
    val allSubscribedCount: Int,
    val artistIdentity: List<Any>,
    val authStatus: Int,
    val authority: Int,
    val avatarDetail: Any,
    val avatarImgId: Long,
    val avatarImgIdStr: String,
    val avatarImgId_str: String,
    val avatarUrl: String,
    val backgroundImgId: Long,
    val backgroundImgIdStr: String,
    val backgroundUrl: String,
    val birthday: Long,
    val blacklist: Boolean,
    val cCount: Int,
    val city: Int,
    val createTime: Long,
    val defaultAvatar: Boolean,
    val description: String,
    val detailDescription: String,
    val djStatus: Int,
    val eventCount: Int,
    val expertTags: Any,
    val experts: Experts1,
    val followMe: Boolean,
    val followTime: Any,
    val followed: Boolean,
    val followeds: Int,
    val follows: Int,
    val gender: Int,
    val inBlacklist: Boolean,
    val mutual: Boolean,
    val newFollows: Int,
    val nickname: String,
    val playlistBeSubscribedCount: Int,
    val playlistCount: Int,
    val privacyItemUnlimit: PrivacyItemUnlimit,
    val province: Int,
    val remarkName: Any,
    val sCount: Int,
    val sDJPCount: Int,
    val signature: String,
    val userId: Int,
    val userType: Int,
    val vipType: Int
)

data class ProfileVillageInfo(
    val imageUrl: Any,
    val targetUrl: String,
    val title: String
)

data class UserPoint(
    val balance: Int,
    val blockBalance: Int,
    val status: Int,
    val updateTime: Long,
    val userId: Int,
    val version: Int
)

class Experts1

data class PrivacyItemUnlimit(
    val age: Boolean,
    val area: Boolean,
    val college: Boolean,
    val villageAge: Boolean
)