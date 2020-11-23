package pt.atp.dogsogram

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.os.Build
import androidx.recyclerview.widget.RecyclerView
import pt.atp.dogsogram.model.Dog
import kotlinx.android.synthetic.main.item_story.view.*

class StoryAdapter internal constructor(private val dogs: List<Dog>) : RecyclerView.Adapter<StoryAdapter.MainViewHolder?>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    return MainViewHolder(inflater.inflate(R.layout.item_story, parent, false))
  }

  override fun getItemCount(): Int {
    return dogs.size
  }

  override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
    val feed = dogs[position]
    holder.userName.text = feed.name.split(" ")[0]

    holder.userImage.setImageResource(feed.picture)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      holder.userImage.clipToOutline = true
    }
  }

  class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val userImage = itemView.iv_user_image!!
    val userName = itemView.tv_user_name!!
  }
}