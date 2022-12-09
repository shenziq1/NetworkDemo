package com.example.marsphotos.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MarsPhotoDao {
    @Query("SELECT * FROM marsPhotoEntity")
    suspend fun getAll(): List<MarsPhotoEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(marsPhotoEntity: MarsPhotoEntity)
}