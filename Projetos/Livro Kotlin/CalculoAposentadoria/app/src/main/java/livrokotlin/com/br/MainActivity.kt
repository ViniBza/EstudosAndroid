package livrokotlin.com.br

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spn_sexo = findViewById<Spinner>(R.id.spn_sexo)
        val edt_idade = findViewById<EditText>(R.id.edt_idade)
        val btn_calcular = findViewById<Button>(R.id.btn_calcular)
        val txt_resultado = findViewById<TextView>(R.id.txt_resultado)

        spn_sexo.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,
        listOf("Masculino", "Feminino"))

        btn_calcular.setOnClickListener {

            //Faz com que o retorno do spn seja do tipo string
            val sexo = spn_sexo.selectedItem as String

            //recuperar a idade do usuário
            val idade = edt_idade.text.toString().toInt()

            var resultado = 0
            if (sexo == "Masculino") {
                resultado = 65 - idade
            }else{
                resultado = 60 - idade
            }

            //Atualizando o resultado de acordo com o fornecido.
            txt_resultado.text = " Faltam $resultado anos para você se aposentar."
        }
    }
}