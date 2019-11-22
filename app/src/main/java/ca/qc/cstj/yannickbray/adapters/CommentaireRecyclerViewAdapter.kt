package ca.qc.cstj.yannickbray.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import ca.qc.cstj.yannickbray.R
import ca.qc.cstj.yannickbray.models.Commentaire
import ca.qc.cstj.yannickbray.toast
import ca.qc.cstj.yannickbray.ui.home.HomeFragment
import ca.qc.cstj.yannickbray.ui.home.HomeFragmentDirections
import ca.qc.cstj.yannickbray.ui.DetailLivreFragment
import kotlinx.android.synthetic.main.item_commentaires.view.*

class CommentaireRecyclerViewAdapter(private val values: List<Commentaire>) : RecyclerView.Adapter<CommentaireRecyclerViewAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_commentaires, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = values.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]

        with(holder) {
            view.tag = item

            bind(item)
        }
    }

    inner class ViewHolder(val view: View) :RecyclerView.ViewHolder(view) {
        private val txvNom: TextView = view.txvNom!!
        private val txvCommentaire: TextView = view.txvCommentaire!!
        private val txvDate: TextView = view.txvDate!!
        private val rtbEval: RatingBar = view.rtbEval!!

        fun bind(commentaire: Commentaire){
            txvNom.text = commentaire.nom
            txvCommentaire.text = commentaire.message
            txvDate.text = commentaire.dateCommentaire
            rtbEval.rating = commentaire.etoile.toFloat()



        }
    }

}