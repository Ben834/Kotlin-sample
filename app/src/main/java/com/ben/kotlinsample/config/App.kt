package com.ben.kotlinsample.config

import android.app.Application
import android.database.sqlite.SQLiteOpenHelper
import kotlin.properties.Delegates

/** Custom application **/
class App: Application(){

    companion object{
        var instance : Application by NotNullSingleValueVar()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}