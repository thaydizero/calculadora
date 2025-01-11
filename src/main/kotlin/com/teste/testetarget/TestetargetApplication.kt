package com.teste.testetarget

import org.json.JSONArray
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class testetarget

fun somaIndice() {
	val indice = 13
	var soma = 0
	var k = 0

	while (k < indice) {
		k++
		soma += k
	}
	println("Valor final de soma: $soma")
}


fun verificaFibonacci(i: Int) {
	val numero = 21
	var a = 0
	var b = 1

	while (b < numero) {
		val temp = b
		b = a + b
		a = temp
	}

	if (b == numero || numero == 0) {
		println("$numero pertence à sequência")
	} else {
		println("$numero não pertence à sequência")
	}
}



fun analisaFaturamento() {
	val jsonFaturamento = """
        [100.0, 200.0, 0.0, 300.0, 150.0, 0.0, 400.0]
    """
	val faturamento = JSONArray(jsonFaturamento)
	val valores = mutableListOf<Double>()

	for (i in 0 until faturamento.length()) {
		val valor = faturamento.getDouble(i)
		if (valor > 0) valores.add(valor)
	}

	val menorValor = valores.minOrNull() ?: 0.0
	val maiorValor = valores.maxOrNull() ?: 0.0
	val mediaMensal = valores.average()

	val diasAcimaDaMedia = valores.count { it > mediaMensal }

	println("Menor valor de faturamento: R$$menorValor")
	println("Maior valor de faturamento: R$$maiorValor")
	println("Dias com faturamento acima da média: $diasAcimaDaMedia")
}

fun main() {

	println("Executando Soma Indice:")
	somaIndice()

	println("\nExecutando Verificação Fibonacci:")
	verificaFibonacci(21)

	println("\nExecutando Analisa de Faturamento:")
	analisaFaturamento()
}