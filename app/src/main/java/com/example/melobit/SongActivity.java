package com.example.melobit;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SongActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        textView = findViewById(R.id.textView5);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String id = extras.getString("song_id");
            textView.setText(id);
        }
    }
}