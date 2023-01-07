package com.example.melobit;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.melobit.models.SongsListResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class RequestManager {

    Context context;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api-beta.melobit.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    interface CallService {
        @GET("song/new/0/11")
        Call<SongsListResponse> getNewSongs();
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
                listener.didFetch(response.body(),response.message());
            }

            @Override
            public void onFailure(@NonNull Call<SongsListResponse> call, @NonNull Throwable t) {
                listener.didError(t.getMessage());
            }
        });
    }
}

interface SongsListResponseListener {
    void didFetch(SongsListResponse response , String status);
    void didError(String status);
}
