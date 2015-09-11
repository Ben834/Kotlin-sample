package com.ben.kotlinsample.data

import android.util.Log
import java.net.URL

public class Request(val url: String){

    /** Reads the url content and return it **/
    public fun run(){
        //readText() not recommended for huge responses, but will do fine for now
        val forecastJsonStr = URL(url).readText();
        Log.d(javaClass.getSimpleName(), forecastJsonStr);
    }

}