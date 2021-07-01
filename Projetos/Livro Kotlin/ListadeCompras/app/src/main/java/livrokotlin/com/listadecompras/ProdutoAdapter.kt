package livrokotlin.com.listadecompras

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import java.text.NumberFormat
import java.util.*

class ProdutoAdapter (contexto: Context) : ArrayAdapter<Produto>(contexto, 0) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val v: View

        if (convertView != null){
            v = convertView
        }else {
           v = LayoutInflater.from(context).inflate(R.layout.list_view_item, parent,false)
        }

            val item = getItem(position)
            val img_produto = v.findViewById<ImageView>(R.id.img_prod_item)
            val txt_produto = v.findViewById<TextView>(R.id.nome_prod_item)
            //val descricao = v.findViewById<TextView>(R.id.edt_descricao_prod)
            val qtd_prod    = v.findViewById<TextView>(R.id.txt_item_qtd)
            val preco_prod  = v.findViewById<TextView>(R.id.txt_item_valor)

            txt_produto.text = item?.nome.toString()
          //  descricao.text = item?.descri.toString()
            qtd_prod.text = item?.quantidade.toString()
            preco_prod.text = item?.preco.toString()

            /*
            Pegando a instância do objeto de formatação, sua localização
            caso não selecionamos nenhuma o app vai pegar a configurada no aparelho
            caso ele estiver em inglês o formato iria ficar em dolar.
             */
            val f = NumberFormat.getCurrencyInstance(Locale("pt","br"))

            //Formatando a variável no formato da moeda
            preco_prod.text = f.format(item?.preco)

            if (item?.foto != null){
            img_produto.setImageBitmap(item.foto)
            }

        return v
    }
}