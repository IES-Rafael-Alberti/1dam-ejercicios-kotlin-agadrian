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