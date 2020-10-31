package br.com.robaert.calculadoracientfica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var number1 = ""
        var number2  = "";
        var operacao: Operations = Operations.SEM;
        var tela: List<String>? = null;
        //  Digita o primeiro numero
        // Digita a operacao
        // Digita o segundo numero, caso precise;
        // Tecla de resultado

        btn_number_0.setOnClickListener{
            if(operacao == Operations.SEM){
                number1 = number1 + "0"
            }else{
                number2 = number2 + "0"
            }
        }
        btn_number_1.setOnClickListener{
            if(operacao == Operations.SEM){
                number1 = number1 + "1"
            }else{
                number2 = number2 + "1"
            }
        }

        btn_number_2.setOnClickListener{
            if(operacao == Operations.SEM){
                number1 = number1 + "2"
            }else{
                number2 = number2 + "2"
            }
        }

        btn_soma.setOnClickListener{
            operacao = Operations.SOMA
        }

        btn_sub.setOnClickListener {
            operacao = Operations.SUBTRACAO
        }

        btn_equals.setOnClickListener {
            var result = resultado(number1.toDouble(), number2.toDouble(), operacao)
            operacao = Operations.SEM;
            number1 = ""
            number2 = ""

            Toast.makeText(this,"Resultado :" + result, Toast.LENGTH_LONG).show()
        }

    }

    fun resultado(number1: Double, number2: Double, operacao: Operations ): Double {
        var resultado: Double = 0.0;
        when(operacao){
            Operations.SOMA -> {
                resultado = number1 + number2;

            }
            Operations.SUBTRACAO -> {
                resultado = number1 - number2

            }
        }

        return resultado;
    }


}