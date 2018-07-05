package com.example.abora.moviesmvp.ui.main;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.Toast;

import com.example.abora.moviesmvp.R;
import com.example.abora.moviesmvp.data.model.Movie;
import com.example.abora.moviesmvp.ui.base.BaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainView.viewMain {



    @BindView(R.id.rec_movie)
    RecyclerView recMovie;
    @BindView(R.id.swpipe_layout)
    SwipeRefreshLayout swpipeLayout;
    @BindView(R.id.bu_Back)
    Button buBack;
    @BindView(R.id.bu_home)
    Button buHome;
    @BindView(R.id.bu_next)
    Button buNext;

    private MovieAdapter adapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter =new MainPresenter(this);
        mainPresenter.getMovies();
    }

    @Override
    public void showData(List<Movie> list) {
        mLayoutManager=new GridLayoutManager(this,3);
        adapter = new MovieAdapter(list, MainActivity.this);
        recMovie.setLayoutManager(mLayoutManager);
        recMovie.setAdapter(adapter);

    }

    @Override
    public void showError(String masg) {
        Toast.makeText(this, masg, Toast.LENGTH_SHORT).show();
    }
}
