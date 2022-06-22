package com.gam.marvel.models

class CharacterMarvel {

    var id: Long = 0
    var name: String = ""
    var description: String = ""
    var modified: String = ""
    var thumbnail: Thumbnail = Thumbnail()
    var comics: ListWrapper<OccurrenceDto> = ListWrapper()
    var series: ListWrapper<OccurrenceDto> = ListWrapper()
    var stories: ListWrapper<OccurrenceDto> = ListWrapper()
    var events: ListWrapper<OccurrenceDto> = ListWrapper()

    val imageUrl: String
        get() = thumbnail.imagePath
}