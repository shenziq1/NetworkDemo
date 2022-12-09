package com.example.marsphotos.fake

import com.example.marsphotos.data.DefaultMarsPhotosRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

class NetworkMarsPhotosRepositoryTest{
    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun networkMarsPhotosRepository_getMarsPhotos_verifyPhotoList() =
        runTest {
            val repository = DefaultMarsPhotosRepository(marsApiService = FakeMarsApiService())
            assertEquals(FakeDataSource.photoList, repository.getMarsPhotos())
        }
}
