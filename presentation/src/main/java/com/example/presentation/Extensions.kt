package com.example.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

fun Context.inflate(
    @LayoutRes layoutId: Int,
    parent: ViewGroup,
): View {
    return LayoutInflater.from(this).inflate(layoutId, parent, false)
}

fun View.inflate(
    @LayoutRes layoutId: Int,
    parent: ViewGroup,
): View {
    return this.context.inflate(layoutId, parent)
}

@Suppress("unused")
fun Fragment.inflate(
    @LayoutRes layoutId: Int,
    parent: ViewGroup,
): View {
    return this.requireContext().inflate(layoutId, parent)
}