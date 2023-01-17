package com.example.melobit;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.melobit.models.Song;
import com.squareup.picasso.Picasso;

import java.io.IOException;

public class SongActivity extends AppCompatActivity {

    private TextView textViewError, textViewSongName, textViewSinger, textViewDownloadCount, textViewReleaseDate, textViewLyrics;
    private ImageView imageViewCover, imageViewPlay;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        textViewError = findViewById(R.id.textView1);
        textViewSongName = findViewById(R.id.text_view_song_name);
        textViewSinger = findViewById(R.id.text_view_singer_name);
        textViewDownloadCount = findViewById(R.id.textView_download_count);
        textViewReleaseDate = findViewById(R.id.textView_release_date);
        textViewLyrics = findViewById(R.id.textView_lyrics);
        imageViewCover = findViewById(R.id.image_view_song_cover);
        imageViewPlay = findViewById(R.id.btn_play);

        Bundle extras = getIntent().getExtras();
        String id = extras.getString("song_id");
        RequestManager manager = new RequestManager(this);
        SongListener listener = new SongListener() {
            @Override
            public void didFetch(Song response, String status) {
                textViewSongName.setText(response.getTitle());
                textViewSinger.setText(response.getArtists().get(0).getFullName());
                textViewDownloadCount.setText(response.getDownloadCount());
                textViewReleaseDate.setText(response.getReleaseDate().split("T")[0]);
                textViewLyrics.setText(response.getLyrics());
                Picasso.get()
                        .load(response.getImage().getCover().getUrl())
                        .into(imageViewCover);
                playSong(response.getAudio().getMedium().getUrl());
            }

            @Override
            public void didError(String status) {
                textViewError.setText(status);
            }
        };
        manager.getSong(listener, id);

    }

    private void playSong(String url) {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                imageViewPlay.setImageResource(R.drawable.ic_baseline_play_circle_24);
            }
        });
        imageViewPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    imageViewPlay.setImageResource(R.drawable.ic_baseline_play_circle_24);
                } else {
                    mediaPlayer.start();
                    imageViewPlay.setImageResource(R.drawable.ic_baseline_pause_circle_24);
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        mediaPlayer.stop();
        mediaPlayer.release();
        super.onBackPressed();
    }
}