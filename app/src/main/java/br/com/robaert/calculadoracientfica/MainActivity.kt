package br.com.robaert.calculadoracientfica

import android.media.VolumeShaper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
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
        var tela: MutableList<String> = mutableListOf("Teste")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tela)
        lv_tela.adapter = adapter;

        btn_number_0.setOnClickListener{
            if(operacao == Operations.SEM){
                number1 = number1 + "0"
            }else{
                number2 = number2 + "0"
            }
            tela = resultTela(tela.toMutableList(), "0")
            adapter.notifyDataSetChanged()
            adapter.setNotifyOnChange(true)
        }
        btn_number_1.setOnClickListener{
            if(operacao == Operations.SEM){
                number1 = number1 + "1"
            }else{
                number2 = number2 + "1"
            }
            resultTela(tela, "1")
        }

        btn_number_2.setOnClickListener{
            if(operacao == Operations.SEM){
                number1 = number1 + "2"
            }else{
                number2 = number2 + "2"
            }

            resultTela(tela, "2")
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

        btn_log_natural.setOnClickListener {
            var resultado = log(number1.toDouble()) / log(2.71);

            Toast.makeText(this, "Resultado: " + resultado, Toast.LENGTH_LONG).show()
            operacao = Operations.SEM
            number1 = "0"
            number2 = "0"
        }

        btn_seno.setOnClickListener {
            var radiano = toRadians(number1.toDouble());
            var resultado = sin(radiano);

            Toast.makeText(this,"Resultado: " + resultado, Toast.LENGTH_LONG).show()
            operacao = Operations.SEM;
            number1 = "0"
            number2 = "0"
        }
        btn_seno_inverso.setOnClickListener {
            //TODO: como calcula isso ?
        }

        btn_cosseno.setOnClickListener {
            var radiano = toRadians(number1.toDouble());
            var resultado = cos(radiano);

            Toast.makeText(this,"Resultado: " + resultado, Toast.LENGTH_LONG).show()
            operacao = Operations.SEM;
            number1 = "0"
            number2 = "0"
        }

        btn_cosseno_inverso.setOnClickListener {
            //TODO: como calcula isso ?
        }

        btn_tangente.setOnClickListener {
            var radiano = toRadians(number1.toDouble());
            var resultado = cos(radiano);

            Toast.makeText(this,"Resultado: " + resultado, Toast.LENGTH_LONG).show()
            operacao = Operations.SEM;
            number1 = "0"
            number2 = "0"
        }

        btn_tangente_inverso.setOnClickListener {
            //TODO: como calcula isso ?
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

    fun resultTela(listaAtual: MutableList<String>, operacao: String): MutableList<String>{

        if(listaAtual.size == 10){
            listaAtual.removeFirst();
        }
        listaAtual.add(operacao)

        return listaAtual;
    }


}