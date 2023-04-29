package com.example.pertemuan5

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pertemuan5.databinding.CardviewLayoutBinding

class CardViewAdapter (private val context : Context, private val listStudent : ArrayList<MyContact>) :
    RecyclerView.Adapter<CardViewAdapter.ViewHolder>() {
    class ViewHolder(val binding: CardviewLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = CardviewLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listStudent.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.txtNama.text = listStudent[position].nama
        Glide.with(holder.itemView.context).load(listStudent[position].foto).into(holder.binding.images)
        holder.binding.cardView.setOnClickListener{
            val inten = Intent(context,DetailActivity::class.java)
            inten.putExtra("nim",listStudent[position].nim)
            inten.putExtra("nama",listStudent[position].nama)
            inten.putExtra("telepon",listStudent[position].nomorTelepon)
            inten.putExtra("foto",listStudent[position].foto)
            context.startActivity(inten)
        }
//        holder.binding.tvNim.text = listStudent[position].nim
//        holder.binding.tvNama.text = listStudent[position].nama
//        holder.binding.tvNomorTelepon.text = listStudent[position].nomorTelepon
    }
}