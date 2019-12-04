package com.aruana.bankinformation.di

import com.aruana.bankinformation.ui.biciban.IbanRepository
import com.aruana.bankinformation.ui.biciban.IbanRepositoryImpl
import com.aruana.bankinformation.ui.biciban.ValidateIban
import com.aruana.bankinformation.ui.biciban.ValidateIbanImpl
import dagger.Binds
import dagger.Module

@Module
abstract class IbanModule {

    @Binds
    abstract fun provideValidateIbanUseCase(useCase: ValidateIbanImpl): ValidateIban

    @Binds
    abstract fun provideRepository(repository: IbanRepositoryImpl): IbanRepository
}