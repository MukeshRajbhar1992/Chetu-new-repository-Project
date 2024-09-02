package com.example.chetunewretrofitproject.apiutil

import com.example.chetunewretrofitproject.model.AlbumList
import com.example.chetunewretrofitproject.model.PhotosList
import com.example.chetunewretrofitproject.model.PostsResult
import com.example.chetunewretrofitproject.model.CommentsList
import com.example.chetunewretrofitproject.model.ListPopularPerson
import com.example.chetunewretrofitproject.model.MoviesList
import com.example.chetunewretrofitproject.model.TodosList
import com.example.chetunewretrofitproject.model.TvShowList
import com.example.chetunewretrofitproject.model.UsersList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("/posts")
    fun getPosts() : Call<PostsResult>

    @GET("/photos")
    fun getPhotos() : Call<PhotosList>

    @GET("/comments")
    fun getComment() : Call<CommentsList>

    @GET("/albums")
    fun getAlbums() : Call<AlbumList>

    @GET("/albums")
    fun getTodos() : Call<TodosList>

    @GET("/users")
    fun getUsers() : Call<UsersList>

    @GET("/3/movie/popular?")
    fun getMovies(@Query ("api_key") key:String) : Call<MoviesList>

    @GET("/3/tv/popular?")
    fun getTVShows(@Query ("api_key") key:String) : Call<TvShowList>

    @GET("/3/person/popular?")
    fun getPerson(@Query ("api_key") key:String) : Call<ListPopularPerson>

}