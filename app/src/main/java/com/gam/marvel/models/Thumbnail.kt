package com.gam.marvel.models

class Thumbnail {

     var path: String = ""
     var extension: String = ""

    val imagePath: String
        get() = "$path.$extension"
}