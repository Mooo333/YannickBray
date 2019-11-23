package ca.qc.cstj.yannickbray.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import ca.qc.cstj.yannickbray.R
import ca.qc.cstj.yannickbray.adapters.CommentaireRecyclerViewAdapter
import ca.qc.cstj.yannickbray.models.Commentaire
import ca.qc.cstj.yannickbray.models.Livre
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.fuel.json.responseJson
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.fragment_detail_livre.*
import kotlinx.serialization.json.Json
import java.nio.charset.Charset

class DetailLivreFragment : Fragment() {

    private val args:DetailLivreFragmentArgs by navArgs()
    private var commentaire = listOf<Commentaire>()

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

        commentaire = args.Livre.commentaires.sortedWith(compareByDescending { it.dateCommentaire })

        txvPrix.text = (args.Livre.prix + "$")
        txvAuteur.text = (args.Livre.auteur)
        txvCategorie.text = (args.Livre.categorie)
        txvISBN.text = ("ISBN: " + args.Livre.ISBN)

        btnAjouterCom.setOnClickListener {
            postComment()
        }

        rcvCommentaire.layoutManager = LinearLayoutManager(this.context)
        rcvCommentaire.adapter = CommentaireRecyclerViewAdapter(commentaire)

        loadCommentaires()
    }

        private fun loadCommentaires(){

            rcvCommentaire.adapter = CommentaireRecyclerViewAdapter(commentaire)
            rcvCommentaire.adapter!!.notifyDataSetChanged()
        }

    private fun postComment(){
        var stringUrlAPI = args.Livre.href + "/commentaires"

        var author = inNom.text.toString()
        var message = inCom.text.toString()
        var nbEtoile = rtbAjoutRate.rating.toString()

        var comment = Commentaire(author,null,message,nbEtoile)

        stringUrlAPI.httpPost()
            .header("Content-Type" to "application/json")
            .body(Json.nonstrict.stringify(Commentaire.serializer(),comment), Charset.forName("UTF-8"))
            .responseJson(){ request,response,result ->
                when(result) {
                    is Result.Success -> {
                        val theBook = Json.nonstrict.parse(Livre.serializer(), result.value.content)
                        commentaire = theBook.commentaires.sortedWith(compareByDescending { it.dateCommentaire })

                        loadCommentaires()
                    }
                }
            }
    }



    }




