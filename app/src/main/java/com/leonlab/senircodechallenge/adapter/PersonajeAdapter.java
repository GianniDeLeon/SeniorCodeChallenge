package com.leonlab.senircodechallenge.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.leonlab.senircodechallenge.R;
import com.leonlab.senircodechallenge.model.Personaje;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PersonajeAdapter extends RecyclerView.Adapter<PersonajeAdapter.ViewHolder> {

    private ArrayList<Personaje> localDataSet;



    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewNombre;
        private final TextView textViewApodo;
        private final ImageView imageViewFoto;
        private final ImageView imageViewFavorito;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textViewNombre = (TextView) view.findViewById(R.id.textViewNombre);
            textViewApodo = (TextView) view.findViewById(R.id.textViewApodo);
            imageViewFoto = (ImageView) view.findViewById(R.id.imageViewFoto);
            imageViewFavorito = (ImageView) view.findViewById(R.id.imageViewFavorito);
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public PersonajeAdapter(ArrayList<Personaje> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.container_personaje, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textViewNombre.setText(localDataSet.get(position).getName());
        viewHolder.textViewApodo.setText(localDataSet.get(position).getNickname());
        Picasso.get().load(localDataSet.get(position).getImg()).into(viewHolder.imageViewFoto);
        int imageResource = (localDataSet.get(position).isFavorito())?R.drawable.ic_baseline_favorite:R.drawable.ic_baseline_favorite_border;
        viewHolder.imageViewFavorito.setImageResource(imageResource);
        viewHolder.imageViewFavorito.setOnClickListener(v -> {
            localDataSet.get(position).setFavorito(!localDataSet.get(position).isFavorito());
            int imageResource2 = (localDataSet.get(position).isFavorito())?R.drawable.ic_baseline_favorite_border:R.drawable.ic_baseline_favorite;
            viewHolder.imageViewFavorito.setImageResource(imageResource2);
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
