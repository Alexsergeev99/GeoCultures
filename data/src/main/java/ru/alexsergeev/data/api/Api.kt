package ru.alexsergeev.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import ru.alexsergeev.data.BuildConfig
import ru.alexsergeev.data.models.ListResponse
import java.util.concurrent.TimeUnit

internal const val BASE_URL = "https://shans.d2.i-partner.ru/api/ppp/"

internal interface ApiService {
    @GET("index/")
    suspend fun getAll(
        @Query("id") id: Int,
        @Query("search") search: String? = null,
        @Query("crop_id") cropId: Int,
        @Query("harmful_object_id") harmfulObjectId: Int,
        @Query("ingredient_id") ingredientId: Int,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Response<List<ListResponse>>
}

internal fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .connectTimeout(100, TimeUnit.SECONDS)
        .build()
} else OkHttpClient
    .Builder()
    .connectTimeout(100, TimeUnit.SECONDS)
    .build()

internal fun provideRetrofit(
    okHttpClient: OkHttpClient,
): Retrofit =
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

internal fun provideApiService(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)

