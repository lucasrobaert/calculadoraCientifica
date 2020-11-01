package br.com.robaert.calculadoracientfica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var number1 = "0"
        var number2  = "0";
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
        btn_number_3.setOnClickListener{
            if(operacao == Operations.SEM){
                number1 = number1 + "3"
            }else{
                number2 = number2 + "3"
            }
        }
        btn_number_4.setOnClickListener{
            if(operacao == Operations.SEM){
                number1 = number1 + "4"
            }else{
                number2 = number2 + "4"
            }
        }
        btn_number_5.setOnClickListener{
            if(operacao == Operations.SEM){
                number1 = number1 + "5"
            }else{
                number2 = number2 + "5"
            }
        }
        btn_number_6.setOnClickListener{
            if(operacao == Operations.SEM){
                number1 = number1 + "6"
            }else{
                number2 = number2 + "6"
            }
        }
        btn_number_7.setOnClickListener{
            if(operacao == Operations.SEM){
                number1 = number1 + "7"
            }else{
                number2 = number2 + "7"
            }
        }
        btn_number_8.setOnClickListener{
            if(operacao == Operations.SEM){
                number1 = number1 + "8"
            }else{
                number2 = number2 + "8"
            }
        }
        btn_number_9.setOnClickListener{
            if(operacao == Operations.SEM){
                number1 = number1 + "9"
            }else{
                number2 = number2 + "9"
            }
        }
        btn_dot.setOnClickListener{
            if(operacao == Operations.SEM){
                number1 = number1 + "."
            }else{
                number2 = number2 + "."
            }
        }

        btn_soma.setOnClickListener{
            operacao = Operations.SOMA
        }

        btn_sub.setOnClickListener {
            operacao = Operations.SUBTRACAO
        }
        btn_divisao.setOnClickListener {
            operacao = Operations.DIVISAO
        }
        btn_multiplica.setOnClickListener {
            operacao = Operations.MULTIPLICACAO
        }

        btn_raiz.setOnClickListener {
            var resultado = sqrt(number1.toDouble());
            Toast.makeText(this,"Resultado: " + resultado, Toast.LENGTH_LONG).show()
            operacao = Operations.SEM;
            number1 = "0"
            number2 = "0"
        }

        btn_modulo.setOnClickListener {
            operacao = Operations.MODULO
        }

        btn_fatorial.setOnClickListener {
            var fatorial = number1.toDouble()
            var valor = number1.toDouble();
            while (valor > 1){
                fatorial = fatorial * (valor - 1)
                valor --;
            }

            Toast.makeText(this,"Resultado: " + fatorial, Toast.LENGTH_LONG).show()
            operacao = Operations.SEM;
            number1 = "0"
            number2 = "0"
        }

        btn_potencia.setOnClickListener {
            operacao = Operations.POTENCIA
        }

        btn_quadrado.setOnClickListener {
            var resultado = pow(number1.toDouble(), 2.0);
            Toast.makeText(this,"Resultado: " + resultado, Toast.LENGTH_LONG).show()
            operacao = Operations.SEM;
            number1 = "0"
            number2 = "0"
        }

        btn_inverter.setOnClickListener {
            // vai pegar o ultimo valor exibido e inverter o sinal
            // se for + vira -
            // se for - vira +
        }

        btn_log.setOnClickListener {
            var resultado = log(number1.toDouble()) / log(10.0);
            // TODO: verificar se essr trem ta certo

            Toast.makeText(this,"Resultado: " + resultado, Toast.LENGTH_LONG).show()
            operacao = Operations.SEM;
            number1 = "0"
            number2 = "0"
        }

        btn_equals.setOnClickListener {
            var result = resultado(number1.toDouble(), number2.toDouble(), operacao)
            operacao = Operations.SEM;
            number1 = "0"
            number2 = "0"

            Toast.makeText(this,"Resultado: " + result, Toast.LENGTH_LONG).show()
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
            Operations.MULTIPLICACAO -> {
                resultado = number1 * number2
            }
            Operations.DIVISAO -> {
                resultado = number1 / number2
            }
            Operations.MODULO -> {
                resultado = number1 % number2
            }
            Operations.POTENCIA -> {
                resultado = pow(number1, number2)
            }
        }

        return resultado;
    }


}