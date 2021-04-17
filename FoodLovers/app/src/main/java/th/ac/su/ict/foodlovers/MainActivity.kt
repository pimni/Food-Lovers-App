package th.ac.su.ict.foodlovers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import th.ac.su.ict.foodlovers.Utils.getJsonDataFromAsset
import th.ac.su.ict.foodlovers.data.Food
import th.ac.su.ict.foodlovers.data.FoodAdapter

class MainActivity : AppCompatActivity() {

        var itemList : ArrayList<Food> = ArrayList<Food>()
        lateinit var arrayAdapter: ArrayAdapter<Food>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonFileString = getJsonDataFromAsset(applicationContext,"food_data.json")
        val gson = Gson()
        val listItemType = object : TypeToken<ArrayList<Food>>(){}.type

        var foodmenuList : ArrayList<Food> = gson.fromJson(jsonFileString,listItemType)

//        Log.i("data",foodmenuList[0].Foodname)

        itemList = foodmenuList
        val adapter = FoodAdapter(this@MainActivity,itemList)
        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            var intent = Intent( this@MainActivity,DetailActivity::class.java)
            intent.putExtra("Imagesfile",itemList[position].Imagesfile)
            intent.putExtra("FoodnameDe",itemList[position].Foodname)
            intent.putExtra("ShopnameDe",itemList[position].Shopname)
            intent.putExtra("ImagePin2",itemList[position].Imagespin)
            intent.putExtra("ImageRate2",itemList[position].Imagesrate)
            intent.putExtra("Detail",itemList[position].Descript)

            startActivity(intent)
        }

    }
}