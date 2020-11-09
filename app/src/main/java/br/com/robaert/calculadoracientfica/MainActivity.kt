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
    var primeiroNumero = ""
    var segundoNumero = ""
    var operacaoFinal: Operations = Operations.SEM
    var resultadoFinal: Double = 0.0;
    var tela: MutableList<String> = mutableListOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var primeiroNumero = "0"
        //var segundoNumero  = "0";
        var operacao: Operations = Operations.SEM;

        teTela.setText("");


        btn_number_0.setOnClickListener{
            if(operacaoFinal == Operations.SEM){
                primeiroNumero = primeiroNumero + "0"
            }else{
                segundoNumero = segundoNumero + "0"
            }
            teTela.setText(resultTela(tela, "0"))
        }
        btn_number_1.setOnClickListener{
            if(operacaoFinal == Operations.SEM){
                primeiroNumero = primeiroNumero + "1"
            }else{
                segundoNumero = segundoNumero + "1"
            }
            teTela.setText(resultTela(tela, "1"))
        }

        btn_number_2.setOnClickListener{
            if(operacaoFinal == Operations.SEM){
                primeiroNumero = primeiroNumero + "2"
            }else{
                segundoNumero = segundoNumero + "2"
            }

            teTela.setText(resultTela(tela, "2"))
        }
        btn_number_3.setOnClickListener{
            if(operacaoFinal == Operations.SEM){
                primeiroNumero = primeiroNumero + "3"
            }else{
                segundoNumero = segundoNumero + "3"
            }
            teTela.setText(resultTela(tela, "3"))
        }
        btn_number_4.setOnClickListener{
            if(operacaoFinal == Operations.SEM){
                primeiroNumero = primeiroNumero + "4"
            }else{
                segundoNumero = segundoNumero + "4"
            }
            teTela.setText(resultTela(tela, "4"))
        }
        btn_number_5.setOnClickListener{
            if(operacaoFinal == Operations.SEM){
                primeiroNumero = primeiroNumero + "5"
            }else{
                segundoNumero = segundoNumero + "5"
            }
            teTela.setText(resultTela(tela, "5"))
        }
        btn_number_6.setOnClickListener{
            if(operacaoFinal == Operations.SEM){
                primeiroNumero = primeiroNumero + "6"
            }else{
                segundoNumero = segundoNumero + "6"
            }
            teTela.setText(resultTela(tela, "6"))
        }
        btn_number_7.setOnClickListener{
            if(operacaoFinal == Operations.SEM){
                primeiroNumero = primeiroNumero + "7"
            }else{
                segundoNumero = segundoNumero + "7"
            }
            teTela.setText(resultTela(tela, "7"))
        }
        btn_number_8.setOnClickListener{
            if(operacaoFinal == Operations.SEM){
                primeiroNumero = primeiroNumero + "8"
            }else{
                segundoNumero = segundoNumero + "8"
            }
            teTela.setText(resultTela(tela, "8"))
        }
        btn_number_9.setOnClickListener{
            if(operacaoFinal == Operations.SEM){
                primeiroNumero = primeiroNumero + "9"
            }else{
                segundoNumero = segundoNumero + "9"
            }
            teTela.setText(resultTela(tela, "9"))
        }
        btn_dot.setOnClickListener{
            if(operacaoFinal == Operations.SEM){
                primeiroNumero = primeiroNumero + "."
            }else{
                segundoNumero = segundoNumero + "."
            }
            teTela.setText(resultTela(tela, "."))
        }

        btn_soma.setOnClickListener{
            cacularComResultado()

            operacaoFinal = Operations.SOMA
            teTela.setText(resultTela(tela, "+"))
        }

        btn_sub.setOnClickListener {
            cacularComResultado()
            operacaoFinal = Operations.SUBTRACAO
            teTela.setText(resultTela(tela, "-"))
        }
        btn_divisao.setOnClickListener {
            cacularComResultado()
            operacaoFinal = Operations.DIVISAO
            teTela.setText(resultTela(tela, "/"))
        }
        btn_multiplica.setOnClickListener {
            cacularComResultado()
            operacaoFinal = Operations.MULTIPLICACAO
            teTela.setText(resultTela(tela, "x"))
        }

        btn_raiz.setOnClickListener {
            cacularComResultado()
            operacaoFinal = Operations.RAIZ
            resultado()
        }

        btn_modulo.setOnClickListener {
            cacularComResultado()
            operacaoFinal = Operations.MODULO
        }

        btn_fatorial.setOnClickListener {
            cacularComResultado()
            var fatorial = primeiroNumero.toDouble()
            var valor = primeiroNumero.toDouble();
            while (valor > 1){
                fatorial = fatorial * (valor - 1)
                valor --;
            }

            Toast.makeText(this,"Resultado: " + fatorial, Toast.LENGTH_LONG).show()
            operacaoFinal = Operations.SEM;
            primeiroNumero = "0"
            segundoNumero = "0"
        }

        btn_potencia.setOnClickListener {
            cacularComResultado()
            operacaoFinal = Operations.POTENCIA
        }

        btn_quadrado.setOnClickListener {
            cacularComResultado()
            var resultado = pow(primeiroNumero.toDouble(), 2.0);
            Toast.makeText(this,"Resultado: " + resultado, Toast.LENGTH_LONG).show()
            operacaoFinal = Operations.SEM;
            primeiroNumero = "0"
            segundoNumero = "0"
        }

        btn_inverter.setOnClickListener {
            cacularComResultado()
            // vai pegar o ultimo valor exibido e inverter o sinal
            // se for + vira -
            // se for - vira +
        }

        btn_log.setOnClickListener {
            cacularComResultado()
            var resultado = log10(primeiroNumero.toDouble());
            // TODO: verificar se essr trem ta certo

            Toast.makeText(this,"Resultado: " + resultado, Toast.LENGTH_LONG).show()
            operacaoFinal = Operations.SEM;
            primeiroNumero = "0"
            segundoNumero = "0"
        }

        btn_log_natural.setOnClickListener {
            cacularComResultado()
            var resultado = log(primeiroNumero.toDouble());

            Toast.makeText(this, "Resultado: " + resultado, Toast.LENGTH_LONG).show()
            operacaoFinal = Operations.SEM
            primeiroNumero = "0"
            segundoNumero = "0"
        }

        btn_seno.setOnClickListener {
            cacularComResultado()
            var radiano = toRadians(primeiroNumero.toDouble());
            var resultado = sin(radiano);

            Toast.makeText(this,"Resultado: " + resultado, Toast.LENGTH_LONG).show()
            operacaoFinal = Operations.SEM;
            primeiroNumero = "0"
            segundoNumero = "0"
        }
        btn_seno_inverso.setOnClickListener {
            cacularComResultado()
            //TODO: como calcula isso ?
        }

        btn_cosseno.setOnClickListener {
            cacularComResultado()
            var radiano = toRadians(primeiroNumero.toDouble());
            var resultado = cos(radiano);

            Toast.makeText(this,"Resultado: " + resultado, Toast.LENGTH_LONG).show()
            operacaoFinal = Operations.SEM;
            primeiroNumero = "0"
            segundoNumero = "0"
        }

        btn_cosseno_inverso.setOnClickListener {
            cacularComResultado()
            //TODO: como calcula isso ?
        }

        btn_tangente.setOnClickListener {
            cacularComResultado()
            var radiano = toRadians(primeiroNumero.toDouble());
            var resultado = cos(radiano);

            Toast.makeText(this,"Resultado: " + resultado, Toast.LENGTH_LONG).show()
            operacaoFinal = Operations.SEM;
            primeiroNumero = "0"
            segundoNumero = "0"
        }

        btn_tangente_inverso.setOnClickListener {
            cacularComResultado()
            //TODO: como calcula isso ?
        }

        btn_valor_inverso.setOnClickListener {
            cacularComResultado()
            var resultado = primeiroNumero.toDouble() * 1;

            Toast.makeText(this, "Resultado: " + resultado, Toast.LENGTH_LONG).show()
            operacaoFinal = Operations.SEM
            primeiroNumero = "0"
            segundoNumero = "0"
        }


        btn_equals.setOnClickListener {
            var result = resultado()
            operacaoFinal = Operations.SEM;
            primeiroNumero = "0"
            segundoNumero = "0"

            teTela.setText(resultTela(tela, " = "+ result.toString() + "\n"))

            Toast.makeText(this,"Resultado: " + result, Toast.LENGTH_LONG).show()
        }

    }

    fun numeroDigitado(number: String){
        if(operacaoFinal == Operations.SEM){
            primeiroNumero = primeiroNumero + number
        }else{
            segundoNumero = segundoNumero + number
        }
    }

    fun resultado(): Double {
        when(operacaoFinal){
            Operations.SOMA -> {
                resultadoFinal = (primeiroNumero.toDouble() + segundoNumero.toDouble())
                mostrarResultado(resultadoFinal)

            }
            Operations.SUBTRACAO -> {
                resultadoFinal = primeiroNumero.toDouble() - segundoNumero.toDouble()
                mostrarResultado(resultadoFinal)

            }
            Operations.MULTIPLICACAO -> {
                resultadoFinal = primeiroNumero.toDouble() * segundoNumero.toDouble()
                mostrarResultado(resultadoFinal)
            }
            Operations.DIVISAO -> {
                resultadoFinal = primeiroNumero.toDouble() / segundoNumero.toDouble()
                mostrarResultado(resultadoFinal)
            }
            Operations.MODULO -> {
                resultadoFinal = primeiroNumero.toDouble() % segundoNumero.toDouble()
                mostrarResultado(resultadoFinal)
            }
            Operations.POTENCIA -> {
                resultadoFinal = pow(primeiroNumero.toDouble(), segundoNumero.toDouble())
                mostrarResultado(resultadoFinal)
            }
            Operations.RAIZ -> {
                resultadoFinal = sqrt(primeiroNumero.toDouble())
                mostrarResultado(resultadoFinal)
            }
            Operations.FATORIAL -> {
                var fatorial = primeiroNumero.toDouble()
                var valor = primeiroNumero.toDouble();
                while (valor > 1){
                    fatorial = fatorial * (valor - 1)
                    valor --;
                }
                mostrarResultado(fatorial)
            }
        }

        return resultadoFinal;
    }

    fun resultTela(listaAtual: MutableList<String>, operacao: String): String {
        var retorno = "";
        if(listaAtual.size == 10){
            listaAtual.removeFirst();
        }
        if(!listaAtual.last().contains("\n")){
            listaAtual[listaAtual.size-1] = listaAtual.last() + operacao;
        }else{
            listaAtual.add(operacao)
        }


        for(x in listaAtual){
            retorno = retorno + x
        }

        return retorno;
    }

    fun mostrarResultado(resultado: Double){
        Toast.makeText(this,"Resultado: " + resultado, Toast.LENGTH_LONG).show()
        limpar()
    }

    fun cacularComResultado(){
        if(primeiroNumero == "0" && resultadoFinal != 0.0){
            primeiroNumero = resultadoFinal.toString();
            teTela.setText(resultTela(tela, primeiroNumero))
        }
    }

    fun limpar(){
        primeiroNumero = ""
        segundoNumero = ""
        operacaoFinal = Operations.SEM
    }


}