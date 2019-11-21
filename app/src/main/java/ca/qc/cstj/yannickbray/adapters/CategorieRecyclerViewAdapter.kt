package ca.qc.cstj.yannickbray.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import ca.qc.cstj.yannickbray.R
import ca.qc.cstj.yannickbray.models.Categorie
import ca.qc.cstj.yannickbray.toast
import ca.qc.cstj.yannickbray.ui.gallery.GalleryFragmentDirections
import kotlinx.android.synthetic.main.item_categorie.view.*

class CategorieRecyclerViewAdapter(private val values: List<Categorie>) : RecyclerView.Adapter<CategorieRecyclerViewAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_categorie, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = values.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]

        with(holder) {
            view.tag = item
            view.setOnClickListener {
                val cat = it.tag as Categorie
                val direction = GalleryFragmentDirections.actionNavGalleryToNavLivres(item)
                it.findNavController().navigate(direction)
            }
            bind(item)
        }
    }

    inner class ViewHolder(val view: View) :RecyclerView.ViewHolder(view) {
        private val txvNom: TextView = view.txvNom!!

        fun bind(cat: Categorie){
            txvNom.text = cat.categorie
        }
    }

}