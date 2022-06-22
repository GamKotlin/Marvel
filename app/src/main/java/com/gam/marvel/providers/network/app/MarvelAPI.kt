package com.gam.marvel.providers.network.app

import com.gam.marvel.models.CharacterMarvel
import com.gam.marvel.models.DataWrapper
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelAPI {

    @GET("characters")
    fun getAll(
        @Query("offset") offset: Int?,
        @Query("limit") limit: Int?,
        //@Query("nameStartsWith") searchQuery: String?
    ): Observable<DataWrapper<List<CharacterMarvel>>>

    @GET("characters")
    fun getById(
        @Query("id") id: Long?
    ): Observable<DataWrapper<List<CharacterMarvel>>>

}