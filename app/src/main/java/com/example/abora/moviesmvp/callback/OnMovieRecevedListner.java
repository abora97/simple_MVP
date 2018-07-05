package com.example.abora.moviesmvp.callback;

import com.example.abora.moviesmvp.data.model.Movie;

import java.util.List;

public interface OnMovieRecevedListner {
    void onSuccess(List<Movie>list);
    void onError(String msg);
}
