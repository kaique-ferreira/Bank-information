package com.aruana.bankinformation.di

import com.aruana.bankinformation.ui.biciban.BicRepository
import com.aruana.bankinformation.ui.biciban.BicRepositoryImpl
import com.aruana.bankinformation.ui.biciban.ValidateBic
import com.aruana.bankinformation.ui.biciban.ValidateBicImpl
import dagger.Binds
import dagger.Module

@Module
abstract class BicModule {

    @Binds
    abstract fun provideValidateBicUseCase(useCase: ValidateBicImpl): ValidateBic

    @Binds
    abstract fun provideRepository(repository: BicRepositoryImpl): BicRepository
}