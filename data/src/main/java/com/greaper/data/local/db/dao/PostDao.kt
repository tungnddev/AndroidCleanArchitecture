package com.greaper.data.local.db.dao

import androidx.room.*
import com.greaper.data.model.entity.PostEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(userEntity: PostEntity)

    @Query("SELECT * FROM post WHERE id = :id")
    suspend fun findById(id: String): PostEntity

    @Query("SELECT * FROM post")
    suspend fun getAll(): List<PostEntity>

    @Query("DELETE FROM post WHERE id = :id")
    suspend fun deleteById(id: String)

    @Update
    suspend fun update(post: PostEntity)
}