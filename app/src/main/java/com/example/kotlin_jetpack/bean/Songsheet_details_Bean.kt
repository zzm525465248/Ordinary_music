package com.example.kotlin_jetpack.bean

data class Songsheet_details_Bean(
    val code: Int,
    val playlist: Playlist,
    val privileges: List<Privilege>,
    val relatedVideos: Any,
    val resEntrance: Any,
    val sharedPrivilege: Any,
    val urls: Any
)

data class Playlist(
    val adType: Int,
    val backgroundCoverId: Long,
    val backgroundCoverUrl: Any,
    val cloudTrackCount: Int,
    val commentCount: Int,
    val commentThreadId: String,
    val coverImgId: Long,
    val coverImgId_str: Any,
    val coverImgUrl: String,
    val createTime: Long,
    val creator: Creator,
    val description: Any,
    val englishTitle: Any,
    val highQuality: Boolean,
    val historySharedUsers: Any,
    val id: Long,
    val name: String,
    val newImported: Boolean,
    val officialPlaylistType: Any,
    val opRecommend: Boolean,
    val ordered: Boolean,
    val playCount: Int,
    val privacy: Int,
    val remixVideo: Any,
    val shareCount: Int,
    val sharedUsers: Any,
    val specialType: Int,
    val status: Int,
    val subscribed: Any,
    val subscribedCount: Int,
    val subscribers: List<Any>,
    val tags: List<Any>,
    val titleImage: Long,
    val titleImageUrl: Any,
    val trackCount: Int,
    val trackIds: List<TrackId>,
    val trackNumberUpdateTime: Long,
    val trackUpdateTime: Long,
    val tracks: List<Track>,
    val updateFrequency: Any,
    val updateTime: Long,
    val userId: Long,
    val videoIds: Any,
    val videos: Any
)

data class Privilege(
    val chargeInfoList: List<ChargeInfo1>,
    val cp: Int,
    val cs: Boolean,
    val dl: Int,
    val dlLevel: String,
    val downloadMaxBrLevel: String,
    val downloadMaxbr: Int,
    val fee: Int,
    val fl: Int,
    val flLevel: String,
    val flag: Int,
    val freeTrialPrivilege: FreeTrialPrivilege2,
    val id: Int,
    val maxBrLevel: String,
    val maxbr: Int,
    val paidBigBang: Boolean,
    val payed: Int,
    val pc: Any,
    val pl: Int,
    val plLevel: String,
    val playMaxBrLevel: String,
    val playMaxbr: Int,
    val preSell: Boolean,
    val realPayed: Int,
    val rscl: Int,
    val sp: Int,
    val st: Int,
    val subp: Int,
    val toast: Boolean
)

data class Creator(
    val accountStatus: Int,
    val anchor: Boolean,
    val authStatus: Int,
    val authenticationTypes: Int,
    val authority: Int,
    val avatarDetail: Any,
    val avatarImgId: Long,
    val avatarImgIdStr: String,
    val avatarUrl: String,
    val backgroundImgId: Long,
    val backgroundImgIdStr: String,
    val backgroundUrl: String,
    val birthday: Int,
    val city: Int,
    val defaultAvatar: Boolean,
    val description: String,
    val detailDescription: String,
    val djStatus: Int,
    val expertTags: Any,
    val experts: Any,
    val followed: Boolean,
    val gender: Int,
    val mutual: Boolean,
    val nickname: String,
    val province: Int,
    val remarkName: Any,
    val signature: String,
    val userId: Long,
    val userType: Int,
    val vipType: Int
)

data class TrackId(
    val alg: Any,
    val at: Long,
    val id: Int,
    val rcmdReason: String,
    val sc: Any,
    val t: Int,
    val uid: Long,
    val v: Int
)

data class Track(
    val a: Any,
    val al: Al1,
    val alia: List<String>,
    val ar: List<Ar1>,
    val cd: String,
    val cf: String,
    val copyright: Int,
    val cp: Int,
    val crbt: Any,
    val djId: Int,
    val dt: Int,
    val entertainmentTags: Any,
    val fee: Int,
    val ftype: Int,
    val h: H1,
    val hr: Any,
    val id: Int,
    val l: L1,
    val m: M1,
    val mark: Long,
    val mst: Int,
    val mv: Int,
    val name: String,
    val no: Int,
    val noCopyrightRcmd: Any,
    val originCoverType: Int,
    val originSongSimpleData: Any,
    val pop: Int,
    val pst: Int,
    val publishTime: Long,
    val resourceState: Boolean,
    val rt: String,
    val rtUrl: Any,
    val rtUrls: List<Any>,
    val rtype: Int,
    val rurl: Any,
    val s_id: Int,
    val single: Int,
    val songJumpInfo: Any,
    val sq: Sq,
    val st: Int,
    val t: Int,
    val tagPicList: Any,
    val v: Int,
    val version: Int
)

data class Al1(
    val id: Int,
    val name: String,
    val pic: Long,
    val picUrl: String,
    val tns: List<Any>
)

data class Ar1(
    val alias: List<Any>,
    val id: Int,
    val name: String,
    val tns: List<Any>
)

data class H1(
    val br: Int,
    val fid: Int,
    val size: Int,
    val vd: Float
)

data class L1(
    val br: Int,
    val fid: Int,
    val size: Int,
    val vd: Double
)

data class M1(
    val br: Int,
    val fid: Int,
    val size: Int,
    val vd: Double
)

data class Sq(
    val br: Int,
    val fid: Int,
    val size: Int,
    val vd: Int
)

data class ChargeInfo1(
    val chargeMessage: Any,
    val chargeType: Int,
    val chargeUrl: Any,
    val rate: Int
)

data class FreeTrialPrivilege2(
    val listenType: Any,
    val resConsumable: Boolean,
    val userConsumable: Boolean
)