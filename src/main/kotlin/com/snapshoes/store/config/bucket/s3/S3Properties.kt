package com.snapshoes.store.config.bucket.s3

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("s3")
data class S3Properties(
    val access: String,
    val secret: String,
    val region: String,
    val bucket: String
)
