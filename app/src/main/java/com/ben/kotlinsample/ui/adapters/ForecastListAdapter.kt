package com.ben.kotlinsample.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.ben.kotlinsample.R

import com.ben.kotlinsample.domain.model.Forecast
import com.ben.kotlinsample.domain.model.ForecastList
import com.ben.kotlinsample.ui.utils.ctx

import com.squareup.picasso.Picasso
import org.jetbrains.anko.layoutInflater
import org.jetbrains.anko.onClick

import kotlinx.android.synthetic.item_forecast.view.*

/**
 * The adapter for displaying the forecast
 */
class ForecastListAdapter(val weekForecast: ForecastList, val itemClick: (Forecast) -> Unit) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder? {
        val view = parent.ctx.layoutInflater.inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    override fun getItemCount(): Int = weekForecast.size()

    /** The {@link ForecastListAdapter} view holder */
    private class ViewHolder(val view: View, val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(view){

        fun bindForecast(forecast: Forecast){
            with(forecast){
                Picasso.with(itemView.ctx).load(iconUrl).into(itemView.icon)
                view.date.text = date;
                view.maxTemperature.text = "${high.toString()}"
                view.minTemperature.text = "${low.toString()}"
                view.onClick { itemClick(forecast) }
            }
        }

    }
}