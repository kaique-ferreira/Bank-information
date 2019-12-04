package com.aruana.bankinformation.di

import com.aruana.bankinformation.common.*
import dagger.Binds
import dagger.Module

@Module
abstract class CommonModule {

    @Binds
    abstract fun provideValidateApiResultCode(validApiResultCode: ValidateApiResultCodeImpl): ValidateApiResultCode

    @Binds
    abstract fun provideValidationHandler(validationHandler: ValidationViewHandlerImpl): ValidationViewHandler

    @Binds
    abstract fun provideStateHandler(stateHandler: StateHandlerImpl): StateHandler
}
