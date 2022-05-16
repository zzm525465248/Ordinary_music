package com.example.kotlin_jetpack.bean



data class Banner(
    val banners: List<BannerX>,
    val code: Int
)

data class BannerX(
    val adDispatchJson: Any,
    val adLocation: Any,
    val adSource: Any,
    val adid: Any,
    val adurlV2: Any,
    val alg: Any,
    val bannerId: String,
    val dynamicVideoData: Any,
    val encodeId: String,
    val event: Any,
    val exclusive: Boolean,
    val extMonitor: Any,
    val extMonitorInfo: Any,
    val monitorBlackList: Any,
    val monitorClick: Any,
    val monitorClickList: List<Any>,
    val monitorImpress: Any,
    val monitorImpressList: List<Any>,
    val monitorType: Any,
    val pic: String,
    val pid: Any,
    val program: Any,
    val requestId: String,
    val scm: String,
    val showAdTag: Boolean,
    val showContext: Any,
    val song: Any,
    val targetId: Long,
    val targetType: Int,
    val titleColor: String,
    val typeTitle: String,
    val url: Any,
    val video: Any
)