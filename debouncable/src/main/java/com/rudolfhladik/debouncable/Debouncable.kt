package com.rudolfhladik.debouncable

import android.os.SystemClock

interface Debouncable : LastAction {

    val lastState
        get() = DebouncableState

    val defaultDebounceLimit
        get() = 200L

    override fun getTimestamp() =
        DebouncableState.lastAction

    override fun setTimestamp(timestamp: Long) {
        DebouncableState.lastAction = timestamp
    }

    object DebouncableState {
        internal var lastAction = 0L
    }

    fun debounceAction(debounceTimeMilis: Long = defaultDebounceLimit, action: () -> Unit) {
        val previousClickTimestamp = getTimestamp()
        val currentTimestamp = SystemClock.uptimeMillis()

        if (currentTimestamp - previousClickTimestamp > debounceTimeMilis) {
            action.invoke()
        }
        DebouncableState.lastAction = currentTimestamp
    }
}

interface LastAction {
    fun getTimestamp(): Long
    fun setTimestamp(timestamp: Long)
}
