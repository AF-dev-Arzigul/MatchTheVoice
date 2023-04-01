package uz.gita.placeimagegamenaj.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.placeimagegamenaj.repository.GameRepository
import uz.gita.placeimagegamenaj.repository.GameRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @[Binds Singleton]
    fun bindGameRepository(impl: GameRepositoryImpl): GameRepository

}