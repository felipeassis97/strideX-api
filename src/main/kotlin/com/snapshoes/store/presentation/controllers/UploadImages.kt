package com.snapshoes.store.presentation.controllers

import com.snapshoes.store.config.bucket.BucketClientService
import com.snapshoes.store.config.bucket.BucketFileDestination
import com.snapshoes.store.persistence.entities.UserRole
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/s3/files")
class UploadImages(private val client: BucketClientService) {

    @PostMapping(headers = ["content-type=multipart/*"])
    fun upload(
        @RequestPart(value = "file") file: MultipartFile
    ): ResponseEntity<String> {
        val url = client.uploadObject(file, BucketFileDestination(
            userIdentifier = "admin@email.com",
            role = UserRole.ADMIN,
        ))
        val location = url.toURI()

        return ResponseEntity
            .created(location)
            .build()
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(
        @PathVariable id: String
    ) = client.deleteObject(id, BucketFileDestination(
        userIdentifier = "felipeassis97@gmail.com",
        role = UserRole.STORE,
    ))


    @PutMapping("/{id}", headers = ["content-type=multipart/*"])
    fun modify(
        @PathVariable id: String,
        @RequestPart(value = "file") file: MultipartFile
    ): ResponseEntity<String> {
        val url = client.modifyObject(id, file, BucketFileDestination(
            userIdentifier = "admin@email.com",
            role = UserRole.ADMIN,
        ))
        val location = url.toURI()

        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .location(location)
            .build()
    }
}