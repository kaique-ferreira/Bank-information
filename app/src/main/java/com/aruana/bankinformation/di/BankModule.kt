package com.aruana.bankinformation.di

import com.aruana.bankinformation.ui.bank.BankRepository
import com.aruana.bankinformation.ui.bank.BankRepositoryImpl
import com.aruana.bankinformation.ui.bank.FindBankByBlz
import com.aruana.bankinformation.ui.bank.FindBankByBlzImpl
import dagger.Binds
import dagger.Module

@Module
abstract class BankModule {

    @Binds
    abstract fun provideFindBankByBlzUseCase(useCase: FindBankByBlzImpl): FindBankByBlz

    @Binds
    abstract fun provideRepository(repository: BankRepositoryImpl): BankRepository
}