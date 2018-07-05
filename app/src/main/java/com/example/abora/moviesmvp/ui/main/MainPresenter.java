package com.example.abora.moviesmvp.ui.main;


import com.example.abora.moviesmvp.callback.OnMovieRecevedListner;
import com.example.abora.moviesmvp.data.model.Movie;
import com.example.abora.moviesmvp.services.api.Networking;

import java.util.List;

public class MainPresenter implements MainView.presenter {
    MainView.viewMain viewMain;

    public MainPresenter(MainView.viewMain viewMain) {
        this.viewMain = viewMain;
    }

    public void getMovies() {
        Networking.getAllMovie(new OnMovieRecevedListner() {
            @Override
            public void onSuccess(List<Movie> list) {
                viewMain.showData(list);
            }

            @Override
            public void onError(String msg) {
                viewMain.showError(msg);
            }
        });
    }
}
