package com.example.melobit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.melobit.adapter.SingerAdapter;
import com.example.melobit.adapter.SongAdapter;
import com.example.melobit.models.ArtistResponse;
import com.example.melobit.models.SongsListResponse;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewNewSongs, recyclerViewTopSinger, recyclerViewWeekHit, recyclerViewTodayHit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textViewError = findViewById(R.id.text_view);
        recyclerViewNewSongs = findViewById(R.id.recycler_view_new_songs);
        recyclerViewTopSinger = findViewById(R.id.recycler_view_top_10_singers);
        recyclerViewWeekHit = findViewById(R.id.recycler_view_week_hit);
        recyclerViewTodayHit = findViewById(R.id.recycler_view_today_hit);

        recyclerViewNewSongs.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewTopSinger.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewWeekHit.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewTodayHit.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        RequestManager manager = new RequestManager(this);

        SongsListResponseListener newSongListener = new SongsListResponseListener() {
            @Override
            public void didFetch(SongsListResponse response, String status) {
                recyclerViewNewSongs.setAdapter(new SongAdapter(MainActivity.this, response.getResults(),
                        new SongAdapter.ClickListener() {
                            @Override
                            public void onSongClick(int position, View v, String id) {
                                Intent intent = new Intent(MainActivity.this, SongActivity.class);
                                intent.putExtra("song_id", id);
                                startActivity(intent);
                            }
                        }));
            }

            @Override
            public void didError(String status) {
                textViewError.setText(status);
            }
        };
        ArtistsRequestListener artistsListener = new ArtistsRequestListener() {
            @Override
            public void didFetch(ArtistResponse response) {
                recyclerViewTopSinger.setAdapter(new SingerAdapter(MainActivity.this, response.getResults()));
            }

            @Override
            public void didError(String errorMessage) {
                textViewError.setText(errorMessage);
            }
        };
        SongsListResponseListener todayHitListener = new SongsListResponseListener() {
            @Override
            public void didFetch(SongsListResponse response, String status) {
                recyclerViewTodayHit.setAdapter(new SongAdapter(MainActivity.this, response.getResults(),
                        new SongAdapter.ClickListener() {
                            @Override
                            public void onSongClick(int position, View v, String id) {
                                Intent intent = new Intent(MainActivity.this, SongActivity.class);
                                intent.putExtra("song_id", id);
                                startActivity(intent);
                            }
                        }));
            }

            @Override
            public void didError(String status) {
                textViewError.setText(status);
            }
        };
        SongsListResponseListener weekHitListener = new SongsListResponseListener() {
            @Override
            public void didFetch(SongsListResponse response, String status) {
                recyclerViewWeekHit.setAdapter(new SongAdapter(MainActivity.this, response.getResults(),
                        new SongAdapter.ClickListener() {
                            @Override
                            public void onSongClick(int position, View v, String id) {
                                Intent intent = new Intent(MainActivity.this, SongActivity.class);
                                intent.putExtra("song_id", id);
                                startActivity(intent);
                            }
                        }));
            }

            @Override
            public void didError(String status) {
                textViewError.setText(status);
            }
        };
        manager.getNewSongs(newSongListener);
        manager.getTopSingers(artistsListener);
        manager.getHitsToday(todayHitListener);
        manager.getHitsThisWeek(weekHitListener);
    }
}