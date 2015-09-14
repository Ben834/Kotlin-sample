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

public class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList : RecyclerView = find(R.id.forecast_list)
        forecastList.setLayoutManager(LinearLayoutManager(this))

        async{
            val result = RequestForecastCommand("94043").execute()
            uiThread{
                forecastList.setAdapter(ForecastListAdapter(result, object : ForecastListAdapter.OnItemClickListener{
                    override  fun invoke(forecast: Forecast){
                        toast(forecast.date)
                    }
                }));
            }
        }

    }
}
