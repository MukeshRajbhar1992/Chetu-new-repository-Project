package com.example.chetunewretrofitproject.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.chetunewretrofitproject.model.AlbumList
import com.example.chetunewretrofitproject.model.AlbumListItem
import com.example.chetunewretrofitproject.model.CommentsList
import com.example.chetunewretrofitproject.model.ListPopularPerson
import com.example.chetunewretrofitproject.model.MoviesList
import com.example.chetunewretrofitproject.model.MoviesListItem
import com.example.chetunewretrofitproject.model.PhotosList
import com.example.chetunewretrofitproject.model.PhotosListItem
import com.example.chetunewretrofitproject.model.PostsListItem
import com.example.chetunewretrofitproject.model.PostsResult
import com.example.chetunewretrofitproject.model.PopularPersonListItem
import com.example.chetunewretrofitproject.model.TodosList
import com.example.chetunewretrofitproject.model.TodosListItem
import com.example.chetunewretrofitproject.model.TvShowList
import com.example.chetunewretrofitproject.model.TvShowListItem
import com.example.chetunewretrofitproject.model.UsersList
import com.example.chetunewretrofitproject.model.UsersListItem
import com.example.chetunewretrofitproject.model.commentsListItem
import com.example.chetunewretrofitproject.retrofit.RetrofitJsonInstance
import com.example.chetunewretrofitproject.retrofit.RetrofitTmdbInstance
import retrofit2.Call
import retrofit2.Response

object MainRepository {
    // post api from the json placeholder
    val jsonPostsList = MutableLiveData<ArrayList<PostsListItem>>()
    fun getPost(): MutableLiveData<ArrayList<PostsListItem>> {
        val call = RetrofitJsonInstance.apiInterface.getPosts()
        call.enqueue(object : retrofit2.Callback<PostsResult> {
            override fun onResponse(call: Call<PostsResult>, response: Response<PostsResult>) {
                if (response.isSuccessful) {
                    val body = response.body()
                    jsonPostsList.value = body!!
                } else {
                    Log.d("ERROR", "onResponce:" + response.message())
                }
            }
            override fun onFailure(call: Call<PostsResult>, t: Throwable) {
                Log.d("ERROR", "onResponce:" + t.message)
            }
        })
        return jsonPostsList

    }

    // photos  api from the json placeholder
    private val jsonPhotosList = MutableLiveData<ArrayList<PhotosListItem>>()
    fun getPhotos():MutableLiveData<ArrayList<PhotosListItem>>{
        val call = RetrofitJsonInstance.apiInterface.getPhotos()
        call.enqueue(object : retrofit2.Callback<PhotosList> {

            override fun onResponse(call: Call<PhotosList>, response: Response<PhotosList>) {
                if (response.isSuccessful){
                    val body = response.body()
                    jsonPhotosList .value = body!!
                }else{
                    Log.d("ERROR", "onResponce:" + response.message())
                }
            }
            override fun onFailure(call: Call<PhotosList>, t: Throwable) {
                Log.d("ERROR", "onResponce:" + t.message)
            }

        })
        return jsonPhotosList
    }


    // comment  pi from the json placeholder
    private val jsonCommentList = MutableLiveData<ArrayList<commentsListItem>>()
    fun getComments():MutableLiveData<ArrayList<commentsListItem>>{
        val call = RetrofitJsonInstance.apiInterface.getComment()
        call.enqueue(object : retrofit2.Callback<CommentsList> {

            override fun onResponse(call: Call<CommentsList>, response: Response<CommentsList>) {
                if (response.isSuccessful){
                    val body = response.body()
                    jsonCommentList .value = body!!
                }else{
                    Log.d("ERROR", "onResponce:" + response.message())
                }
            }
            override fun onFailure(call: Call<CommentsList>, t: Throwable) {
                Log.d("ERROR", "onResponce:" + t.message)
            }

        })
        return jsonCommentList
    }


    // albums  pi from the json placeholder
    private val jsonAlbumsList = MutableLiveData<ArrayList<AlbumListItem>>()
    fun getAlbums():MutableLiveData<ArrayList<AlbumListItem>>{
        val call = RetrofitJsonInstance.apiInterface.getAlbums()
        call.enqueue(object : retrofit2.Callback<AlbumList> {

            override fun onResponse(call: Call<AlbumList>, response: Response<AlbumList>) {
                if (response.isSuccessful){
                    val body = response.body()
                    jsonAlbumsList .value = body!!
                }else{
                    Log.d("ERROR", "onResponce:" + response.message())
                }
            }
            override fun onFailure(call: Call<AlbumList>, t: Throwable) {
                Log.d("ERROR", "onResponce:" + t.message)
            }

        })
        return jsonAlbumsList
    }


    // todos  pi from the json placeholder
    private val jsonTodosList = MutableLiveData<ArrayList<TodosListItem>>()
    fun getTodos():MutableLiveData<ArrayList<TodosListItem>>{
        val call = RetrofitJsonInstance.apiInterface.getTodos()
        call.enqueue(object : retrofit2.Callback<TodosList> {

            override fun onResponse(call: Call<TodosList>, response: Response<TodosList>) {
                if (response.isSuccessful){
                    val body = response.body()
                    jsonTodosList .value = body!!
                }else{
                    Log.d("ERROR", "onResponce:" + response.message())
                }
            }
            override fun onFailure(call: Call<TodosList>, t: Throwable) {
                Log.d("ERROR", "onResponce:" + t.message)
            }

        })
        return jsonTodosList
    }


    // users  pi from the json placeholder
    private val jsonUsersList = MutableLiveData<ArrayList<UsersListItem>>()
    fun getUsers():MutableLiveData<ArrayList<UsersListItem>>{
        val call = RetrofitJsonInstance.apiInterface.getUsers()
        call.enqueue(object : retrofit2.Callback<UsersList> {

            override fun onResponse(call: Call<UsersList>, response: Response<UsersList>) {
                if (response.isSuccessful){
                    val body = response.body()
                    jsonUsersList .value = body!!
                }else{
                    Log.d("ERROR", "onResponce:" + response.message())
                }
            }
            override fun onFailure(call: Call<UsersList>, t: Throwable) {
                Log.d("ERROR", "onResponce:" + t.message)
            }

        })
        return jsonUsersList
    }

    // movies  pi from the tmdb
    private val moviesList = MutableLiveData<ArrayList<MoviesListItem>>()
    fun getMovies(key: String):MutableLiveData<ArrayList<MoviesListItem>>{
        val call = RetrofitTmdbInstance.apiInterface.getMovies(key)
        call.enqueue(object : retrofit2.Callback<MoviesList> {

            override fun onFailure(call: Call<MoviesList>, t: Throwable) {
                Log.d("ERROR", "onResponce:" + t.message)
            }
            override fun onResponse(call: Call<MoviesList>, response: Response<MoviesList>) {
                if (response.isSuccessful){
                    val body = response.body()
                    moviesList .value = body!!.resultsMovies
                }else{
                    Log.d("ERROR", "onResponce:" + response.message())
                }
            }

        })
        return moviesList
    }


    // tvshows  pi from the tmdb
    private val TVShowsList = MutableLiveData<ArrayList<TvShowListItem>>()
    fun getTVShows(key: String):MutableLiveData<ArrayList<TvShowListItem>>{
        val call = RetrofitTmdbInstance.apiInterface.getTVShows(key)
        call.enqueue(object : retrofit2.Callback<TvShowList> {

            override fun onFailure(call: Call<TvShowList>, t: Throwable) {
                Log.d("ERROR", "onResponce:" + t.message)
            }
            override fun onResponse(call: Call<TvShowList>, response: Response<TvShowList>) {
                if (response.isSuccessful){
                    val body = response.body()
                    TVShowsList .value = body!!.results
                }else{
                    Log.d("ERROR", "onResponce:" + response.message())
                }
            }

        })
        return TVShowsList
    }

    // popular person  pi from the tmdb
    private val personList = MutableLiveData<ArrayList<PopularPersonListItem>>()
    fun getPopularPerson(key: String):MutableLiveData<ArrayList<PopularPersonListItem>>{
        val call = RetrofitTmdbInstance.apiInterface.getPerson(key)
        call.enqueue(object : retrofit2.Callback<ListPopularPerson> {

            override fun onFailure(call: Call<ListPopularPerson>, t: Throwable) {
                Log.d("ERROR", "onResponce:" + t.message)
            }
            override fun onResponse(call: Call<ListPopularPerson>, response: Response<ListPopularPerson>) {
                if (response.isSuccessful){
                    val body = response.body()
                    personList .value = body!!.results
                }else{
                    Log.d("ERROR", "onResponce:" + response.message())
                }
            }

        })
        return personList
    }


}

