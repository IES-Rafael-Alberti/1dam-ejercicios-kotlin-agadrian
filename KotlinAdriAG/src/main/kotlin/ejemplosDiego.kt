/**
 * Pide un numero y muestra muestre el resultado de duplicarlo
 */
fun ejemplo1() {
    print("Introduce un numero: ")
    val num = readln().toInt() * 2

    println("El numero multiplicado por 2 es: $num")
}


/**
 * Pde un numero que lo eleva al cuadrado y evite las excepciones
 */
fun ejemplo2() {
    print("Introduce numero: ")

    val num = try {
        readln().toInt()
    }
    catch (e: NumberFormatException){
        println("**Error**: $e")
        0
    }

    print("El numero al cuadrado es ${num * num}")
}


fun ejemplo3() {
    var num: Long
    var cont = 0
    var entrada = ""

    do {
        num = 0
        print("${++cont}. Introduzca un numero")
        entrada = readln().trim()

        if (entrada.isNotEmpty()) {
            try {
                num = readln().toLong()
                if (num < 0) {
                    throw NumberFormatException("Numero no valido")
                }

                print("El numero al cuadrado es ${num * num}")
                cont++
            } catch (e: NumberFormatException) {
                println("**ERROR** numero no valido")
            }
        }


    } while (entrada.isNotEmpty())
}


// APUNTES CLASE 10/01/24

fun apuntes(){
    val miArray = arrayOf(1,2,3,4,5)
    // FOR PARA MOSTRAR DATOS SOLO
    for (num in miArray) {
        println(num)
    }

    println("----")

    // FOR PARA MODIFICAR   // indices retorna las posiciones de la lista
    for (i in miArray.indices){
        miArray[i]++
    }

    for (num in miArray) {
        println(num)
    }

    println("----")

    //for (i in 0..miArray.size){
    //    println(miArray[i])
    //}

    println("----")

    //impirimir de 2 en 2 (step)

    for (i in 0..miArray.size step 2){
        println(miArray)
    }

    println("----")

    // al reves
    for (i in (miArray.indices).reversed()) {
        println(miArray)
    }

    println("----")


    for ((i,valor) in miArray.withIndex()){
        println("${i+1} -> $valor")
    }

    println("----")

    val num = 7
    val tabla = Array<String>(11) { i -> "$i -> $i x $num = ${num * i}"}

    for (linea in tabla){
        println(linea)
    }

    //lomismo que arriba : it es por defecto
    tabla.forEach { println(it) }

    //lo mismo pero cambiando it por linea
    tabla.forEach { linea -> println(linea) }

}

fun apuntes2() {
    val numeros = arrayOf(4, 77, 8, -88, 33, -14)

    for (numero in numeros.filter { num -> num < 0 }) {
        println(numero)
    }

    (numeros.filter {  it < 0 }).forEach{ println(it) }
}

// Crear un metodo nuevo llamado holigui para la clase String. Si lo creas dentro de otra funcion, solo se puede usar en esa funcion
fun String.holigui(nombre: String){
    println("$nombre!")
}

fun apuntes3(){
    "".holigui("Diego")
}


// ejercicio clase test   (MIRAR BIEN Y ENTENDERLO)
fun apuntes4(){
    fun businessEmail(s: String): Boolean {
        return s.contains("@") && s.contains("business.com")
    }


    fun isAnEmail(email: (String) -> Boolean){
        print("Introduce un email: ")
        if (email(readln())){
            println("Email de empresa correcto")
        }
        else{
            println("Email incorrecto")
        }
    }
    isAnEmail(::businessEmail)
}
