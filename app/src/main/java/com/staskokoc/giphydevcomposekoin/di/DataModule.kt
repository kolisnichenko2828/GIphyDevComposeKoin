package com.staskokoc.giphydevcomposekoin.di

import com.staskokoc.giphydevcomposekoin.data.GiphyApi
import com.staskokoc.giphydevcomposekoin.data.GiphyRepositoryImpl
import com.staskokoc.giphydevcomposekoin.domain.GiphyRepository
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val baseUrl = "https://api.giphy.com/v1/gifs/"

val dataModule = module {

    single<GiphyApi> {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient as OkHttpClient)
            .build()
        val service = retrofit.create(GiphyApi::class.java)

        service
    }

    single<GiphyRepository> {
        GiphyRepositoryImpl(giphyApi = get())
    }
}