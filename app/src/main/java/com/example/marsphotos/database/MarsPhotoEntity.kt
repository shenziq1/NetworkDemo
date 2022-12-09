package com.example.marsphotos.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "marsPhotoEntity")
data class MarsPhotoEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "img_src") val imgSrc: String
)