package com.example.kotlin_jetpack.bean

data class Login_statue_Bean(
    val `data`: Data2
)

data class Data2(
    val account: Account2,
    val code: Int,
    val profile: Profile1
)

data class Account2(
    val anonimousUser: Boolean,
    val ban: Int,
    val baoyueVersion: Int,
    val createTime: Long,
    val donateVersion: Int,
    val id: Int,
    val paidFee: Boolean,
    val status: Int,
    val tokenVersion: Int,
    val type: Int,
    val userName: String,
    val vipType: Int,
    val whitelistAuthority: Int
)

data class Profile1(
    val accountStatus: Int,
    val accountType: Int,
    val anchor: Boolean,
    val authStatus: Int,
    val authenticated: Boolean,
    val authenticationTypes: Int,
    val authority: Int,
    val avatarDetail: Any,
    val avatarImgId: Long,
    val avatarUrl: String,
    val backgroundImgId: Long,
    val backgroundUrl: String,
    val birthday: Long,
    val city: Int,
    val createTime: Long,
    val defaultAvatar: Boolean,
    val description: Any,
    val detailDescription: Any,
    val djStatus: Int,
    val expertTags: Any,
    val experts: Any,
    val followed: Boolean,
    val gender: Int,
    val lastLoginIP: String,
    val lastLoginTime: Long,
    val locationStatus: Int,
    val mutual: Boolean,
    val nickname: String,
    val province: Int,
    val remarkName: Any,
    val shortUserName: String,
    val signature: String,
    val userId: Int,
    val userName: String,
    val userType: Int,
    val vipType: Int,
    val viptypeVersion: Long
)