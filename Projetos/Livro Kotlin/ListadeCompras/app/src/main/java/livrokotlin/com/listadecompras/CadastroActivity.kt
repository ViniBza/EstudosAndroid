    package livrokotlin.com.listadecompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cadastro.*
import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_view_item.*


class CadastroActivity : AppCompatActivity() {
    val CODE_IMAGE = 101
    var imageBitMap: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        // Inserir produto na lista
        btn_inserir_prod.setOnClickListener {

            //Pegando os valores digitados
            val produto = edt_nome_prod.text.toString()

            val qtd = edt_quantidade_prod.text.toString()
            val valor = edt_preco_prod.text.toString()

            // Verificando se o usuário digitou algum valor
            if (produto.isNotEmpty() && qtd.isNotEmpty() && valor.isNotEmpty()) {

                val prod = Produto (produto,  qtd.toInt(), valor.toDouble(), imageBitMap)
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

        img_foto_prod.setOnClickListener { abrirGaleria() }

        Toast.makeText(this, "Adicionado com sucesso!", Toast.LENGTH_SHORT).show()

        finish()

    }

    fun abrirGaleria() {
        //definindo a ação do conteúdo
        val intent = Intent(Intent.ACTION_GET_CONTENT)

        //defindindo o filtro para imagens
        intent.type = "image/*"

        //inicializando a activity com resultado
        startActivityForResult(Intent.createChooser(intent, "Selecione uma imagem"), CODE_IMAGE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == CODE_IMAGE && resultCode == Activity.RESULT_OK){
            if (data != null){
                // Neste ponto podemos acessar a imagem escolhida através da variável "data"

                // Lendo URI com a imagem
                val inputStream = data.getData()?.let { contentResolver.openInputStream(it) };

                // Transformando resultado em bitmap
                imageBitMap = BitmapFactory.decodeStream(inputStream)

                // Exibir a imagem no app
                img_foto_prod.setImageBitmap(imageBitMap)
            }
        }
    }
}






