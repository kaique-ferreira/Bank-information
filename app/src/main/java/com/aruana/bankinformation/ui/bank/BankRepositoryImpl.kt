package com.aruana.bankinformation.ui.bank

import com.aruana.bankinformation.networking.BankService
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class BankRepositoryImpl @Inject constructor(private val bankService: BankService) : BankRepository {

    override fun getBankByBlz(blz: String): Single<List<BankModel>> {
        return Observable.range(0, Int.MAX_VALUE)
                .concatMap { bankService.bankByBlz(blz, it).toObservable() }
                .takeWhile { it.data.bics.isNotEmpty() }
                .reduce(mutableListOf<BankModel>()) { banks, bankApiModel ->
                    banks.addAll(bankApiModel.data.bics)
                    banks
                }
                .map { it.toList() }
    }
}