package com.example.chetunewretrofitproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chetunewretrofitproject.model.AlbumListItem
import com.example.chetunewretrofitproject.model.MoviesListItem
import com.example.chetunewretrofitproject.model.PhotosListItem
import com.example.chetunewretrofitproject.model.PopularPersonListItem
import com.example.chetunewretrofitproject.model.PostsListItem
import com.example.chetunewretrofitproject.model.TodosListItem
import com.example.chetunewretrofitproject.model.TvShowListItem
import com.example.chetunewretrofitproject.model.UsersListItem
import com.example.chetunewretrofitproject.model.commentsListItem
import com.example.chetunewretrofitproject.repository.MainRepository

class MainViewModel : ViewModel() {
    // post data
    private var postsList = MutableLiveData<ArrayList<PostsListItem>>()
    fun getPosts(): LiveData<ArrayList<PostsListItem>> {
        postsList = MainRepository.getPost()
        return postsList
    }
    // photos data
    private var photosList = MutableLiveData<ArrayList<PhotosListItem>>()
    fun getPhotos():LiveData<ArrayList<PhotosListItem>>{
        photosList = MainRepository.getPhotos()
        return photosList
    }


    // comments data
    private var commentsList = MutableLiveData<ArrayList<commentsListItem>>()
    fun getComments():LiveData<ArrayList<commentsListItem>>{
        commentsList = MainRepository.getComments()
        return commentsList
    }


    // Albums data
    private var albumsList = MutableLiveData<ArrayList<AlbumListItem>>()
    fun getAlbums():LiveData<ArrayList<AlbumListItem>>{
        albumsList = MainRepository.getAlbums()
        return albumsList
    }
    // Todos data
    private var todosList = MutableLiveData<ArrayList<TodosListItem>>()
    fun getTodos():LiveData<ArrayList<TodosListItem>>{
        todosList = MainRepository.getTodos()
        return todosList
    }

    // Users data
    private var UsersList = MutableLiveData<ArrayList<UsersListItem>>()
    fun getUsers():LiveData<ArrayList<UsersListItem>>{
        UsersList = MainRepository.getUsers()
        return UsersList
    }

    // movies data
    private var moviesList = MutableLiveData<ArrayList<MoviesListItem>>()
    fun getMovies(key :String):LiveData<ArrayList<MoviesListItem>>{
        moviesList = MainRepository.getMovies(key)
        return moviesList
    }
    // tvshows data
    private var tvShowsList = MutableLiveData<ArrayList<TvShowListItem>>()
    fun getTVShows(key :String):LiveData<ArrayList<TvShowListItem>>{
        tvShowsList = MainRepository.getTVShows(key)
        return tvShowsList
    }
    // popular person data
    private var personList = MutableLiveData<ArrayList<PopularPersonListItem>>()
    fun getPopularPerson(key :String):LiveData<ArrayList<PopularPersonListItem>>{
        personList = MainRepository.getPopularPerson(key)
        return personList
    }
}
