package com.ilhomjon.homework422

import Adapter.ExpandetAdapter
import Kesh.MySharedPrefarance
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.forEach
import androidx.core.view.size
import kotlinx.android.synthetic.main.activity_main.*
import obektMalumot.Product

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ArrayProduct.titleArray.add(resources.getString(R.string.mobiles))
        ArrayProduct.titleArray.add(resources.getString(R.string.leptops))
        ArrayProduct.titleArray.add(resources.getString(R.string.com_accses))
        ArrayProduct.titleArray.add(resources.getString(R.string.home_enter))
        ArrayProduct.titleArray.add(resources.getString(R.string.tvs_by_brand))
        ArrayProduct.titleArray.add(resources.getString(R.string.kitchen))
        val expandableListAdapter = ExpandetAdapter(ArrayProduct.titleArray, ArrayProduct.map)
        expanded_menu.setAdapter(expandableListAdapter)


        expanded_menu.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            if(ArrayProduct.map[ArrayProduct.titleArray[groupPosition]]?.get(childPosition) == "add") {
                startActivity(Intent(this, Qoshish::class.java).putExtra("type", groupPosition))
            }else{
                startActivity(Intent(this, Malumot::class.java).putExtra("type", groupPosition).putExtra("name", childPosition))
            }
            true
        }



    }

    override fun onStart() {
        super.onStart()
        MySharedPrefarance.init(this)
        val arrayProduct: ArrayList<Product> = MySharedPrefarance.obektString
        loadData(arrayProduct)

        for (i in 0..5){
            expanded_menu.collapseGroup(i)
        }

    }

    private fun loadData(list: List<Product>) {


        for (s in ArrayProduct.titleArray) {
            ArrayProduct.map[s] = listOf("add")

            var listP = ArrayList<String>()
            if (listP.size == 0){
                listP.add("add")
            }
            for (product in list) {
                if (product.type == s) {
                   // listP.add("add")
                    listP.add(product.name)
                }
            }
            ArrayProduct.map[s] = listP
        }
        println(ArrayProduct.map)
    }
}
object ArrayProduct{
    val titleArray = ArrayList<String>()
    var map: HashMap<String, List<String>> = HashMap()
}