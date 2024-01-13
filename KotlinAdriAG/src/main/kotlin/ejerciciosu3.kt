
fun u3ejercicio04(){
    val listaNumeros = mutableListOf<Int>()
    println("Introduce numeros primitiva: ")
    listarNumeros(listaNumeros)

    println("Numeros primitiva: ${listaNumeros.first()}, ${listaNumeros.drop(1).joinToString(", ")} - Reintegro: ${pedirReintegro()}")

}


fun listarNumeros(listaNumeros: MutableList<Int>){
    while (listaNumeros.size < 6){
        val num = pedirIntPositivo()
        if (num in 1..49){
            listaNumeros.add(num)
        }
        else print("Numero ha de estar entre 1-49")
    }
}

fun pedirReintegro(): Int{
    print("Introduce reintegro: ")
    var reint: Int
    do {
        reint = pedirInt()
        if (reint !in 1..9){
            println("Debe ser un numero enntero 1-9!: ")
        }
    } while (reint !in 1..9)
    return reint
}



fun u3ejercicio06(){
    print("Cuantas asignaturas vas a introducir?: ")
    val numAsig = pedirIntPositivo()

    print(pedirNota(pedirAsig(numAsig)))
}

fun pedirAsig(numAsig: Int): MutableList<List<String>>{
    val listaAsig = mutableListOf<List<String>>()
    do {
        print("Introduce nombre asignatura: ")
        listaAsig.add(listOf(readln()))
    } while (listaAsig.size < numAsig)
    return listaAsig
}

fun pedirNota(listaAsig: MutableList<List<String>>): MutableList<List<String>>{
    var nota: String
    for (i in listaAsig.indices){
        print("Introduce nota de ${listaAsig[i]}: ")
        nota = readln()
        listaAsig[i] = listaAsig[i] + nota
    }
    return listaAsig
}


fun u3ejercicio08(){
    print("Introduce palabra a comprobar si es palindromo: ")
    val palabra = readln()

    if (palabra == palabra.reversed()){
        print("Es palindromo")
    }
    else {
        println("No es palindromo")
    }
}


fun u3ejercicio09(){
    print("Introduce palabra para contar sus vocales: ")
    val palabra = readln()
    print(contarVocales(palabra))

}

fun contarVocales(palabra: String): MutableList<MutableList<Any>> {
    val lista: MutableList<MutableList<Any>> = mutableListOf( mutableListOf("a", 0), mutableListOf("e",0), mutableListOf("i", 0), mutableListOf("o",0), mutableListOf("u", 0) )


    for (vocal in lista){
        vocal[1] = palabra.count() {it.toString() == vocal[0]} // itera sobre la palabra, y va contando a medida que la condicion  entre llaves se cumple. it toma cada valor del string "h" "o" "l" "a" y lo compara con vocal[0]
    }

    return lista
}



fun u3ejercicio10(){
    val lista = listOf(50, 75, 46, 22, 80, 65, 8)

    println("Numero maximo: ${lista.max()} Numero minimo: ${lista.min()}")
}

fun u3ejercicio13(){
    println("Introduce una serie de numeros separados por coma: ")
    val numeros = readln().split(",").map { it.toDouble() } // el it le hace el todouble a cada numero
    println(numeros.sum() / numeros.count())
}

fun u3ejercicio003(){
    
}