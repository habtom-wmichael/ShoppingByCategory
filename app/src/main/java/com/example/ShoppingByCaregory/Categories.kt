package com.example.ShoppingByCaregory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.tv1

class Categories : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        val intent = getIntent()
        val outPut = intent.getStringExtra("user")
        tv1.text = "welcome $outPut"
    }
    fun selectedProduct(view: View){
        val result=when(view.id){
            R.id.img1->"electronics"
            R.id.img2->"clothing"
            R.id.img3->"beauty"
            else->"food"
        }
        var intent = Intent(this, ProductList::class.java)
        intent.putExtra("product", result)
        startActivity(intent)
    }
}
