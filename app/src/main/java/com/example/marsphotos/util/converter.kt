package com.example.marsphotos.util

import com.example.marsphotos.database.MarsPhotoEntity
import com.example.marsphotos.network.MarsPhoto

interface Mapper<E, D> {
    fun EtoD(e: E): D
    fun DtoE(d: D): E
}

class PhotoToEntityMapper: Mapper<MarsPhotoEntity, MarsPhoto> {
    override fun EtoD(e: MarsPhotoEntity): MarsPhoto {
        return MarsPhoto(
            id = e.id,
            img_src = e.imgSrc
        )
    }

    override fun DtoE(d: MarsPhoto): MarsPhotoEntity {
        return MarsPhotoEntity(
            id = d.id,
            imgSrc = d.img_src
        )
    }
    companion object{
        val photoToEntityMapper = PhotoToEntityMapper()
    }
}