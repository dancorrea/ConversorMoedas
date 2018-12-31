package com.dscorrea.conversormoedas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val entradaValor = findViewById<EditText>(R.id.entrada_valor)
        val spinnerMoeda = findViewById<Spinner>(R.id.spinner_moeda)
        val textoResultado = findViewById<TextView>(R.id.texto_resultado)
        val botaoConverter = findViewById<Button>(R.id.botao_converter)

        val adapter = ArrayAdapter.createFromResource(this, R.array.array_moedas, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerMoeda.adapter = adapter

        botaoConverter.setOnClickListener {

            var valorDigitado = entradaValor.text.toString().toDouble()
            var moedaEscolhida = spinnerMoeda.selectedItemPosition
            var valorConvertido = 0.00


            when (moedaEscolhida) {
                0 -> {
                    valorConvertido = valorDigitado / 3.88
                    textoResultado.text = "R$" + valorDigitado + " = US$" + "%.2f".format(valorConvertido)
                }
                1 -> {
                    valorConvertido = valorDigitado / 4.44
                    textoResultado.text = "R$" + valorDigitado + " = €" + "%.2f".format(valorConvertido)
                }
                2 -> {
                    valorConvertido = valorDigitado * 9.71
                    textoResultado.text = "R$" + valorDigitado + " = $" + "%.2f".format(valorConvertido)
                }
            }

        }


    }
}
