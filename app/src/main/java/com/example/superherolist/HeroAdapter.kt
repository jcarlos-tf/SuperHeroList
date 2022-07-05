package com.example.superherolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.superherolist.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class HeroAdapter(val superhero:List<SuperHero>):RecyclerView.Adapter<HeroAdapter.HeroHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HeroHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false))
    }

    override fun getItemCount(): Int = superhero.size

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        holder.render(superhero[position])
    }

    class HeroHolder(val view: View):RecyclerView.ViewHolder(view) {
        val binding = ItemSuperheroBinding.bind(view)

        fun render(superhero: SuperHero){
            binding.tvRealName.text = superhero.realName
            binding.tvSuperHeroName.text = superhero.superHeroName
            binding.tvPublisher.text = superhero.publisher
            Picasso.get().load(superhero.image).into(binding.ivHero)
            view.setOnClickListener{ Toast.makeText(view.context,"Has seleccionado a ${superhero.superHeroName}", Toast.LENGTH_SHORT).show() }
        }
    }

}