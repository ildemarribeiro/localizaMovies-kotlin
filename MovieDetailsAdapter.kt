package view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.localizamoviesapp.databinding.ItemFilmeBinding
import model.MovieModel

class MoviesViewHolder(val binding: ItemFilmeBinding) : RecyclerView.ViewHolder(binding.root)


class MovieDetailsAdapter(val callback: (Int) -> Unit) : RecyclerView.Adapter<MoviesViewHolder>() {
    val listMovies: MutableList<MovieModel> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFilmeBinding.inflate(inflater, parent, false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        //val item = listMovies[position]
        val item = listMovies.get(position)
        holder.binding.titulo.text = item.title

        Glide.with(holder.binding.root).load("https://image.tmdb.org/t/p/w500${item.poster_path}")
            .into(holder.binding.poster)
        holder.binding.itemLayout.setOnClickListener {
            callback(item.id)//item.id
        }
    }


    override fun getItemCount(): Int {
        return listMovies.size
    }

    fun addItemList(list: List<MovieModel>) {
        listMovies.addAll(list)
        notifyDataSetChanged()
    }
}

