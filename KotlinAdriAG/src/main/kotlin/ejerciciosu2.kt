
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