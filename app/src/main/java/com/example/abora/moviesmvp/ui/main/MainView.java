package com.example.abora.moviesmvp.ui.main;

import com.example.abora.moviesmvp.data.model.Movie;

import java.util.List;

public interface MainView {
    interface viewMain{
        void showData(List<Movie> list);
        void showError(String msg);
    }
    interface presenter{}
}
