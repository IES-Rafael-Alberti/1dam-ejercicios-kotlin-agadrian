
fun u2ejercicio02() {
    val contrasena = "p4ssw0rd"
    print("Intorduce contraseña: ")
    val contrasena2 = readln().toString()

    if (comprobarContrasena(contrasena, contrasena2)) {
        println("Las contraseña coinciden")
    }
    else{
        println("Las contraseñas no coincden")
    }
}

fun comprobarContrasena(contrasena: String, contrasena2: String): Boolean {

    return contrasena.lowercase() == contrasena2.lowercase()
}


fun u2ejercicio03() {
    print("Introduce numero: ")
    val n1 = readln()

    print("Introduce otro numero: ")
    val n2 = readln()

    if (comprobarNumerico(n1) && comprobarNumerico(n2)){
        try {
            val divisor = n2.toDouble()
            if (divisor != 0.0){
                val resultado = n1.toDouble() / divisor
                println("El resultado de la division de $n1 y $n2 es: ${String.format("%.4f", resultado)}")
            }
            else{
                throw ArithmeticException("El dividendo no puede ser 0!!!!")
            }

        } catch (e: ArithmeticException){
            println("**ERROR** -  $e")
        }
        catch (e: Exception){
            println("*ERROR* - $e")
        }

    }
    else{
        println("ERROR - Debes initroducir valores numericos")
    }
}

/**
 * Funcion que devuelve true si es numerico o false si no lo es
 * @param num String: cadena a comprobar si es numerico
 * @return true/false dependiendo de si es numerico  o no
 */
fun comprobarNumerico(num: String): Boolean {
    return num.toDoubleOrNull() != null
}


fun u2ejercicio06(){

    print("Introduce nombre: ")
    val nombre = readln()
    print("Introduce sexo (m/f): ")
    val sexo = readln()

    val grupo = grupoCorrespondiente(nombre, sexo)

    if (grupo !in setOf("A","B")){
        print(grupo)
    }
    else{
        print("Te llamas $nombre y perteneces al grupo $grupo")
    }
}

fun grupoCorrespondiente(nombre: String, sexo: String): String{
    if (sexo.lowercase() == "f"){
        return if (nombre.lowercase() < "m") "A" else "B"
    }
    else if (sexo.lowercase() == "m"){
        return if (nombre.lowercase() > "n") "A" else "B"
    }
    else{
        return "Sexo no valido"
    }
}


fun u2ejercicio08(){
    print("Puntuacion del usuario (0.0, 0.4, 0.6, >0.6): ")

    try {
        val puntuacion = readln().toDouble()
        val nivelPuntuacion = nivelRendimiento(puntuacion)

        if (nivelPuntuacion.first != null){
            val dinero = nivelPuntuacion.second.toDouble() * 2400
            print("Tu nivel de rendimiento es ${nivelPuntuacion.first} y tu dinero correspondiente es de $dinero€")
        }
        else{
            print("Puntuacion introducida no valida")
        }

    }catch (e: NumberFormatException){
        println("**ERROR** - Debes introducir valor numerico: $e")
    }
    catch (e: Exception){
        println("**ERROR** - $e")
    }
}

fun nivelRendimiento(puntuacion: Double): Pair<String?, Double> {
    return when {
        puntuacion == 0.0 -> Pair("Inaceptable", puntuacion)
        puntuacion == 0.4 -> Pair("Aceptable", puntuacion)
        puntuacion == 0.6 || puntuacion > 0.6  -> Pair("Meritorio", puntuacion)
        else -> Pair(null, puntuacion)
    }
}

fun u2ejercicio10() {
    val ingredientesVeg = listOf("pimiento","tofu")
    val ingredientesNoVeg = listOf("peperoni","jamón","salmón")
    val ingredientesElejidos = mutableListOf("tomate","mozarela")

    print("Quieres pizza vegetariana?: ")
    val eleccion = eleccionPizza() // true/false

    if (eleccion){
        ingredientesElejidos.add(eleccionIngredientes(ingredientesVeg))

    }else{
        ingredientesElejidos.add(eleccionIngredientes(ingredientesNoVeg))
    }
    print("Has elegido una piza ${if (eleccion) "Vegana" else "No vegana"} con los siguientes ingredientes: ${ingredientesElejidos.joinToString(", ")} ")

}

/**
 * Pregunta si quiere piza vegana o no
 * @return true/false
 */
fun eleccionPizza(): Boolean {
    var eleccion: String
    do {
        eleccion = readln()
        if (eleccion !in setOf("si","no")){
            println("Debes introducir si/no")
        }
    }
    while (eleccion !in setOf("si","no"))
    return eleccion == "si" // True si es "si" False si no lo es
}

/**
 * Elije el ingrediente deseado de la lista de ingredientes
 * @param ingredientes Lista de ingredientes previamente creada
 * @return opc: String - El ingrediente elejido
 */
fun eleccionIngredientes(ingredientes: List<String>): String{
    print("Elija un solo ingrediente de los siguientes: $ingredientes: ")
    var opc: String
    do {
        opc = readln()
        if (opc !in ingredientes){
            println("Debes elejir un ingrediente de la lista!!")
        }
    }
    while (opc !in ingredientes)
    return opc
}


fun u2ejercicio002() {
    val edad = pedirEdad()
    val listaAnos = anosCumplidos(edad)
    println(listaAnos.first() + listaAnos.drop(1).joinToString(", "))
}


fun pedirEdad(): Int {
    var edad: Int
    do{
        print("Introduce edad (1/125): ")
        val intr = readln()
        edad = try {
            intr.toInt()
        } catch (e: NumberFormatException){
            0
        }
        if (edad !in 1..125) println("Introduce un entero en el rango 1/125!")

    }while (edad !in 1..125)
    return edad
}

fun anosCumplidos(edad: Int): List<String>{
    val anos = mutableListOf("")
    for (i in 1..edad){
        anos.add(i.toString())
    }
    return anos
}


fun u2ejercicio004(){
    print("Introduce numero: ")
    val num = pedirIntPositivo()
    val lista = cuentaAtras(num)

    println(lista.first() + lista.drop(1).joinToString(", "))

}

fun pedirIntPositivo(): Int{
    var num: Int?

    do {
        val valor = readln()
        num = valor.toIntOrNull()

        if (num == null || num < 1) println("Debes introducir un numero entero positivo: ")

    }while (num == null || num < 1)
    return num
}

fun cuentaAtras(numero: Int): List<String>{
    val lista = mutableListOf("")

    for (i in numero downTo 0){
        lista.add(i.toString())
    }
    return lista
}


fun u2ejercicio006(){
    print("Introduce altura triangulo: ")
    val altura = pedirIntPositivo()
    print(crearTriangulo(altura))
}

fun crearTriangulo(altura: Int): String{
    var arbol = ""
    var cont = 1

    for (i in 1..altura){
        arbol += ("*".repeat(cont)) + "\n"
        cont++
    }
    return arbol
}


fun u2ejercicio007(){
    print("De que numero quieres hacer la tabla de multiplicar?: ")
    println(tablaMulti(pedirIntPositivo()))
}

fun tablaMulti(numero: Int):String{
    var cont = 1
    var tabla = ""

    for (i in 1..10){
        tabla += "\n$numero x $cont = ${numero*cont}"
        cont++
    }
    return tabla
}


fun u2ejercicio008() {
    print("Introduce un numero entero positivo: ")
    println(trianguloRectangulo(pedirIntPositivo()))
}

fun trianguloRectangulo(num: Int):String{
    var triangulo = ""

    for (i in 1..num*2 step 2){
        for (j in i downTo 0 step 2){
            triangulo+= "$j "
        }
        triangulo+= "\n"
    }

    return triangulo
}

fun u2ejercicio013(){
    println("Eco de lo escrito. Para salir escriba 'salir': ")
    var texto: String
    do {
        texto = readln()

        if (texto != "salir") println(texto) else println("Adioos!")
    } while (texto != "salir")
}


fun u2ejercicio015(){
    val suma = sumaNumeros()
    println("La suma total es $suma")
}

fun pedirInt(): Int{
    var num: Int?

    do {
        val valor = readln()
        num = valor.toIntOrNull()

        if (num == null) println("Debes introducir un numero entero positivo: ")

    }while (num == null)
    return num
}

fun sumaNumeros(): Int{
    val lista = mutableListOf<Int>()
    println("Introduce numeros a sumar (0 para salir): ")
    do {
        val num = pedirInt()
        lista.add(num)

    } while (num != 0)

    val suma = lista.sum()
    return suma
}


fun u2ejercicio018(){
    var cont = 0
    do {
        print("Introduce un numero entero positivo. -1 para acabar: ")
        val numero = pedirInt()
        if (numero < 0 && numero != -1){
            println("Debes introducir un numero entero positivo.")
        }
        else{
            println("La suma de digitos del numero introducido es: ${sumaDigitos(numero)}")
            if ((numero % 2) == 0) cont++
        }

    }while (numero != -1)
    println("Cantidad de numeros pares introducida: $cont")

}

fun sumaDigitos(num: Int): Int{
    var suma = 0
    var numero = num

    while (numero != 0){
        val lastNum = numero % 10
        suma+= lastNum

        numero /= 10
    }
    return suma
}




fun u2ejercicio019(){
    val notas = mutableListOf<String>()
    do {
        mostrarMenu()
        val opc = pedirOpcion()


        when (opc){
            1 -> introducirNota(notas)
            2-> imprimirListado(notas)
        }
    }while (opc != 3)

}

fun mostrarMenu(){
    println("\n1 - Introduzca una nota")
    println("2 - Imprimir listado")
    println("3 - Finalizar programa")
}

fun pedirOpcion(): Int{
    var opc: Int

    do {
        print("Seleccione una opcion: ")

        opc = try {
            readln().toInt()
        } catch (e: NumberFormatException){
            println("Opcion no valida.")
            -1
        }

        if (opc !in 1..3) println("Opcion no valida.")

    } while (opc !in 1..3)
    return opc
}

fun introducirNota(notas: MutableList<String> ){
    print("Introduce una nota: ")
    val nota = readln()
    notas.add(nota)
    print("Se ha introducido la nota $nota\n")
}

fun imprimirListado(notas: MutableList<String> ){
    if (notas.isNotEmpty()){
        println("Lista de notas: ")
        for (i in notas){
            println("- $i")
        }
    }
    else{
        println("No hay nota para mostrar.")
    }
}


fun u2ejercicio025(){
    println("Introduce frase: ")
    val frase = readln()
    val listaPalabras = dividirFrase(frase)
    println("La palabra mas larga ha sido ${palabraLarga(listaPalabras)} y habian ${contarPalabras(listaPalabras)} palabras")



}

fun dividirFrase(frase: String): List<String>{
    return frase.split(" ")
}

fun contarPalabras(frase: List<String>):Int{
    return frase.count()
}

fun palabraLarga(frase: List<String>):String? {
    return frase.maxByOrNull { it.length }
}



//Escribir un programa que pida al usuario un número entero positivo y muestre por pantalla todos los números impares desde 1 hasta ese número separados por comas.
fun u2ejercicio0002(){
    print("Introduce un un numero entero positivo: ")
    val num = pedirIntPositivo()
    var primer = true
    for (i in 1..num){
        if ((i % 2) != 0){
            if (!primer){
                print(", ")
            }
            print(i)
            primer = false
        }
    }
}


// Escribir un programa que pida al usuario un número entero positivo y muestre por pantalla la cuenta atrás desde ese número hasta cero separados por comas. Deberá solicitar el número hasta introducir uno correcto.
fun u2ejercicio0003(){
    val num = pedirIntPositivo()
    var primer = true
    for (i in num downTo 0){
        if (!primer){
            print(", ")
        }
        print(i)
        primer = false
    }
}

// Escribir un programa que pida al usuario un número entero, si la entrada no es correcta, mostrará el mensaje "La entrada no es correcta" y lanzará la excepción capturada.
fun u2ejercicio0004(){
    print("Introduce un numero entero: ")
    val num = try {
        readln().toInt()
    } catch (e: NumberFormatException){
        println("La entrada no es correcta: $e")
    }
    print(num)
}