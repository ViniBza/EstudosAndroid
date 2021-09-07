package vinibza.com.listadegames

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import vinibza.com.listadegames.model.AdapterGame
import vinibza.com.listadegames.model.Game

class MainActivity : AppCompatActivity() {

    lateinit var gameAdapter: AdapterGame

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycler()
        initDados()
    }


    private fun initRecycler() {
        this.gameAdapter = AdapterGame({
                Game -> openLink( Game.link )
        })

        recycler_principal.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = gameAdapter
        }
    }


    private fun openLink(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)

    }


    private fun initDados(){
        val listaGames = DataSource.setDataSet()
        gameAdapter.setDados(listaGames)
    }

}