package livrokotlin.com.listadecompras

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
        val produtosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        list_view_produtos.adapter = produtosAdapter

        //Removendo produto da lista
        list_view_produtos.setOnItemLongClickListener{ adapterView: AdapterView<*>, view: View, position: Int, id: Long ->

            val item = produtosAdapter.getItem(position)
            produtosAdapter.remove(item)
            true
        }


        //Inserir produto na lista
        btn_inserir.setOnClickListener {
            val produto = edt_produto.text.toString()
            edt_produto.text.clear()

            if (produto.isNotEmpty()){
                produtosAdapter.add( produto )
            }else {
                edt_produto.error = "Por favor, digite o produto."
            }
        }

       }
}