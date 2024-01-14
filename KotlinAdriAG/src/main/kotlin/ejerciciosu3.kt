import com.sun.jdi.AbsentInformationException
import javax.sound.sampled.DataLine.Info

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
    val precioFrutas = mapOf(
        "platano" to 1.35,
        "manzana" to 0.80,
        "pera" to 0.85,
        "naranja" to 0.70
    )
    println(precioFrutas)
    println("Elige una fruta: ")
    val opc = readln()

    if (precioFrutas.containsKey(opc)){
        println("Cuantos kilos quieres: ")
        val kilos: Double = try {
            readln().toDouble()
        }catch (e: NumberFormatException){
            println("**ERR*R - $e")
            0.0
        }

        if (kilos <= 0) print("ERROR - Kilos introducidos no validos.")

        println("Has elejido $kilos de $opc. Total: ${precioFrutas[opc]!!.toDouble() * kilos}")


    } else{
        print("No existe esa fruta.")
    }

}


fun u3ejercicio005(){
    val creditos = mapOf(
        "Matematicas" to 6,
        "Fisica" to 4,
        "Quimica" to 5
    )

    for ((asignatura, credito) in creditos){
        println("La asignatura $asignatura tiene $credito creditos.")
    }

    println("Los creditos totales del curso son: ${creditos.values.sum()}")
}



fun u3ejercicio006(){
    val informacion = mutableMapOf<String, String>()
    agregarDato(informacion)

}

fun agregarDato(informacion: MutableMap<String, String>){
    println("Introduce nombre: ")
    informacion["Nombre"] = readln()
    mostrarDatos(informacion)

    println("Introduce edad: ")
    informacion["Edad"] = readln()
    mostrarDatos(informacion)

    println("Introduce telefono: ")
    informacion["Telefono"] = readln()
    mostrarDatos(informacion)

    println("Introduce sexo: ")
    informacion["Sexo"] = readln()
    mostrarDatos(informacion)

    println("Introduce correo: ")
    informacion["Correo"] = readln()
    mostrarDatos(informacion)
}

fun mostrarDatos(informacion: MutableMap<String, String>){
    println("\n**DATOS ACTUALIZADOS**")
    for ((dato, valor) in informacion){
        println("$dato : $valor")
    }
    println()
}


fun u3ejercicio007(){
    val lista = mutableMapOf<String, Double>()
    aniadirArticulos(lista)
    mostrarLista(lista)
}

fun aniadirArticulos(lista: MutableMap<String, Double>){
    do {
        println("Introduce articulo (enter para acabar): ")
        val articulo = readln()

        if (articulo != ""){
            var precio: Double
            do {
                println("Introduce precio: ")
                try {
                    precio = readln().toDouble()
                    if (precio <= 0) println("El precio debe ser positivo")

                }catch (e: NumberFormatException){
                    println("Debes introducir un valor numerico!")
                    precio = 0.0
                }
            }while (precio <= 0)

            lista[articulo] = precio
        }
    }while (articulo != "")
}

fun mostrarLista(lista: MutableMap<String, Double>){
    println("Lista de la compra: ")
    for ((item,precio) in lista){
        println("$item : $precio")
    }
    println("Total : ${lista.values.sum()}")
}


fun u3ejercicio008(){
    println("Introduce datos al diccionario con el formato:  <palabra>:<traducción>, <palabra>:<traducción>, <palabra>:<traducción>")
    val palabras = readln()
    val diccionario = crearDiccionario(palabras)

    println("Introduce una frase para traducir: ")
    val frase = readln()
    print(traducirFrase(frase, diccionario))
}

fun crearDiccionario(palabras: String): Map<String, String>{
    var lista = mutableListOf<Pair<String, String>>()

    for (palabra in palabras.split(", ")){
        val pares = palabra.split(":")
        lista.add(pares[0].trim() to pares[1].trim())
    }
    return lista.toMap()
}

fun traducirFrase(frase: String, diccionario: Map<String, String>): String{
    var palabras = frase.split(" ")
    val traducido = mutableListOf<String>()

    for (palabra in palabras){
        traducido.add(diccionario.getOrDefault(palabra, palabra))
    }

    return "Frase traducida: ${traducido.joinToString(" ")}"
}


fun u3ejercicio010(){

}

fun u3ejercicio011(){

}




fun u3ejercicio0001(){
    val lista: List<List<Any>> = listOf(
        listOf("Nuria Costa", 5, 12780.78, "Calle Las Flores 355"),
        listOf("Jorge Russo", 7, 699.0, "Mirasol 218"),
        listOf("Nuria Costa", 7, 532.90, "Calle Las Flores 355"),
        listOf("Julián Rodriguez", 12, 5715.99, "La Mancha 761"),
        listOf("Jorge Russo", 15, 958.0, "Mirasol 218")
    )

    println(" Lista domicilios: ${domiciliosClientes(lista).joinToString(", ")}}")
}

fun domiciliosClientes(lista: List<List<Any>>): Set<Any>{
    val domicilios = mutableSetOf<Any>()
    for (elemento in lista){
        domicilios.add(elemento[3])
    }
    return domicilios
}


fun u3ejercicio0002() {
    println("introduce nombres alumnos primaria: ")
    var alumnPrimaria = pedirNombre()

    println("introduce nombres alumnos secundaria: ")
    var alumSecundaria = pedirNombre()


    println("Nombres unicos: ${alumnPrimaria union alumSecundaria}")
    println("Nombres repetidos : ${alumnPrimaria intersect alumSecundaria}")
    println("Nombres de primaria y no secundaria : ${alumnPrimaria subtract alumSecundaria}")

}

fun pedirNombre(): Set<String>{
    val nombres = mutableSetOf<String>()
    do {
        println("Nombre: ")
        val nombre = readln()

        if (nombre != "x") nombres.add(nombre)
    }while (nombre != "x")

    return nombres
}

fun u3ejercicio0003(){

}

fun u3ejercicio0004(){
    val setFrutas1 = mutableSetOf("manzana", "pera", "naranja", "plátano", "uva")
    val setFrutas2 = mutableSetOf("manzana", "pera", "durazno", "sandía", "uva")

    println("Frutas unicos: ${setFrutas1 intersect  setFrutas2}")
    println("Solo en frutas1 y no frutas2 : ${setFrutas1 subtract setFrutas2}")
    println("Solo en frutas2 y no frutas1 : ${setFrutas2 subtract setFrutas1}")
}

fun u3ejercicio0005(){
    val numeros = mutableSetOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println("Multilpos de 2: ${conjuntoPares(numeros)}\nMultiplos de 3: ${conjuntoMultiplo3(numeros)}\nInterseccion de multilpos de 2 y 3: ${conjuntoPares(numeros) intersect conjuntoMultiplo3(numeros)}")
}

fun conjuntoPares(numeros: Set<Int>): Set<Int> {
    val pares = mutableSetOf<Int>()

    for (numero in numeros){
        if (numero % 2 == 0){
            pares.add(numero)
        }
    }
    return pares
}

fun conjuntoMultiplo3(numeros: Set<Int>): Set<Int>{
    val pares = mutableSetOf<Int>()

    for (numero in numeros){
        if (numero % 3 == 0){
            pares.add(numero)
        }
    }
    return pares
}

fun u3ejercicio0006(){
    val vocales = mutableSetOf('a', 'e', 'i', 'o', 'u')
    val abecedario = ('a'..'z').toSet()

    val consonantes = abecedario - vocales
    println("Consonantes: $consonantes")
    println("Letras comunes: ${vocales union  consonantes}")

}