package com.example.reidmcpherson.kotlin

import android.app.Application
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class App : Application() {

    object DelegatesExt {
        fun <T> notNullSingleValue(): ReadWriteProperty<Any?, T> = NotNullSingelValueVar()
    }

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    private class NotNullSingelValueVar<T> : ReadWriteProperty<Any?, T> {

        private var value: T? = null

        override fun getValue(thisRef: Any?, property: KProperty<*>): T {
            return value ?: throw IllegalStateException("Not yet initialized")
        }

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
            this.value = if (this.value == null) value
            else throw IllegalStateException("Already initialized")
        }

    }
}
