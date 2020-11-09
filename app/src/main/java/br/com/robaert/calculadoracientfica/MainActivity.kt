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


        tvNumero0.setOnClickListener{
            if(operacaoFinal == Operations.SEM){
                primeiroNumero = primeiroNumero + "0"
            }else{
                segundoNumero = segundoNumero + "0"
            }
            teTela.setText(resultTela(tela, "0"))
        }
        tvNumero1.setOnClickListener{
            if(operacaoFinal == Operations.SEM){
                primeiroNumero = primeiroNumero + "1"
            }else{
                segundoNumero = segundoNumero + "1"
            }
            teTela.setText(resultTela(tela, "1"))
        }

        tvNumero2.setOnClickListener{
            if(operacaoFinal == Operations.SEM){
                primeiroNumero = primeiroNumero + "2"
            }else{
                segundoNumero = segundoNumero + "2"
            }

            teTela.setText(resultTela(tela, "2"))
        }
        tvNumero3.setOnClickListener{
            if(operacaoFinal == Operations.SEM){
                primeiroNumero = primeiroNumero + "3"
            }else{
                segundoNumero = segundoNumero + "3"
            }
            teTela.setText(resultTela(tela, "3"))
        }
        tvNumero4.setOnClickListener{
            if(operacaoFinal == Operations.SEM){
                primeiroNumero = primeiroNumero + "4"
            }else{
                segundoNumero = segundoNumero + "4"
            }
            teTela.setText(resultTela(tela, "4"))
        }
        tvNumero5.setOnClickListener{
            if(operacaoFinal == Operations.SEM){
                primeiroNumero = primeiroNumero + "5"
            }else{
                segundoNumero = segundoNumero + "5"
            }
            teTela.setText(resultTela(tela, "5"))
        }
        tvNumero6.setOnClickListener{
            if(operacaoFinal == Operations.SEM){
                primeiroNumero = primeiroNumero + "6"
            }else{
                segundoNumero = segundoNumero + "6"
            }
            teTela.setText(resultTela(tela, "6"))
        }
        tvNumero7.setOnClickListener{
            if(operacaoFinal == Operations.SEM){
                primeiroNumero = primeiroNumero + "7"
            }else{
                segundoNumero = segundoNumero + "7"
            }
            teTela.setText(resultTela(tela, "7"))
        }
        tvNumero8.setOnClickListener{
            if(operacaoFinal == Operations.SEM){
                primeiroNumero = primeiroNumero + "8"
            }else{
                segundoNumero = segundoNumero + "8"
            }
            teTela.setText(resultTela(tela, "8"))
        }
        tvNumero9.setOnClickListener{
            if(operacaoFinal == Operations.SEM){
                primeiroNumero = primeiroNumero + "9"
            }else{
                segundoNumero = segundoNumero + "9"
            }
            teTela.setText(resultTela(tela, "9"))
        }
        tvPonto.setOnClickListener{
            if(operacaoFinal == Operations.SEM){
                primeiroNumero = primeiroNumero + "."
            }else{
                segundoNumero = segundoNumero + "."
            }
            teTela.setText(resultTela(tela, "."))
        }

        tvSoma.setOnClickListener{
            cacularComResultado()

            operacaoFinal = Operations.SOMA
            teTela.setText(resultTela(tela, "+"))
        }

        tvSubtracao.setOnClickListener {
            cacularComResultado()
            operacaoFinal = Operations.SUBTRACAO
            teTela.setText(resultTela(tela, "-"))
        }
        tvDivisao.setOnClickListener {
            cacularComResultado()
            operacaoFinal = Operations.DIVISAO
            teTela.setText(resultTela(tela, "/"))
        }
        tvMultiplicao.setOnClickListener {
            cacularComResultado()
            operacaoFinal = Operations.MULTIPLICACAO
            teTela.setText(resultTela(tela, "x"))
        }

        tvRaiz.setOnClickListener {
            cacularComResultado()
            operacaoFinal = Operations.RAIZ
            teTela.setText(resultTela(tela, "RAIZ"))
            resultado()
        }

        tvMod.setOnClickListener {
            cacularComResultado()
            teTela.setText(resultTela(tela, "MOD"))
            operacaoFinal = Operations.MODULO
            resultado()
        }

        tvFatorial.setOnClickListener {
            cacularComResultado()
            operacaoFinal = Operations.FATORIAL
            teTela.setText(resultTela(tela, "FAT"))
            resultado()
        }

        tvPotencia.setOnClickListener {
            cacularComResultado()
            operacaoFinal = Operations.POTENCIA
            teTela.setText(resultTela(tela, ""))
        }

        tvQuadrado.setOnClickListener {
            cacularComResultado()
            operacaoFinal = Operations.QUADRADO
            teTela.setText(resultTela(tela, " ^ 2"))
            resultado()

        }

        tvInverterSinal.setOnClickListener {
            cacularComResultado()
            // vai pegar o ultimo valor exibido e inverter o sinal
            // se for + vira -
            // se for - vira +
        }

        tvLog.setOnClickListener {
            cacularComResultado()
            operacaoFinal = Operations.LOG
            teTela.setText(resultTela(tela, "LOG"))
            resultado()
        }

        tvLogNatural.setOnClickListener {
            cacularComResultado()
            operacaoFinal = Operations.LOGNATURAL
            teTela.setText(resultTela(tela, "LN"))
            resultado()

        }

        tvSeno.setOnClickListener {
            cacularComResultado()
            operacaoFinal = Operations.SENO
            teTela.setText(resultTela(tela, "SENO"))
            resultado()
        }
        tvInversoSeno.setOnClickListener {
            cacularComResultado()
            //TODO: como calcula isso ?
        }

        tvCos.setOnClickListener {
            cacularComResultado()
            operacaoFinal = Operations.COSENO
            teTela.setText(resultTela(tela, "COSSENO"))
            resultado()
        }

        tvInversoCos.setOnClickListener {
            cacularComResultado()
            //TODO: como calcula isso ?
        }

        tvTangente.setOnClickListener {
            cacularComResultado()
            operacaoFinal = Operations.TANGENTE
            teTela.setText(resultTela(tela, "TANGENTE"))
            resultado()
        }

        tvInversoTangente.setOnClickListener {
            cacularComResultado()
            //TODO: como calcula isso ?
        }

        tvInverso.setOnClickListener {
            cacularComResultado()
            var resultado = primeiroNumero.toDouble() * 1;

            Toast.makeText(this, "Resultado: " + resultado, Toast.LENGTH_LONG).show()
            operacaoFinal = Operations.SEM
            primeiroNumero = "0"
            segundoNumero = "0"
        }


        tvIgual.setOnClickListener {
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
                resultadoFinal = primeiroNumero.toDouble()
                var valor = primeiroNumero.toDouble();
                while (valor > 1){
                    resultadoFinal = resultadoFinal * (valor - 1)
                    valor --;
                }
                mostrarResultado(resultadoFinal)
            }
            Operations.QUADRADO -> {
                resultadoFinal = pow(primeiroNumero.toDouble(), 2.0)
                mostrarResultado(resultadoFinal)
            }
            Operations.LOG -> {
                 resultadoFinal = log10(primeiroNumero.toDouble());
                mostrarResultado(resultadoFinal)
            }
            Operations.LOGNATURAL -> {
                resultadoFinal = log(primeiroNumero.toDouble());
                mostrarResultado(resultadoFinal)
            }
            Operations.SENO -> {
                var radiano = toRadians(primeiroNumero.toDouble());
                resultadoFinal = sin(radiano);
                mostrarResultado(resultadoFinal)
            }
            Operations.COSENO -> {
                var radiano = toRadians(primeiroNumero.toDouble());
                resultadoFinal = cos(radiano);
                mostrarResultado(resultadoFinal)
            }
            Operations.TANGENTE -> {
                var radiano = toRadians(primeiroNumero.toDouble());
                resultadoFinal = cos(radiano);
                mostrarResultado(resultadoFinal)
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