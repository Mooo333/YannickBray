package ca.qc.cstj.yannickbray

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ca.qc.cstj.yannickbray.adapters.SuccursaleRecyclerViewAdapter
import ca.qc.cstj.yannickbray.models.Succursale
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.json.responseJson
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.list

class SuccursaleActivity : AppCompatActivity() {

    private var succursales = listOf<Succursale>()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)

        rcvSuccursale.layoutManager = LinearLayoutManager(this)
        loadSuccursales()
    }

    private fun loadSuccursales() {
        Services.SUCCURSALES_API_URL.httpGet().responseJson{_, _, result ->
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
            val intent = Intent(context, SuccursaleActivity::class.java)
            return intent
        }
    }
}