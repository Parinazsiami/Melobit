package com.example.melobit;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.melobit.models.ArtistResponse;
import com.example.melobit.models.Song;
import com.example.melobit.models.SongsListResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class RequestManager {

    Context context;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api-beta.melobit.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    interface CallService {
        @GET("song/new/0/11")
        Call<SongsListResponse> getNewSongs();

        @GET("artist/trending/0/4")
        Call<ArtistResponse> getTopSingers();

        @GET("song/top/day/0/100")
        Call<SongsListResponse> getHitsToday();

        @GET("song/top/week/0/100")
        Call<SongsListResponse> getHitsThisWeek();

        @GET("song/{id}")
        Call<Song> getSong(@Path("id") String songId);
    }

    CallService callService = retrofit.create(CallService.class);

    public RequestManager(Context context) {
        this.context = context;
    }

    public void getNewSongs(SongsListResponseListener listener) {
        Call<SongsListResponse> call = callService.getNewSongs();
        call.enqueue(new Callback<SongsListResponse>() {
            @Override
            public void onResponse(@NonNull Call<SongsListResponse> call, @NonNull Response<SongsListResponse> response) {
                if (!response.isSuccessful()) {
                    listener.didError(response.message());
                    return;
                }
                listener.didFetch(response.body(), response.message());
            }

            @Override
            public void onFailure(@NonNull Call<SongsListResponse> call, @NonNull Throwable t) {
                listener.didError(t.getMessage());
            }
        });
    }

    public void getTopSingers(ArtistsRequestListener listener) {
        Call<ArtistResponse> topSingers = callService.getTopSingers();
        topSingers.enqueue(new Callback<ArtistResponse>() {
            @Override
            public void onResponse(@NonNull Call<ArtistResponse> call, @NonNull Response<ArtistResponse> response) {
                if (!response.isSuccessful()) {
                    listener.didError(response.message());
                    return;
                }
                listener.didFetch(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<ArtistResponse> call, @NonNull Throwable t) {
                listener.didError(t.getMessage());
            }
        });
    }

    public void getHitsToday(SongsListResponseListener listener) {
        Call<SongsListResponse> todayHits = callService.getHitsToday();
        todayHits.enqueue(new Callback<SongsListResponse>() {
            @Override
            public void onResponse(@NonNull Call<SongsListResponse> call, @NonNull Response<SongsListResponse> response) {
                if (!response.isSuccessful()) {
                    listener.didError(response.message());
                    return;
                }
                listener.didFetch(response.body(), response.message());
            }

            @Override
            public void onFailure(@NonNull Call<SongsListResponse> call, @NonNull Throwable t) {
                listener.didError(t.getMessage());
            }
        });
    }

    public void getHitsThisWeek(SongsListResponseListener listener) {
        Call<SongsListResponse> thisWeekHits = callService.getHitsThisWeek();
        thisWeekHits.enqueue(new Callback<SongsListResponse>() {
            @Override
            public void onResponse(@NonNull Call<SongsListResponse> call, @NonNull Response<SongsListResponse> response) {
                if (!response.isSuccessful()) {
                    listener.didError(response.message());
                    return;
                }
                listener.didFetch(response.body(), response.message());
            }

            @Override
            public void onFailure(@NonNull Call<SongsListResponse> call, @NonNull Throwable t) {
                listener.didError(t.getMessage());
            }
        });
    }
    public void getSong(SongListener listener, String id) {
        Call<Song> song = callService.getSong(id);
        song.enqueue(new Callback<Song>() {
            @Override
            public void onResponse(@NonNull Call<Song> call, @NonNull Response<Song> response) {
                if (!response.isSuccessful()) {
                    listener.didError(response.message());
                    return;
                }
                listener.didFetch(response.body(),response.message());
            }

            @Override
            public void onFailure(@NonNull Call<Song> call, @NonNull Throwable t) {
                listener.didError(t.getMessage());
            }
        });
    }
}

interface SongsListResponseListener {
    void didFetch(SongsListResponse response, String status);

    void didError(String status);
}

interface ArtistsRequestListener {
    void didFetch(ArtistResponse response);

    void didError(String errorMessage);
}
interface SongListener {
    void didFetch(Song response, String status);

    void didError(String status);
}
