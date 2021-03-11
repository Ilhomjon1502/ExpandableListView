package com.ilhomjon.homework422

import Kesh.MySharedPrefarance
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_qoshish.*
import obektMalumot.Product

class Qoshish : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qoshish)

        val type = intent.getIntExtra("type", 0)
        txt_qoshish.text = ArrayProduct.titleArray[type]
        MySharedPrefarance.init(this)
        card_add.setOnClickListener {
            val edtName = edt_name_qoshish.text.toString().trim()
            val edtMalumot = edt_edit_malumot_qoshish.text.toString().trim()
            if (edtMalumot!="" && edtName!=""){
                Toast.makeText(this, "Information added", Toast.LENGTH_SHORT).show()
                val product = Product(ArrayProduct.titleArray[type], edtName, edtMalumot)
                val array = MySharedPrefarance.obektString
                array.add(product)
                MySharedPrefarance.obektString = array
                finish()
            }else{
                Toast.makeText(this, "EditTexts is empty!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}