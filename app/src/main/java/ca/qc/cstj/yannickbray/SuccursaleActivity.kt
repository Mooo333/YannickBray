package ca.qc.cstj.yannickbray

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ca.qc.cstj.yannickbray.models.Succursale
import kotlinx.android.synthetic.main.fragment_home.*

class SuccursaleActivity : AppCompatActivity() {

    private var succursales = listOf<Succursale>()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)

        rcvSuccursale.layoutManager = LinearLayoutManager(this)
     //   loadSuccursales()

    }
/*
    private fun loadSuccursales() {
        Services.SUCCURSALES_API_URL.httpGet().responseJson{


        }

    }
*/


}