package livrokotlin.com.listadecompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Criando o adaptador da lista
        val produtosAdapter = ProdutoAdapter(this)
        list_view_produtos.adapter = produtosAdapter

        //Removendo produto da lista
        list_view_produtos.setOnItemLongClickListener{ adapterView: AdapterView<*>, view: View, position: Int, id: Long ->

            val item = produtosAdapter.getItem(position)
            produtosAdapter.remove(item)
            true
        }

       add_produtos.setOnClickListener {
           val intent = Intent(this, CadastroActivity::class.java)
           startActivity(intent)

       }
       }

    override fun onResume() {
        super.onResume()

        val adapter = list_view_produtos.adapter as ProdutoAdapter

        produtosAdapter.addAll(produtosGlobal)
    }
}