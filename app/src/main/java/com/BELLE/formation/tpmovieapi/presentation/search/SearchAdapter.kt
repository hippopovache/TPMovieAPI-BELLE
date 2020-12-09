package com.BELLE.formation.tpmovieapi.presentation.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.BELLE.formation.tpmovieapi.R
import com.BELLE.formation.tpmovieapi.domain.model.MovieShort
import com.squareup.picasso.Picasso

class SearchAdapter(context: Context) : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    private val movies: ArrayList<MovieShort> = ArrayList()

    private val inflater = LayoutInflater.from(context)

    override fun getItemCount() = movies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_movie, parent, false))
    }

    //met les valeurs a telle position dans le viewholder (pour la liste de movies) c'est la qu'on va binder les datas
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val title: TextView = view.findViewById(R.id.title)
        private val poster: ImageView = view.findViewById(R.id.poster)

        init {
            view.setOnClickListener {
                //TODO
            }
        }


        fun bind(movieShort: MovieShort) {
            title.text = movieShort.title

            if (movieShort.poster.isNotBlank() && movieShort.poster.isNotEmpty()) {
                Picasso.get().load(movieShort.poster).into(poster)
            } else { //si il n'y a pas de else le imageView va garder la dernière image donc il faut set sur null
                poster.setImageDrawable(null)
            }
        }

    }
}