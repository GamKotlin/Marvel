package com.gam.marvel.providers.network.app

import com.gam.marvel.models.CharacterMarvel
import com.gam.marvel.models.DataWrapper
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class MarvelNetworkProvider @Inject constructor(var api: MarvelAPI) {
    fun getAll(offset: Int, limit: Int): Observable<DataWrapper<List<CharacterMarvel>>> =
        api.getAll(offset, limit)

    fun getById(id: Long): Observable<DataWrapper<List<CharacterMarvel>>> =
        api.getById(id)
}