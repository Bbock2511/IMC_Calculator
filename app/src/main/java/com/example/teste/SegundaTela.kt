package com.example.teste

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.teste.databinding.ActivitySegundaTelaBinding

class SegundaTela : AppCompatActivity() {

    private lateinit var binding: ActivitySegundaTelaBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundaTelaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonCalcularIMC = binding.calcularIMC
        val textViewResultado = binding.resultadoIMC

        buttonCalcularIMC.setOnClickListener {

            val textPeso = binding.inputPeso.text.toString()
            val textAltura = binding.inputAltura.text.toString()
            val peso = textPeso.toFloatOrNull()
            val altura = textAltura.toFloatOrNull()

            if (peso != null && altura != null){
                val formulaIMC = peso / (altura * altura)

                val formattedIMC = String.format("%.2f", formulaIMC)

                textViewResultado.text = "Seu IMC é: $formattedIMC"
                if (formulaIMC < 16){
                    binding.tabelaIMC.text = "Baixo peso (grau I)"
                }
                else if (formulaIMC >= 16 && formulaIMC < 17){
                    binding.tabelaIMC.text = "Baixo peso (grau II)"
                }
                else if (formulaIMC >= 17 && formulaIMC < 18.50){
                    binding.tabelaIMC.text = "Baixo peso (grau III)"
                }
                else if (formulaIMC >= 18.50 && formulaIMC < 25){
                    binding.tabelaIMC.text = "Peso ideal"
                }
                else if (formulaIMC >= 25 && formulaIMC < 30){
                    binding.tabelaIMC.text = "Sobrepeso"
                }
                else if (formulaIMC >= 30 && formulaIMC < 35){
                    binding.tabelaIMC.text = "Obesidade (grau I)"
                }
                else if (formulaIMC >= 35 && formulaIMC < 40){
                    binding.tabelaIMC.text = "Obesidade (grau II)"
                }
                else if (formulaIMC >= 40){
                    binding.tabelaIMC.text = "Obesidade (grau III)"
                }
            }
        }
    }
}