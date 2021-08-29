package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {

    private val disposables: CompositeDisposable = CompositeDisposable()

    fun Disposable.disposeOnFinish() {
        disposables.add(this)
    }

    override fun onCleared() {
        disposables.dispose()
    }
}