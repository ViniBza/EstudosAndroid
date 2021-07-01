package livrokotlin.com.listadecompras

import android.graphics.Bitmap

data class Produto(val nome: String, val quantidade: Int,
                   val preco: Double, val foto: Bitmap? = null )