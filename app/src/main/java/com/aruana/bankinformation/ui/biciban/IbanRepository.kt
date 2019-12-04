package com.aruana.bankinformation.ui.biciban

import io.reactivex.Single

interface IbanRepository {

    fun isIbanValid(iban: String): Single<Boolean>
}