package vinibza.com.listadegames

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        recycler_principal.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = gameAdapter
        }
    }

    private fun initDados(){
        val listaGames = DataSource.setDataSet()
        this.gameAdapter.setDados(listaGames)
    }
}