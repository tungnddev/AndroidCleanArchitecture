package com.greaper.data.di.module

import android.content.Context
import androidx.room.Room
import com.greaper.data.local.db.AppDatabase
import com.greaper.data.Constants
import com.greaper.data.repository.PostRepositoryImpl
import com.greaper.data.repository.UserRepositoryImpl
import com.greaper.data.di.DatabaseInfo
import com.greaper.domain.repository.PostRepository
import com.greaper.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @DatabaseInfo
    fun providerDatabaseName(): String {
        return Constants.DATABASE_NAME
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@DatabaseInfo dbName: String, @ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, dbName).fallbackToDestructiveMigration()
                .build()
    }


    @Provides
    @Singleton
    fun providerUserRepository(repository: UserRepositoryImpl): UserRepository {
        return repository
    }

    @Provides
    @Singleton
    fun providerItemRepository(repository: PostRepositoryImpl): PostRepository {
        return repository
    }
}
