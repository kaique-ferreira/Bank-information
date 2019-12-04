package com.aruana.bankinformation.networking

import com.aruana.bankinformation.ui.bank.BankModel

data class ApiBankModel(val data: Data)

data class Data(val page: Int, val pageCount: Int, val bics: List<BankModel>)