/**
 *
 * ZapAdapter:
 * Adapter for our recycler view, takes a Item object which is of the example below:
 *  {
    "albumId": 1,
    "id": 1,
    "title": "accusamus beatae ad facilis cum similique qui sunt",
    "url": "https://via.placeholder.com/600/92c952",
    "thumbnailUrl": "https://via.placeholder.com/150/92c952"
    }
 */

package com.example.zapapp
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view.view.*

class ZapAdapter(private val zapList:
                     List<Item>): RecyclerView.Adapter<ZapAdapter.ZapViewHolder>(){
    //parent is a RecyclerView and the ZapViewHolder we are creating will be
    //place in it
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZapViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_view,
            parent, false )
        //false means don't add to the recyclerView immediately
        return ZapViewHolder(itemView);
    }
    override fun getItemCount() = zapList.size

    override fun onBindViewHolder(holder: ZapViewHolder, position: Int) {
        //this sets the data for the views
        val currentItem = zapList[position]
        Picasso.get().load("https://via.placeholder.com/150/92c952").into(holder.imageView);
        holder.textView1.text = "$position - ${currentItem.title}"
        /**
         * Dont Do:
         * holder.itemView.text_view_1.text = currentItem.text1
         * bc it calls findViewById under the hood and that's
         * what you should typically avoid*/
    }

    class ZapViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        //instantiate our views
        val imageView: ImageView = itemView.image_view
        val textView1: TextView = itemView.text_view_1

    }
}
