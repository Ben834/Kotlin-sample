package com.ben.kotlinsample.ui.utils

import android.content.Context
import android.view.View

//Property extension
internal val View.ctx : Context
    get() = getContext()
