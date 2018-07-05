package com.example.abora.moviesmvp.services.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.example.abora.moviesmvp.callback.OnMovieRecevedListner;
import com.example.abora.moviesmvp.data.model.MovieResponse;
import com.example.abora.moviesmvp.util.Constant;

public class Networking {
   public static void getAllMovie(final OnMovieRecevedListner listner){
        AndroidNetworking.get(Constant.BASE_URL + Constant.POPULAR_URL)
               .addQueryParameter(Constant.API_KEY, Constant.API_KEY_VALUE)
               .addQueryParameter(Constant.PAGE_KEY, "1")
               .build().getAsObject(MovieResponse.class, new ParsedRequestListener<MovieResponse>() {

            @Override
            public void onResponse(MovieResponse response) {
                listner.onSuccess(response.getMovies());
            }

            @Override
            public void onError(ANError anError) {
                listner.onError(anError.getErrorDetail());
            }
        });
   }
}
