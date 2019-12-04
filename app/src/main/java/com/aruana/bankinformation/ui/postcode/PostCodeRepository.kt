package com.aruana.bankinformation.ui.postcode

import io.reactivex.Single

interface PostCodeRepository {

    fun validatePostCode(postCode: String, countryCode: String): Single<Boolean>

    fun getSupportedCountriesList(): List<CountryModel>
}