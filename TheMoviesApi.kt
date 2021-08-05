package model

import model.ApiConsts.DEFAULT_QUERY
import model.ApiConsts.PATH_MOVIE_ID
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TheMoviesApi {
    @GET("3/movie/popular?$DEFAULT_QUERY")
    fun listPopular(): Call<MovieList>

    @GET("3/movie/{$PATH_MOVIE_ID}?$DEFAULT_QUERY")
    fun getMovieById(@Path(PATH_MOVIE_ID)id:Int): Call<MovieModel>
}
object ApiConsts{
    private const val API_KEY = "639faf10afa95ed69c46a4df2b5b8581"
    const val  PATH_MOVIE_ID = "id"
    const val  DEFAULT_QUERY = "api_key=$API_KEY&language=en-US&page=1"
}

