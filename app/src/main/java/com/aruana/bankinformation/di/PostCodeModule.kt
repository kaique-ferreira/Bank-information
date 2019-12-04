package com.aruana.bankinformation.di

import com.aruana.bankinformation.ui.postcode.*
import dagger.Binds
import dagger.Module

@Module
abstract class PostCodeModule {

    @Binds
    abstract fun provideValidatePostCodeUseCase(useCase: ValidatePostCodeImpl): ValidatePostCode

    @Binds
    abstract fun provideGetSupportedCountriesUseCase(useCase: GetAllSupportedCountriesImpl): GetAllSupportedCountries

    @Binds
    abstract fun provideRepository(repository: PostCodeRepositoryImpl): PostCodeRepository
}