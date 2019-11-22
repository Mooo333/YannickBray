package ca.qc.cstj.yannickbray.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import ca.qc.cstj.yannickbray.R
import ca.qc.cstj.yannickbray.models.Livre
import ca.qc.cstj.yannickbray.toast
import ca.qc.cstj.yannickbray.ui.LivreFragmentDirections
import kotlinx.android.synthetic.main.item_livre.view.*

class LivreRecyclerViewAdapter(private val values: List<Livre>) : RecyclerView.Adapter<LivreRecyclerViewAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_livre, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = values.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]

        with(holder) {
            view.tag = item
            view.setOnClickListener {
                val livre = it.tag as Livre
                val direction = LivreFragmentDirections.actionNavLivresToDetailLivre(item)
                it.findNavController().navigate(direction)
            }
            bind(item)
        }
    }

    inner class ViewHolder(val view: View) :RecyclerView.ViewHolder(view) {
        private val txvNom: TextView = view.txvNom!!

        fun bind(book: Livre){
            txvNom.text = book.titre
        }
    }

}