package com.ilhomjon.homework422

import Kesh.MySharedPrefarance
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_malumot.*

class Malumot : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_malumot)
        val type = intent.getIntExtra("type", 0)
        val name = intent.getIntExtra("name", 0)

        MySharedPrefarance.init(this)
        val arrayProduct = MySharedPrefarance.obektString
        for (product in arrayProduct) {
            if (product.type == ArrayProduct.titleArray[type] && product.name == ArrayProduct.map[ArrayProduct.titleArray[type]]?.get(name)){
                txt_name_malumot.text=product.name
                txt_malumot.text = product.malumot
            }
        }
    }
}