package com.snapshoes.store.config.bucket.s3


import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.DeleteObjectRequest



import java.io.File
import java.net.URL
import java.util.*
import java.io.IOException
import java.io.FileOutputStream
import com.amazonaws.services.s3.AmazonS3
import org.springframework.stereotype.Component
import org.springframework.context.annotation.Primary
import com.amazonaws.services.s3.model.PutObjectRequest
import org.springframework.web.multipart.MultipartFile

import com.snapshoes.store.config.bucket.BucketClientService
import com.snapshoes.store.config.bucket.BucketFileDestination



@Primary
@Component
class S3ClientService(
    private val amazonS3: AmazonS3,
    private val properties: S3Properties
) : BucketClientService {

    override fun uploadObject(multipartFile: MultipartFile, bucketFileDestination: BucketFileDestination): URL {
        val path = generateFileDestination(bucketFileDestination)
        this.upload(null, multipartFile, bucketFileDestination)
        return amazonS3.getUrl(properties.bucket, path)
    }

    override fun deleteObject(id: String, bucketFileDestination: BucketFileDestination) =
        try {
            val path = fetchFileDestination(id, bucketFileDestination)

            amazonS3.deleteObject(
                DeleteObjectRequest(properties.bucket, path)
            )
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    override fun modifyObject(id: String, multipartFile: MultipartFile, bucketFileDestination: BucketFileDestination): URL {
        val path = fetchFileDestination(id, bucketFileDestination)

        if (amazonS3.doesObjectExist(properties.bucket, path)) {
            this.deleteObject(id, bucketFileDestination)
        }
        this.upload(id, multipartFile, bucketFileDestination)
        return amazonS3.getUrl(properties.bucket, id)
    }


    //Private methods
    private fun generateFileDestination(bucketFileDestination: BucketFileDestination): String {
        val id = UUID.randomUUID().toString()
        return "${bucketFileDestination.role.role}/${bucketFileDestination.userIdentifier}/${bucketFileDestination.path}/${bucketFileDestination.itemIdentifier}/$id"
    }

    private fun fetchFileDestination(id: String, bucketFileDestination: BucketFileDestination): String {
        return "${bucketFileDestination.role.role}/${bucketFileDestination.userIdentifier}/${bucketFileDestination.path}/${bucketFileDestination.itemIdentifier}/$id"
    }

    private fun upload(id: String?, multipartFile: MultipartFile, bucketFileDestination: BucketFileDestination) =
        try {
            val file = this.toFile(multipartFile)
            var path: String = ""

            path = if (id != null)
                fetchFileDestination(id, bucketFileDestination)
            else
                generateFileDestination(bucketFileDestination)

            amazonS3.putObject(
                PutObjectRequest(properties.bucket, path, file)
                    .withCannedAcl(
                        CannedAccessControlList.PublicRead
                    )
            )
            file.delete()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    private fun toFile(multipartFile: MultipartFile): File =
        try {
            val file = File(multipartFile.originalFilename!!)
            FileOutputStream(file).use {
                val fos = FileOutputStream(file)
                fos.write(multipartFile.bytes)
                fos.close()
                return file
            }
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
}