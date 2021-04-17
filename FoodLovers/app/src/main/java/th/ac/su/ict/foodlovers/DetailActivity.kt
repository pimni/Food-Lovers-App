package th.ac.su.ict.foodlovers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.list_item_food.*
import kotlinx.android.synthetic.main.list_item_food.view.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val FoodnameDe = intent.getStringExtra("FoodnameDe")
        val ShopnameDe = intent.getStringExtra("ShopnameDe")
        val Imagesfile = intent.getStringExtra("Imagesfile")
        val ImagePin2 = intent.getStringExtra("ImagePin2")
        val ImageRate2 = intent.getStringExtra("ImageRate2")
        val detailvt = intent.getStringExtra("Detail")

        Foodnametv.setText(FoodnameDe)
        Shopnametv.setText(ShopnameDe)
        detailView.setText(detailvt)

        val res = resources
        val drawableId:Int =
            res.getIdentifier(Imagesfile,"drawable",packageName)
        imgView.setImageResource(drawableId)

        val drawableId2:Int =
            res.getIdentifier(ImagePin2,"drawable",packageName)
        imgPin2.setImageResource(drawableId2)

        val drawableId3:Int =
            res.getIdentifier(ImageRate2,"drawable",packageName)
        rateView.setImageResource(drawableId3)





    }
}