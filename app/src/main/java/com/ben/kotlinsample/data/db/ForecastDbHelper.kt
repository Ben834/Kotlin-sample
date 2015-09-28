package com.ben.kotlinsample.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.ben.kotlinsample.config.App
import org.jetbrains.anko.db.*


/** Channel between object oriented and SQL worlds **/
internal class ForecastDbHelper(ctx : Context = App.instance) : ManagedSQLiteOpenHelper(ctx,
        ForecastDbHelper.DB_NAME, null, ForecastDbHelper.DB_VERSION){

    override fun onCreate(db: SQLiteDatabase) {

        db.createTable(
                CityForecastTable.NAME,
                true,
                CityForecastTable.ID to INTEGER + PRIMARY_KEY,
                CityForecastTable.CITY to TEXT,
                CityForecastTable.COUNTRY to TEXT
        )

        db.createTable(
                DayForecastTable.NAME,
                true,
                DayForecastTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                DayForecastTable.DATE to INTEGER,
                DayForecastTable.DESCRIPTION to TEXT,
                DayForecastTable.HIGH to INTEGER,
                DayForecastTable.LOW to INTEGER,
                DayForecastTable.ICON_URL to TEXT,
                DayForecastTable.CITY_ID to INTEGER
        )

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(CityForecastTable.NAME, true)
        db.dropTable(DayForecastTable.NAME, true)
        onCreate(db)
    }

    companion object{
        val DB_NAME = "forecast.db"
        val DB_VERSION = 1
        //The object won't be created until it's used. If the DB is never used, we don't create unnecessary objects.
        val instance: ForecastDbHelper by lazy{
            ForecastDbHelper()
        }
    }

}
