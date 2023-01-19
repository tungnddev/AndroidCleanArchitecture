package com.greaper.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.greaper.data.local.db.dao.PostDao
import com.greaper.data.model.entity.PostEntity

@Database(entities = [PostEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}