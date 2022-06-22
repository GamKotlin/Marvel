package com.gam.marvel.providers.network

import com.gam.marvel.BuildConfig
import com.gam.marvel.providers.network.app.MarvelAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.math.BigInteger
import java.security.MessageDigest
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Retrofit {

    @Provides
    fun provideBaseUrl() = "http://gateway.marvel.com/v1/public/"

    @Singleton
    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        headersInterceptor: Interceptor
    ) =
        OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .callTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(headersInterceptor)
            .addInterceptor(addQueryParametersInterceptor())
            .build()

    @Singleton
    @Provides
    fun loggingInterceptor() = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
        else HttpLoggingInterceptor.Level.NONE
    }

    @Singleton
    @Provides
    fun headersInterceptor() = Interceptor { chain ->
        chain.proceed(
            chain.request().newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("Accept-Language", "en")
                .addHeader("Content-Type", "application/json")
                .build()
        )
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideAppAPI(retrofit: Retrofit): MarvelAPI = retrofit.create(MarvelAPI::class.java)


    private fun addQueryParametersInterceptor() = Interceptor { chain ->
        val request = chain.request()
        val timeStamp = System.currentTimeMillis()
        val url = request.url.newBuilder()
            .addQueryParameter("apikey", BuildConfig.PUBLIC_KEY)
            .addQueryParameter(
                "hash",
                createMd5(timeStamp.toString() + BuildConfig.PRIVATE_KEY + BuildConfig.PUBLIC_KEY)
            )
            .addQueryParameter("ts", "$timeStamp")
            .build()
        chain.proceed(request.newBuilder().url(url).build())
    }

    private fun createMd5(string: String): String {
        val messageDigest = getMd5Digest(string)
        val md5 = BigInteger(1, messageDigest).toString(16)
        return "0" * (32 - md5.length) + md5
    }

    private fun getMd5Digest(string: String): ByteArray =
        MessageDigest.getInstance("MD5").digest(string.toByteArray())

    private operator fun String.times(int: Int) = (1..int).fold("") { acc, _ -> acc + this }

}