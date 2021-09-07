package vinibza.com.listadegames.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.layout_game_item.view.*
import vinibza.com.listadegames.R

class AdapterGame (private val onItemClicked: (Game) -> Unit)
        : RecyclerView.Adapter<AdapterGame.myViewHolder>() {

    private var listaGames: List<Game> = ArrayList()

    class myViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        private val item_title = itemView.item_game_title
        private val item_genre = itemView.item_game_gnr
        private val item_thumbnail = itemView.item_game_img


        fun bind (game: Game, onItemClicked: (Game) -> Unit){
            item_title.text = game.title
            item_genre.text = game.genre

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.loading_img)
                .error(R.drawable.error_img)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(game.thumbnailUrl)
                .into(item_thumbnail)

            itemView.setOnClickListener { onItemClicked( game ) }
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
            is myViewHolder -> {
                holder.bind(listaGames[position], onItemClicked)
            }
        }
    }


    fun setDados(arrayGames: List<Game>){
        this.listaGames = arrayGames
    }


    override fun getItemCount(): Int {
        return listaGames.size
    }

}