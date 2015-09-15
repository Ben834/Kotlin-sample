package com.ben.kotlinsample.domain.commands

/**
 * The commands will execute an operation and return an object of the class specified
 * in its generic type
**/
private interface Command<T>{
    fun execute() : T
}
