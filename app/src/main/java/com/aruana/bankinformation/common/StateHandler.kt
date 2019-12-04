package com.aruana.bankinformation.common

import android.view.View
import android.widget.ProgressBar
import javax.inject.Inject

class StateHandlerImpl @Inject constructor() : StateHandler {

    override fun handleState(state: State?, progressBar: ProgressBar) {
        when (state) {
            State.LOADING -> progressBar.visibility = View.VISIBLE
            State.FINISHED_LOADING -> progressBar.visibility = View.GONE
            else -> progressBar.visibility = View.GONE
        }
    }
}

interface StateHandler {

    fun handleState(state: State?, progressBar: ProgressBar)
}