package com.aruana.bankinformation.ui.bank

import io.reactivex.Single

interface BankRepository {

    fun getBankByBlz(blz: String): Single<List<BankModel>>
}