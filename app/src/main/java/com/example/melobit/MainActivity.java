package com.example.melobit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.melobit.models.SongsListResponse;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.text_view);
        RequestManager manager = new RequestManager(this);
        SongsListResponseListener listener = new SongsListResponseListener() {
            @Override
            public void didFetch(SongsListResponse response, String status) {
                textView.setText(response.getResults().get(0).getTitle());
            }

            @Override
            public void didError(String status) {
                textView.setText(status);
            }
        };
        manager.getNewSongs(listener);
    }
}