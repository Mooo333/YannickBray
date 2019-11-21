package ca.qc.cstj.yannickbray.ui.succursale


import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs

import ca.qc.cstj.yannickbray.R
import ca.qc.cstj.yannickbray.toast
import kotlinx.android.synthetic.main.fragment_detail_succursale.*

class DetailSuccursaleFragment : Fragment() {

    private val args: DetailSuccursaleFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_succursale, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?){

        super.onViewCreated(view, savedInstanceState)

        txvVilleAppelatif.text = (args.succursale.ville + " : " + args.succursale.appelatif).toUpperCase()
        txvEmplacement.text = (args.succursale.ville + " (" + args.succursale.province + ") ")
        txvAdresse.text = (args.succursale.addresse)
        txvCodePostal.text = (args.succursale.codePostal)

        txvTel.text = ("Téléphone :" + args.succursale.telephone)
        txvFax.text = ("Télécopieur : " + args.succursale.telecopieur)

        //Html.fromHtml(args.succursale.information, 1).toString()

        txvInfo.text =   args.succursale.information



    }

}
