package com.snapshoes.store.config.bucket.s3

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.snapshoes.store.config.bucket.BucketClientService
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@EnableConfigurationProperties(S3Properties::class)
class S3Configuration(private val properties: S3Properties) {

    @Bean
    fun amazonS3(): AmazonS3 {
        val credentials = BasicAWSCredentials(
            properties.access,
            properties.secret
        )

        return AmazonS3ClientBuilder.standard()
            .withRegion(properties.region)
            .withCredentials(
                AWSStaticCredentialsProvider(credentials)
            )
            .build()
    }
}