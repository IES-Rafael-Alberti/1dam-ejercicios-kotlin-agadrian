/**
 * Se comprueba que la cadena de texto introducida coincide con otra establecida sin tener en cuennta mayus/minus. Se imprime si coincide o no
 */
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

/**
 * Se comprueba las contraseñas pasado como parametros.
 * @param contrasena String - La contraseña establecida
 * @param contrasena2 String - La contraseña que se comprueba si es igual a contrasena
 * @return bool - true/false : true si coincide, false si no
 */
fun comprobarContrasena(contrasena: String, contrasena2: String): Boolean {

    return contrasena.lowercase() == contrasena2.lowercase()
}

/**
 * Divide 2 numeros y muestra el resultado. Si el divisor es 0, lanza excepcion.
 */
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

/**
 * Imprime a que grupo (A ó B) pertenece alguien segun su nombre y sexo
 */
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

/**
 * Comprueba a que grupo pertenece alguien segun su nombre y sexo
 * @param nombre : String nombre a comprobar
 * @param sexo : String sexo a comprobar
 * @return A: si pertenece al grupo A
 *         B: si pertenece al grupo B
 *         "Sexo no valido": si el sexo introducido no es valido para su comprobacion
 */
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

/**
 * Indica el el salario que le corresponde a un empleado dependiendo de su nivel de rendimiento
 */
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

/**
 * Comprueba el nivel de rendimiento de un empleado en base a su puntuacion
 * @param puntuacion : Dobule puntuacion del empleado en cuestion
 * @return Devuelve una cadena que indica el nivel de rendimiento ("Inaceptable", "Aceptable", "Meritorio") y puntuacion
 *
 */
fun nivelRendimiento(puntuacion: Double): Pair<String?, Double> {
    return when {
        puntuacion == 0.0 -> Pair("Inaceptable", puntuacion)
        puntuacion == 0.4 -> Pair("Aceptable", puntuacion)
        puntuacion == 0.6 || puntuacion > 0.6  -> Pair("Meritorio", puntuacion)
        else -> Pair(null, puntuacion)
    }
}

/**
 * Pregunta a un usuario que tipo de piza quiere y sus ingredientes. Luego muestra los datos elejidos
 */
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

/**
 * Muestra desde 1 hasta la edad introducida
 */
fun u2ejercicio002() {
    val edad = pedirEdad()
    val listaAnos = anosCumplidos(edad)
    println(listaAnos.first() + listaAnos.drop(1).joinToString(", "))
}

/**
 * Pide la edad comrobando que este en un rango de 1-125 años
 * @return edad Int - Edad introducida por usuario
 */
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

/**
 * Crea una lista que va desde 1 hsta la edad pasada por parametro
 * @param edad Int: edad para crear la lista desde 1-edad
 * @return anos : Lista creada lista para usar
 */
fun anosCumplidos(edad: Int): List<String>{
    val anos = mutableListOf("")
    for (i in 1..edad){
        anos.add(i.toString())
    }
    return anos
}

/**
 * Pide un numero positivo entero y muestra una cuenta atras desde ese numero hata 0
 */
fun u2ejercicio004(){
    print("Introduce numero: ")
    val num = pedirIntPositivo()
    val lista = cuentaAtras(num)

    println(lista.first() + lista.drop(1).joinToString(", "))

}

/**
 * Pide por consola un numero y compprueba que sea valido, entero positivo
 * @return num Devuelve el numero introducido correctamente
 */
fun pedirIntPositivo(): Int{
    var num: Int?

    do {
        val valor = readln()
        num = valor.toIntOrNull()

        if (num == null || num < 1) println("Debes introducir un numero entero positivo: ")

    }while (num == null || num < 1)
    return num
}

/**
 * Crea una lista de numeros en cuenta atras desde un numero pasado por parametro hasta 0
 * @param numero Int: numero entero positivo
 * @return lista La lista creada correctamente
 */
fun cuentaAtras(numero: Int): List<String>{
    val lista = mutableListOf("")

    for (i in numero downTo 0){
        lista.add(i.toString())
    }
    return lista
}

/**
 * Crea un triangulo de cracteres *
 */
fun u2ejercicio006(){
    print("Introduce altura triangulo: ")
    val altura = pedirIntPositivo()
    print(crearTriangulo(altura))
}

/**
 * Crea el trinngulo de la altura pasada por parametro
 * @param altura Int - Altura desada para crear el triangulo
 * @return arbol String - Devuelve una cadena de texto que contiene el triangulo ya creado
 */
fun crearTriangulo(altura: Int): String{
    var arbol = ""
    var cont = 1

    for (i in 1..altura){
        arbol += ("*".repeat(cont)) + "\n"
        cont++
    }
    return arbol
}

/**
 * Muestra un tabla de multiplicar del numero deesado
 */
fun u2ejercicio007(){
    print("De que numero quieres hacer la tabla de multiplicar?: ")
    println(tablaMulti(pedirIntPositivo()))
}

/**
 * Crea la tabla de multiplicar del numero pasado por parametro
 * @param numero Int: numero del que se creara la tabla
 * @return tabla Str: Cadena de texto con la tabla de multiplicar y sus resultados en el interior
 */
fun tablaMulti(numero: Int):String{
    var cont = 1
    var tabla = ""

    for (i in 1..10){
        tabla += "\n$numero x $cont = ${numero*cont}"
        cont++
    }
    return tabla
}

/**
 * Muestra un triangulo rectangulo de numeros que decrecen de 2 en 2
 */
fun u2ejercicio008() {
    print("Introduce un numero entero positivo: ")
    println(trianguloRectangulo(pedirIntPositivo()))
}

/**
 * Crea un tringulo rectangulo de la altura del parametro num
 * @param num Int: altura del triangulo rectangulo
 * @return triangulo String: cadena de texto que contiene el triangulo creado
 */
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

/**
 * Muestra por pantalla lo mismo que se escribe. Se usa salir para acabar
 */
fun u2ejercicio013(){
    println("Eco de lo escrito. Para salir escriba 'salir': ")
    var texto: String
    do {
        texto = readln()

        if (texto != "salir") println(texto) else println("Adioos!")
    } while (texto != "salir")
}

/**
 * Muestra la suma de los numeros introducidos
 */
fun u2ejercicio015(){
    val suma = sumaNumeros()
    println("La suma total es $suma")
}

/**
 * Pide un numero y compruba que sea positivo
 * @return num Int: devuelve el numero introducido
 */
fun pedirInt(): Int{
    var num: Int?

    do {
        val valor = readln()
        num = valor.toIntOrNull()

        if (num == null) println("Debes introducir un numero entero positivo: ")

    }while (num == null)
    return num
}

/**
 * Suma todos los numeros introducidos hasta que se introduce 0 y se para
 * @return suma Int: Resultado de la suma de los numeros
 */
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

/**
 * Pide y muestra la suma de los digitos que componen cada numero introducido. Deben ser ints positivos
 */
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

/**
 * Calcula la suma de los digitos que componen un numero
 * @param num Int: numero para operar
 * @return suma Int: el resultado de la suma de los digito de un numero
 */
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

/**
 * Muestra un menu con 3 opciones y pide elejir una. Al elegirla, redirige a otra funcion
 */
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

/**
 * Muestra las opciones del menu principal
 */
fun mostrarMenu(){
    println("\n1 - Introduzca una nota")
    println("2 - Imprimir listado")
    println("3 - Finalizar programa")
}

/**
 * Pide una opcion de las posiblesy comprueba que es valida haciendo un checkeo del rango de opciones
 * @return opc Int: opcion elejida
 */
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

/**
 * Pide que se introduzca una nota y las almacenas en un lista
 * @param notas MutableList: lista de notas para almacenarlas
 */
fun introducirNota(notas: MutableList<String> ){
    print("Introduce una nota: ")
    val nota = readln()
    notas.add(nota)
    print("Se ha introducido la nota $nota\n")
}

/**
 * Imprime el listado de notas solo si existe, si no muedtra un mensaje de que no hay notas
 */
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

/**
 *Muestra la palabra mas larga de una frase introducida
 */
fun u2ejercicio025(){
    println("Introduce frase: ")
    val frase = readln()
    val listaPalabras = dividirFrase(frase)
    println("La palabra mas larga ha sido ${palabraLarga(listaPalabras)} y habian ${contarPalabras(listaPalabras)} palabras")
}

/**
 * Divide la frase introducida mediante espacios
 * @param frase String: la frase a dividir
 * @return frase: List<string> - la frase dividida
 */
fun dividirFrase(frase: String): List<String>{
    return frase.split(" ")
}

/**
 * Cuenta las palabras que hay en una lista de palabras
 *
 */
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