package ca.qc.cstj.yannickbray.ui


import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs

import ca.qc.cstj.yannickbray.R
import ca.qc.cstj.yannickbray.ui.DetailLivreFragmentArgs
import ca.qc.cstj.yannickbray.toast
import kotlinx.android.synthetic.main.fragment_detail_livre.*

class DetailLivreFragment : Fragment() {

    private val args:DetailLivreFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_livre, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?){

        super.onViewCreated(view, savedInstanceState)

        txvPrix.text = (args.Livre.prix)
        txvAuteur.text = (args.Livre.Auteur)
        txvCategorie.text = (args.Livre.categorie.categorie)
        txvISBN.text = (args.Livre.ISBN)





    }

}
