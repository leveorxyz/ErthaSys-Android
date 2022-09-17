package dev.atick.network.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.atick.network.repository.ErthaSysRepository
import dev.atick.network.repository.ErthaSysRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindRepositoryModule(
        erthaSysRepositoryImpl: ErthaSysRepositoryImpl
    ): ErthaSysRepository
}