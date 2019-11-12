package ca.qc.cstj.yannickbray.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import ca.qc.cstj.yannickbray.R
import ca.qc.cstj.yannickbray.Services
import ca.qc.cstj.yannickbray.SuccursaleActivity
import ca.qc.cstj.yannickbray.adapters.SuccursaleRecyclerViewAdapter
import ca.qc.cstj.yannickbray.models.Succursale
import ca.qc.cstj.yannickbray.toast
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.json.responseJson
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.list

class HomeFragment : Fragment() {
/*
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }

*/
/*
    private var succursales = listOf<Succursale>()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)

        rcvSuccursale.layoutManager = LinearLayoutManager(this)
        loadSuccursales()
    }

    private fun loadSuccursales() {
        Services.SUCCURSALES_API_URL.httpGet().responseJson{ _, _, result ->
            when(result) {
                is Result.Success -> {
                    succursales = Json.nonstrict.parse(Succursale.serializer().list, result.value.content)
                    rcvSuccursale.adapter = SuccursaleRecyclerViewAdapter(succursales)
                    rcvSuccursale.adapter!!.notifyDataSetChanged()
                }
                is Result.Failure -> {
                    toast(result.toString())
                }
            }
        }
    }

    companion object {
        fun newIntent(context: Context, username: String) : Intent {
            val intent = Intent(context, HomeFragment::class.java)
            return intent
        }
    }


 */
}