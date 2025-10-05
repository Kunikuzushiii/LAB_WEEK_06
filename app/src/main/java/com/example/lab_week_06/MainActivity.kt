package com.example.lab_week_06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy { findViewById(R.id.recycler_view) }
    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this), object: CatAdapter.OnClickListener {
            override fun onItemClick(cat: com.example.lab_week_06.model.CatModel) = showSelectionDialog(cat)
        })
    }
    private fun showSelectionDialog(cat: com.example.lab_week_06.model.CatModel) {
        androidx.appcompat.app.AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val itemTouchHelper = androidx.recyclerview.widget.ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        catAdapter.setData(
            listOf(
                CatModel(Gender.Male, CatBreed.BalineseJavanese, "Fred", "Silent and deadly", "https://cdn2.thecatapi.com/images/7dj.jpg"),
                CatModel(Gender.Female, CatBreed.ExoticShorthair, "Wilma", "Cuddly assassin", "https://cdn2.thecatapi.com/images/egv.jpg"),
                CatModel(Gender.Unknown, CatBreed.AmericanCurl, "Curious George", "Award winning investigator", "https://cdn2.thecatapi.com/images/bar.jpg"),
                CatModel(Gender.Male, CatBreed.ExoticShorthair, "Milo", "Nap champion", "https://cdn2.thecatapi.com/images/2ao.jpg"),
                CatModel(Gender.Female, CatBreed.BalineseJavanese, "Luna", "Moonlit prowler", "https://cdn2.thecatapi.com/images/0XYvRd7oD.jpg"),
                CatModel(Gender.Male, CatBreed.AmericanCurl, "Oscar", "Fish connoisseur", "https://cdn2.thecatapi.com/images/6qi.jpg"),
                CatModel(Gender.Female, CatBreed.ExoticShorthair, "Bella", "Curly whiskers", "https://cdn2.thecatapi.com/images/MTY3ODIyMQ.jpg"),
                CatModel(Gender.Male, CatBreed.BalineseJavanese, "Simba", "Small king", "https://cdn2.thecatapi.com/images/a3d.jpg"),
                CatModel(Gender.Female, CatBreed.AmericanCurl, "Cleo", "Silent hunter", "https://cdn2.thecatapi.com/images/1rh.jpg"),
                CatModel(Gender.Unknown, CatBreed.ExoticShorthair, "Echo", "Mysterious meower", "https://cdn2.thecatapi.com/images/34d.jpg")
            )
        )
    }
}
