package com.borlanddev.cinamavibe.model

sealed class UserFile {
    data class FilmFrame(val id: String) : UserFile()

    data class Soundtrack(val id: String) : UserFile()

    data class MovieScene(val id: String) : UserFile()
}
