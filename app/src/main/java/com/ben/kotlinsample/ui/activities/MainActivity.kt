package com.ben.kotlinsample.ui.activities

import android.app.DownloadManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem

import com.ben.kotlinsample.ui.adapters.ForecastListAdapter
import com.ben.kotlinsample.R
import com.ben.kotlinsample.data.ForecastRequest
import com.ben.kotlinsample.domain.commands.RequestForecastCommand
import com.ben.kotlinsample.domain.model.Forecast

import org.jetbrains.anko.*

import kotlinx.android.synthetic.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        forecastList.setLayoutManager(LinearLayoutManager(this))

        async{
            val result = RequestForecastCommand("94043").execute()
            uiThread{
                forecastList.setAdapter(ForecastListAdapter(result,{toast(it.date)}))
            }
        }

    }
}
