package com.junior.kekod.kotlinstudyapp.di

import com.junior.kekod.kotlinstudyapp.data.source.RemoteDataSource
import com.junior.kekod.kotlinstudyapp.data.source.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataSourceModule {

    @Binds
    @ViewModelScoped
    abstract fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource
}