package com.example.marsphotos.data

import com.example.marsphotos.database.MarsPhotoDao
import com.example.marsphotos.network.MarsApiService
import com.example.marsphotos.network.MarsPhoto
import com.example.marsphotos.util.PhotoToEntityMapper

interface MarsPhotosRepository {
    suspend fun getMarsPhotos(): List<MarsPhoto>
}

class DefaultMarsPhotosRepository(private val marsApiService: MarsApiService) :
    MarsPhotosRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> {
        return marsApiService.getPhotos()
    }
}

class OfflineMarsPhotosRepository(
    private val marsApiService: MarsApiService,
    private val marsPhotoDao: MarsPhotoDao
) : MarsPhotosRepository {
    override suspend fun getMarsPhotos(): List<MarsPhoto> {
        marsApiService.getPhotos().map { marsPhotoDao.insert(PhotoToEntityMapper.photoToEntityMapper.DtoE(it)) }
        return marsPhotoDao.getAll().map { PhotoToEntityMapper.photoToEntityMapper.EtoD(it) }
    }

}
