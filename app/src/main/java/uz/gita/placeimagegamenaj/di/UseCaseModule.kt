package uz.gita.placeimagegamenaj.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.placeimagegamenaj.domain.GameUseCase
import uz.gita.placeimagegamenaj.domain.GameUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindsGameUseCase(impl: GameUseCaseImpl): GameUseCase

}