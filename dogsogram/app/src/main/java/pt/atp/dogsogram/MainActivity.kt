package pt.atp.dogsogram

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    setup()
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    val inflater = menuInflater
    inflater.inflate(R.menu.menu_action, menu)
    return true
  }

  private fun setup() {
    findViewById<RecyclerView>(R.id.rv_stories).apply {
      setHasFixedSize(true)
      layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
      adapter = StoryAdapter(Dogs.dogs)
    }

    findViewById<RecyclerView>(R.id.rv_feed).apply {
      setHasFixedSize(true)
      layoutManager = LinearLayoutManager(applicationContext)
      adapter = FeedAdapter(Dogs.dogs)
    }
  }
}