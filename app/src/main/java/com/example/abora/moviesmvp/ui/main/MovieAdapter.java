package com.example.abora.moviesmvp.ui.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.abora.moviesmvp.R;
import com.example.abora.moviesmvp.data.model.Movie;
import com.example.abora.moviesmvp.util.Constant;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.movieHolder> {

    List<Movie> list;
    Context context;

    public MovieAdapter(List<Movie> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieAdapter.movieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row, parent, false);
        return new movieHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.movieHolder holder, int position) {
        Movie movie = list.get(position);
        holder.txrow.setText(movie.getTitle());
        Picasso.get()
                .load(Constant.BASE_IMAGE_URL + movie.getPosterPath())
                .error(R.drawable.img)
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.ivrow);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class movieHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivrow)
        ImageView ivrow;
        @BindView(R.id.txrow)
        TextView txrow;
        @BindView(R.id.root)
        LinearLayout root;

        movieHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
