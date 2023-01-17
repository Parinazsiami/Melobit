package com.example.melobit;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.melobit.models.Song;
import com.squareup.picasso.Picasso;

public class SongActivity extends AppCompatActivity {

    private TextView textViewError,textViewSongName,textViewSinger,textViewDownloadCount,textViewReleaseDate,textViewLyrics;
    private ImageView imageViewCover;

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
            }
            @Override
            public void didError(String status) {
                textViewError.setText(status);
            }
        };
        manager.getSong(listener, id);
    }
}