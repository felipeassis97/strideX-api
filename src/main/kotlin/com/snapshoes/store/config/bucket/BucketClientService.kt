package com.snapshoes.store.config.bucket

import java.net.URL
import org.springframework.web.multipart.MultipartFile

interface BucketClientService {
    fun deleteObject(id: String, bucketFileDestination: BucketFileDestination)
    fun uploadObject(multipartFile: MultipartFile, bucketFileDestination: BucketFileDestination): URL
    fun modifyObject(id: String, multipartFile: MultipartFile, bucketFileDestination: BucketFileDestination): URL
}