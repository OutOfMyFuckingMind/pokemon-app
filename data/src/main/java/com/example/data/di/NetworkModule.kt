package com.example.data.di

import com.example.data.PokemonRepositoryImpl
import com.example.data.api.service.PokemonService
import com.example.domain.repository.PokemonRepository
import com.squareup.moshi.Moshi
import io.reactivex.schedulers.Schedulers
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

private const val BASE_URL = "BASE_URL"

private const val CACHE_FILENAME = "pokemon_api_cache"
private const val CACHE_MAX_SIZE = 50L * 1024L * 1024L

internal val networkModule = module {

    single(named(BASE_URL)) { "https://pokeapi.co/api/v2/" }

    single {
        Moshi.Builder()
            .build()
    }

    single<Converter.Factory> { MoshiConverterFactory.create(get()) }

    single<CallAdapter.Factory> { RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()) }

    single {
        OkHttpClient.Builder()
            .cache(Cache(
                maxSize = CACHE_MAX_SIZE,
                directory = File(androidContext().cacheDir, CACHE_FILENAME),
            ))
            .addInterceptor {

                val request = it.request().newBuilder()
                    .cacheControl(
                        CacheControl.Builder()
                            .maxAge(10, TimeUnit.DAYS)
                            .build()
                    )
                    .build()

                it.proceed(request)
            }
            .addNetworkInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .client(get())
            .baseUrl(get<String>(named(BASE_URL)))
            .addConverterFactory(get())
            .addCallAdapterFactory(get())
            .build()
    }

    single<PokemonService> { (retrofit: Retrofit) ->
        retrofit.create(PokemonService::class.java)
    }

    single<PokemonRepository> {
        PokemonRepositoryImpl(
            get(parameters = { parametersOf(get<Retrofit>()) })
        )
    }
}