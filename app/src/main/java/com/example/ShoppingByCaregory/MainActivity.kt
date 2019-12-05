package com.example.ShoppingByCaregory

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var users: ArrayList<User> = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        users.add(User("Gebre", "Hayle", "gebre@examp.com", "gebrehayle"))
        users.add(User("Gebru", "Hagos", "gebru@examp.com", "gebruhagos"))
        users.add(User("Getachew", "Hdray", "getachew@examp.com", "getachewhdray"))
        users.add(User("Zergabr", "Dagyat", "zergabr@examp.com", "zergabrdegyat"))
        users.add(User("Samuel", "Esak", "samuel@examp.com", "samuel"))

    }
    fun login(view: View){
        for(i in users){
            var uname:String =  i.userName
            var upassword:String =  i.password
            if(et1.text.toString().equals(uname) && et2.text.toString().equals(upassword)){
                var intent = Intent(this, Categories::class.java)
                intent.putExtra("user", uname)
                startActivity(intent)
                break
            }
        }
    }
    fun createAccount(view: View){
        var intent = Intent(this,Register::class.java)
        startActivityForResult(intent, 1)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1){
            if(resultCode == Activity.RESULT_OK){
                if(data != null){
                    val ReturnedResult = data.getSerializableExtra("newUser") as User
                    users.add(ReturnedResult)
                    Toast.makeText(this, "Account created successfully as user name of ${ReturnedResult.userName}", Toast.LENGTH_LONG).show()
                }

            }
        }
    }


    fun getPassword(view: View){
        if(tv4.text.isNotEmpty()){
            var pass:String? = null
            for(i in users){
                if(i.userName==et1.text.toString()){
                    pass = i.password
                    break
                }
            }
            if(pass != null){
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, pass)
                startActivity(intent)
            }
        }
    }
}