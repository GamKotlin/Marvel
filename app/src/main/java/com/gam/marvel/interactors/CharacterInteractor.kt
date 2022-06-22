package com.gam.marvel.interactors

import com.gam.marvel.models.CharacterMarvel
import com.gam.marvel.models.DataWrapper
import com.gam.marvel.providers.network.app.MarvelNetworkProvider
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class CharacterInteractor @Inject constructor(
    private var networkProvider: MarvelNetworkProvider
) {

    companion object {
        const val elementsOnListLimit = 50
    }

    fun getAll(
        onListReceived: (Result<DataWrapper<List<CharacterMarvel>>>) -> Unit
    ) {
        networkProvider.getAll(offset = 0, limit = elementsOnListLimit)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    onListReceived(Result.success(it))
                },
                {
                    onListReceived(Result.failure(it))
                }
            )
    }

    fun getById(
        id: Long,
        onFormCheckHeaderReceived: (Result<DataWrapper<List<CharacterMarvel>>>) -> Unit
    ) {
        networkProvider.getById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    onFormCheckHeaderReceived(Result.success(it))
                },
                {
                    onFormCheckHeaderReceived(Result.failure(it))
                }
            )
    }
}