package ca.qc.cstj.yannickbray.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import ca.qc.cstj.yannickbray.R
import ca.qc.cstj.yannickbray.Services
import ca.qc.cstj.yannickbray.adapters.LivreRecyclerViewAdapter
import ca.qc.cstj.yannickbray.models.Livre
import ca.qc.cstj.yannickbray.toast
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.json.responseJson
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.fragment_nav_livres.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.list

class LivreFragment : Fragment() {
    /*
        private lateinit var homeViewModel: HomeViewModel
    */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_nav_livres, container, false)
        return root
    }

    private var livres = listOf<Livre>()
    private val args:LivreFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        rcvLivres.layoutManager = LinearLayoutManager(this.context)
        rcvLivres.adapter = LivreRecyclerViewAdapter(livres)

        (activity as AppCompatActivity).supportActionBar?.title = args.categorie.categorie

        loadLivres()
    }

    private fun loadLivres() {
        var stringUrlAPI = Services.LIVRE_API_URL + "?categorie=" + args.categorie.categorie
        stringUrlAPI.httpGet().responseJson{_,_,result ->
            when(result) {
                is Result.Success -> {
                    livres = Json.nonstrict.parse(Livre.serializer().list, result.value.obj()["results"].toString())
                    rcvLivres.adapter = LivreRecyclerViewAdapter(livres)
                    rcvLivres.adapter!!.notifyDataSetChanged()
                }
                is Result.Failure -> {
                    toast(result.toString())
                }
            }
        }
    }

    companion object {
        fun newIntent(context: Context, username: String) : Intent {
            val intent = Intent(context, LivreFragment::class.java)
            return intent
        }
    }



}