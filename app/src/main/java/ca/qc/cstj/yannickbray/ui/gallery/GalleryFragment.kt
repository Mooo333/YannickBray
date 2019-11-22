package ca.qc.cstj.yannickbray.ui.gallery

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ca.qc.cstj.yannickbray.R
import ca.qc.cstj.yannickbray.Services
import ca.qc.cstj.yannickbray.adapters.CategorieRecyclerViewAdapter
import ca.qc.cstj.yannickbray.models.Categorie
import ca.qc.cstj.yannickbray.toast
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.json.responseJson
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.fragment_gallery.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.list

class GalleryFragment : Fragment() {
    /*
        private lateinit var homeViewModel: HomeViewModel
    */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        return root
    }

    private var categories = listOf<Categorie>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        rcvCategorie.layoutManager = LinearLayoutManager(this.context)
        rcvCategorie.adapter = CategorieRecyclerViewAdapter(categories)
        loadCategories()
    }

    private fun loadCategories() {

        Services.CATEGORIES_API_URL.httpGet().responseJson{_,_,result ->
            when(result) {
                is Result.Success -> {
                    categories = Json.nonstrict.parse(Categorie.serializer().list, result.value.content).distinct()
                    rcvCategorie.adapter = CategorieRecyclerViewAdapter(categories)
                    rcvCategorie.adapter!!.notifyDataSetChanged()
                }
                is Result.Failure -> {
                    toast(result.toString())
                }
            }
        }
    }

    companion object {
        fun newIntent(context: Context, username: String) : Intent {
            val intent = Intent(context, GalleryFragment::class.java)
            return intent
        }
    }



}