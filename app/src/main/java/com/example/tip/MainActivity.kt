package com.example.tip

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tip.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculate.setOnClickListener { calculate() }
    }
    fun calculate(){
        val cost=binding.price.text.toString().toDoubleOrNull()
        if(cost==null){
            binding.tip.text=""
            binding.total.text=""
            return
        }
        val tipOption=when(binding.tipOptions.checkedRadioButtonId){
            R.id.amazing->0.20
            R.id.good->0.15
            else->0.10
        }
        var tip=cost*tipOption
        var total=cost+tip
        if(binding.round.isChecked){
           tip=kotlin.math.ceil(tip)
            total=kotlin.math.ceil(total)
        }
        binding.tip.text=NumberFormat.getCurrencyInstance(Locale("en","In")).format(tip)
        binding.total.text=NumberFormat.getCurrencyInstance(Locale("en","In")).format(total)
    }
}