package com.example.marsphotos.data

import android.content.Context
import androidx.room.Room
import com.example.marsphotos.MarsPhotosApplication
import com.example.marsphotos.database.MarsPhotoDatabase
import com.example.marsphotos.network.MarsApiService
import com.example.marsphotos.util.PhotoToEntityMapper
import kotlinx.serialization.ExperimentalSerializationApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.coroutineContext

interface AppContainer {
    val marsPhotosRepository: MarsPhotosRepository
}

class DefaultAppContainer(context: Context): AppContainer{
    private val BASE_URL =
        "https://android-kotlin-fun-mars-server.appspot.com"

    private val retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

    private val retrofitService: MarsApiService by lazy{
        retrofit.create(MarsApiService::class.java)
    }

    override val marsPhotosRepository: MarsPhotosRepository by lazy{
        OfflineMarsPhotosRepository(retrofitService, MarsPhotoDatabase.getDatabase(context).marsPhotoDao())
        //DefaultMarsPhotosRepository(retrofitService)
    }
}