package com.example.marsphotos.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.marsphotos.network.MarsPhoto

@Database(entities = [MarsPhotoEntity::class], version = 1)
abstract class MarsPhotoDatabase: RoomDatabase() {
    abstract fun marsPhotoDao(): MarsPhotoDao

    companion object {
        @Volatile
        private var INSTANCE: MarsPhotoDatabase? = null

        fun getDatabase(context: Context): MarsPhotoDatabase{
            val instance = INSTANCE
            if (instance != null){
                return instance
            }
            synchronized(this){
                val instance0 = Room.databaseBuilder(
                    context,
                    MarsPhotoDatabase::class.java,
                    "mars_photo_database"
                ).build()
                INSTANCE = instance0
                return instance0
            }

        }
    }
}