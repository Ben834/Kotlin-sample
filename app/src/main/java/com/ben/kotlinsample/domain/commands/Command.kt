package com.ben.kotlinsample.domain.commands

/**
 * The commands will execute an operation and return an object of the class specified
 * in its generic type
**/
public interface Command<T>{
    fun execute() : T
}
