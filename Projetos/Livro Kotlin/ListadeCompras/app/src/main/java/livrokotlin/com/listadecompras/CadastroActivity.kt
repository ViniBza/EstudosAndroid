package livrokotlin.com.listadecompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        // Inserir produto na lista
        btn_inserir_prod.setOnClickListener {

            //Pegando os valores digitados
            val produto = edt_nome_prod.text.toString()
            val descri = edt_descricao_prod.text.toString()
            val qtd = edt_quantidade_prod.text.toString()
            val valor = edt_preco_prod.text.toString()

            // Verificando se o usuário digitou algum valor
            if (produto.isNotEmpty() && qtd.isNotEmpty() && valor.isNotEmpty()) {

                val prod = Produto (produto,  qtd.toInt(), descri, valor.toDouble())
                produtosGlobal.add(prod)



            } else {

                edt_nome_prod.error = if (edt_nome_prod.text.isEmpty()) "Por favor, preencha o nome." else null

                edt_quantidade_prod.error = if (edt_quantidade_prod.text.isEmpty()) "Por favor, preencha a quantidade." else null

                edt_preco_prod.error = if (edt_preco_prod.text.isEmpty()) "Por favor, preencha a descrição." else null

                /*
                if (produto.isEmpty()) {
                    edt_nome_prod.error = "Pfv, preencha o nome do produto."
                } else {
                    edt_nome_prod.error = null
                }

                if (qtd.isEmpty()) {
                    edt_quantidade_prod.error = "Pfv, preencha a quantidade."
                } else {
                    edt_quantidade_prod.error = null
                }

                if (valor.isEmpty()) {
                    edt_preco_prod.error = "Pfv, preencha o valor."
                } else {
                    edt_preco_prod.error = null
                }

                 */
            }
        }
    }
 }
