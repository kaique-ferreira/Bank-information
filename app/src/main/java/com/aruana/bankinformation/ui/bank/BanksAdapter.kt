package com.aruana.bankinformation.ui.bank

import androidx.recyclerview.widget.DiffUtil
import com.aruana.bankinformation.R
import com.aruana.bankinformation.databinding.DataBindingAdapter
import javax.inject.Inject

class BanksAdapter @Inject constructor() : DataBindingAdapter<BankModel>(DiffCallback()) {

    class DiffCallback : DiffUtil.ItemCallback<BankModel>() {
        override fun areItemsTheSame(oldItem: BankModel, newItem: BankModel) = oldItem.bankName == newItem.bankName

        override fun areContentsTheSame(oldItem: BankModel, newItem: BankModel) = oldItem.bankName == newItem.bankName
    }

    override fun getItemViewType(position: Int) = R.layout.bank_item
}