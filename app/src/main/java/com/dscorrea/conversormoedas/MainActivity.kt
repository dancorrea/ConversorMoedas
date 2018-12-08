package com.dscorrea.conversormoedas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById(R.id.spnMoeda) as Spinner
        val adapter = ArrayAdapter.createFromResource(this, R.array.array_moedas, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.setAdapter(adapter)

        btnConverter.setOnClickListener {

//            val valorConvertido = when (spinner.selectedItem) {
//                "Dolar" -> 4.00
//                "Euro" -> 4.50
//                "Peso" ->  0.10
//            }

            val valorConvertido = lblValor.text.toString().toDouble() / 3.88
            lblResultado.setText("%.2f".format(valorConvertido))
        }
    }
}
