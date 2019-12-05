package com.example.ShoppingByCaregory

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }
    fun createUser(view: View){
        var fName : String = et1.text.toString()
        var lName : String = et2.text.toString()
        var email : String = et3.text.toString()
        var password : String = et4.text.toString()
        if(fName.isNotEmpty() && lName.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()){
            var user = User(fName, lName, email, password)
            var intent = Intent()
            intent.putExtra("newUser", user)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }

    }
}

