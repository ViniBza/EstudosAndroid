package livrokotlin.com.listadecompras

import android.graphics.Bitmap

data class Produto(val nome: String, val quantidade: Int,
                   val descricao: String, val preco: Double,
                   val foto: Bitmap? = null )