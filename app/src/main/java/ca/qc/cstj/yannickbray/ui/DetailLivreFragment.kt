package ca.qc.cstj.yannickbray.ui


import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs

import ca.qc.cstj.yannickbray.R
import ca.qc.cstj.yannickbray.Services
import ca.qc.cstj.yannickbray.adapters.CommentaireRecyclerViewAdapter
import ca.qc.cstj.yannickbray.adapters.SuccursaleRecyclerViewAdapter
import ca.qc.cstj.yannickbray.models.Categorie
import ca.qc.cstj.yannickbray.models.Livre
import ca.qc.cstj.yannickbray.models.Succursale
import ca.qc.cstj.yannickbray.ui.DetailLivreFragmentArgs
import ca.qc.cstj.yannickbray.toast
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.json.responseJson
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.fragment_detail_livre.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.list

class DetailLivreFragment : Fragment() {

    private val args:DetailLivreFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_livre, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = args.Livre.titre

        txvPrix.text = (args.Livre.prix + "$")
        txvAuteur.text = (args.Livre.auteur)
        txvCategorie.text = (args.Livre.categorie)
        txvISBN.text = ("ISBN: " + args.Livre.ISBN)

        loadCommentaires()
    }

        private fun loadCommentaires(){
            val commentaire = args.Livre.commentaires

            rcvCommentaire.adapter = CommentaireRecyclerViewAdapter(commentaire)
            rcvCommentaire.adapter!!.notifyDataSetChanged()
        }



    }




