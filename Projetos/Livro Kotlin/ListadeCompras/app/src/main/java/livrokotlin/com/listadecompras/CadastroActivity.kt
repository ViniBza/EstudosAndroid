package livrokotlin.com.listadecompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        /*Inserir produto na lista
        btn_inserir_prod.setOnClickListener {
            val produto = edt_nome_prod.text.toString()
            edt_produto.text.clear()

            if (produto.isNotEmpty()){
                produtosAdapter.add( produto )
            }else {
                edt_produto.error = "Por favor, digite o produto."
            }
        }

         */
    }
}