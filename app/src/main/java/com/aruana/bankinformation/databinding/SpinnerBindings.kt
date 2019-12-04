package com.aruana.bankinformation.databinding

import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.BindingAdapter

@BindingAdapter("items")
fun Spinner.setItems(items: List<Any>?) {
    if (items != null) {
        val arrayAdapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, items)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        this.adapter = arrayAdapter
    }
}
