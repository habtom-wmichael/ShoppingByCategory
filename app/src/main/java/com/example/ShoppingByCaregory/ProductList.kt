package com.example.ShoppingByCaregory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_categories.*
import kotlinx.android.synthetic.main.activity_product_list.*

class ProductList : AppCompatActivity() {
    lateinit var items:Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)
        val incomingIntent: Intent =  getIntent()
        var category = incomingIntent.getSerializableExtra("product")
        var item = category.toString()
        items = when(item) {
            "food" ->getResources().getStringArray(R.array.food)
            "clothing" ->getResources().getStringArray(R.array.clothing)
            "beauty" ->getResources().getStringArray(R.array.beauty)
            else->getResources().getStringArray(R.array.electronics)
        }
        product.text = "${item.capitalize()} List"
        val listAdapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, items)
        itemList.setAdapter(listAdapter)
        itemList.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val item = parent.getItemAtPosition(position).toString()
                var intent = Intent(this, ProductList::class.java)
                Toast.makeText(this, "You have chosen the $item item", Toast.LENGTH_LONG).show()
            }
    }
}
