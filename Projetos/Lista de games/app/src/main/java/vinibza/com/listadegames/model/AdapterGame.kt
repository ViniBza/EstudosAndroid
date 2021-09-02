package vinibza.com.listadegames.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_game_item.view.*
import vinibza.com.listadegames.R

class AdapterGame: RecyclerView.Adapter<AdapterGame.myViewHolder>() {
    private var listaGames: List<Game> = ArrayList()

    class myViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        var item_title: TextView = itemView.item_game_title
        var item_genre: TextView = itemView.item_game_gnr

        fun bind (game: Game){
            item_title.text = game.title
            item_genre.text = game.genre
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        return myViewHolder(
                LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_game_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        when  (holder) {
            is myViewHolder ->{
                holder.bind(listaGames[position])
            }
        }
    }

    fun setDados(arrayGames: ArrayList<Game>){
        this.listaGames = arrayGames
    }


    override fun getItemCount(): Int {
        return listaGames.size
    }

}