package com.example.melobit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.melobit.R;
import com.example.melobit.models.Artist;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SingerAdapter extends RecyclerView.Adapter<SingerAdapter.ArtistViewHolder> {

    Context context;
    List<Artist> artists;

    public SingerAdapter(Context context, List<Artist> artists) {
        this.context = context;
        this.artists = artists;
    }

    public static class ArtistViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewCover;
        TextView textViewName;

        public ArtistViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewCover = itemView.findViewById(R.id.image_view_cover);
            textViewName = itemView.findViewById(R.id.text_view_name);
        }
    }

    @NonNull
    @Override
    public ArtistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ArtistViewHolder(LayoutInflater.from(context).inflate(R.layout.singer_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ArtistViewHolder holder, int position) {
        holder.textViewName.setText(artists.get(position).getFullName());
        Picasso.get().load(artists.get(position).getImage().getCover().getUrl())
                .into(holder.imageViewCover);
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }
}