package com.aruana.bankinformation.networking

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface BankService {

    @GET("searchBic")
    fun bankByBlz(@Query("blz") blz: String, @Query("page") page: Int): Single<ApiBankModel>

    @GET("validateBic")
    fun validateBic(@Query("bic") bic: String): Single<ApiValidationModel>

    @GET("validateIban")
    fun validateIban(@Query("iban") iban: String): Single<ApiValidationModel>

    @GET("validatePostCode")
    fun validatePostalCode(@Query("postCode") postCode: String, @Query("countryCode") countryCode: String): Single<ApiValidationModel>

    companion object {
        const val API_ENDPOINT = "https://tyre24.alzura.com/de/de/rest/v12/utils/"

        const val USER_NAME = "106901"
        const val PASSWORD = "MTYzYmZkNjZiZmJiMTg2M2IwNjU2Nzk5NzI5OTVjNGY"
    }
}