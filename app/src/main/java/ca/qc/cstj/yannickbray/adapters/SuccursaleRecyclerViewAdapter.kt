package ca.qc.cstj.yannickbray.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import ca.qc.cstj.yannickbray.R
import ca.qc.cstj.yannickbray.models.Succursale
import ca.qc.cstj.yannickbray.toast
import ca.qc.cstj.yannickbray.ui.home.HomeFragment
import ca.qc.cstj.yannickbray.ui.home.HomeFragmentDirections
import ca.qc.cstj.yannickbray.ui.succursale.DetailSuccursaleFragment
import kotlinx.android.synthetic.main.item_ville_succursales.view.*

class SuccursaleRecyclerViewAdapter(private val values: List<Succursale>) : RecyclerView.Adapter<SuccursaleRecyclerViewAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ville_succursales, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = values.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]

        with(holder) {
            view.tag = item
            view.setOnClickListener {
                val succursale = it.tag as Succursale
                val direction = HomeFragmentDirections.actionNavHomeToDetailSuccursaleFragment(item)
                it.findNavController().navigate(direction)
            }
            bind(item)
        }
    }

    inner class ViewHolder(val view: View) :RecyclerView.ViewHolder(view) {
        private val txvVille: TextView = view.txvVille!!

        fun bind(succursale: Succursale){
            txvVille.text = succursale.ville
        }
    }

}