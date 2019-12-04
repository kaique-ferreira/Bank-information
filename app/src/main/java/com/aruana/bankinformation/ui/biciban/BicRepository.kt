package com.aruana.bankinformation.ui.biciban

import io.reactivex.Single

interface BicRepository {

    fun isBicValid(bic: String): Single<Boolean>
}