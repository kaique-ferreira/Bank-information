package com.aruana.bankinformation.ui.bank

import io.reactivex.Single
import javax.inject.Inject

class FindBankByBlzImpl @Inject constructor(private val bankRepository: BankRepository) : FindBankByBlz() {

    override fun createSingleUseCase(params: Params): Single<List<BankModel>> {
        return if (params.blz.isNotEmpty()) {
            bankRepository.getBankByBlz(params.blz)
        } else {
            Single.just(emptyList())
        }
    }
}