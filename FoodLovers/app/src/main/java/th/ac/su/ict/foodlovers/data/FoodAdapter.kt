package th.ac.su.ict.foodlovers.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.list_item_food.view.*
import th.ac.su.ict.foodlovers.R


class FoodAdapter(private val context: Context, private val dataSource:ArrayList<Food>) : BaseAdapter(){

    private val inflater:LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.list_item_food,null)

        rowView.tvFoodname.text = dataSource[position].Foodname
        rowView.tvFoodshop.text = dataSource[position].Shopname
        rowView.tvPrice.text = dataSource[position].Price

        val res = context.resources

        val drawableId:Int = res.getIdentifier(dataSource[position].Imagesfile,"drawable",context.packageName)
        rowView.imgThumbnail.setImageResource(drawableId)

        val drawableId2:Int = res.getIdentifier(dataSource[position].Imagespin,"drawable",context.packageName)
        rowView.imgPin.setImageResource(drawableId2)

        val drawableId3:Int = res.getIdentifier(dataSource[position].Imagesrate,"drawable",context.packageName)
        rowView.imgRate.setImageResource(drawableId3)

        return rowView

    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }

}