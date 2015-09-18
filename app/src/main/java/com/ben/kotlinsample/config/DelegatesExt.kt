package com.ben.kotlinsample.config

import kotlin.properties.ReadWriteProperty

/** Custom delegate properties **/
internal class NotNullSingleValueVar<T: Any>() : ReadWriteProperty<Any?, T>{

    private var value: T? = null

    override fun get(thisRef: Any?, desc: PropertyMetadata): T {
        return value ?: throw IllegalStateException("Property ${desc.name} should be initialized before get")
    }

    override fun set(thisRef: Any?, desc: PropertyMetadata, value: T) {
        this.value = if(this.value == null) value
        else throw  IllegalStateException("${desc.name} already initialized")
    }

}
