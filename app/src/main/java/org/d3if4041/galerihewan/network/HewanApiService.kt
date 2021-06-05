package org.d3if4041.galerihewan.network

import com.squareup.moshi.Moshi
import org.d3if4041.galerihewan.Hewan
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://dif.indraazimi.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory((MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface HewanApiService {
    @GET("listhewan.json")
    suspend fun getHewan(): List<Hewan>
}

object HewanApi {
    val service: HewanApiService by lazy {
        retrofit.create(HewanApiService::class.java)
    }
}
