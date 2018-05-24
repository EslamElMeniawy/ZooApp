package elmeniawy.eslam.zoo

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_item.view.*

class MainActivity : AppCompatActivity() {
    private val animalsList = ArrayList<Animal>()
    private var adapter: AnimalsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Fill animals list
        animalsList.add(Animal(getString(R.string.baboon), getString(R.string.baboon_desc), R.drawable.baboon, false))
        animalsList.add(Animal(getString(R.string.bulldog), getString(R.string.bulldog_desc), R.drawable.bulldog, true))
        animalsList.add(Animal(getString(R.string.panda), getString(R.string.panda_desc), R.drawable.panda, false))
        animalsList.add(Animal(getString(R.string.swallow_bird), getString(R.string.swallow_bird_desc), R.drawable.swallow_bird, false))
        animalsList.add(Animal(getString(R.string.white_tiger), getString(R.string.white_tiger_desc), R.drawable.white_tiger, true))
        animalsList.add(Animal(getString(R.string.zebra), getString(R.string.zebra_desc), R.drawable.zebra, false))

        // Define the adapter
        adapter = AnimalsAdapter(animalsList, this)

        // Add adapter to list
        listAnimals.adapter = adapter
    }

    class AnimalsAdapter(var animalsList: ArrayList<Animal>, var context: Context) : BaseAdapter() {
        @SuppressLint("ViewHolder")
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val animal = animalsList[position]
            val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val animalView: View?

            animalView = if (animal.isKiller) {
                layoutInflater.inflate(R.layout.animal_killer_item, parent, false)
            } else {
                layoutInflater.inflate(R.layout.animal_item, parent, false)
            }
            
            animalView.tvName.text = animal.name
            animalView.tvDescription.text = animal.description
            animalView.ivImage.setImageResource(animal.image)
            return animalView
        }

        override fun getItem(position: Int): Any {
            return animalsList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return animalsList.size
        }
    }
}
