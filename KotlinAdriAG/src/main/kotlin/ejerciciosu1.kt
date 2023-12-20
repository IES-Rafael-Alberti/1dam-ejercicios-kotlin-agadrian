fun ejercicio04() {
    /**
     * Pide los grados en celsius y los convierte a Farenheits
     */

    print("Introduce grados Celsius: ")

    val num: Double? = try {
        readln().toDouble()
    } catch (e: NumberFormatException) {
        println("**ERROR**: $e")
        println("Debes introducir un valor numerico")
        null
    }

    if (num != null) {
        print("Grados Faranheit: ${(num * 9 / 5) + 32}")
    }
}


/**
 *
 */
fun ejercicio06() {
    println("Introduce importe final: ")

    val importeFinal: Float? =
        try {
            readln().toFloat()
        } catch (e: NumberFormatException) {
            println("**ERROR** - $e")
            println("Debes introducir un valor numerico")
            null
        } catch (e: Exception) {
            println("**ERROR INESPERADO: ** $e")
            null
        }

    if (importeFinal != null) {
        val sinIva = importeFinal / 1.10
        val ivaPagado = importeFinal - sinIva
        println("Precio sin iva: $sinIva \nIva pagado: $ivaPagado")
    }
}


fun ejercicio12() {
    var peso = 0.0
    var estatura = 0.0

    try {
        print("Introduce peso en kg: ")
        peso = readln().toDouble()
        if (peso < 0 || peso > 200) {
            throw IllegalArgumentException("Peso no real")
        }

        print("Introduce estatura en metros: ")
        estatura = readln().toDouble()
        if (estatura < 0 || estatura > 3) {
            throw IllegalArgumentException("Estatura no real")
        }
    } catch (e: NumberFormatException) {
        println("**ERROR - Introduce un valor numerico: **: $e")

    } catch (e: IllegalArgumentException) {
        println("**ERROR - $e")
    } catch (e: Exception) {
        println("**ERROR INESPERADO: $e**")
    }

    if (peso != 0.0 && estatura != 0.0) {
        val imc = peso / (estatura * estatura)
        println("Tu IMC es: ${String.format("%.3f", imc)}")
    }
}

fun ejercicio15() {

    println("Introduce cantidad deposito:")

    val capital: Float? = try {
        readln().toFloat()

    } catch (e: NumberFormatException) {
        println("** ERROR - Debes introducir un valor numerico **: $e")
        null
    } catch (e: Exception) {
        println("**ERROR INESPERADO ** - $e")
        null
    }

    if (capital != null) {
        val ahorro = (capital * (1.04)) - capital
        println("Ahorro 1er año: $ahorro \nAhorro 2do año: ${ahorro * 2}\nAhorro 3er año: ${ahorro * 3}")

    }
}


fun ejercicio18() {
    print("Introduce tu nombre: ")
    val nombre = readln()

    println(nombre.lowercase())
    println(nombre.uppercase())
    println(nombre.replaceFirst(nombre[0], nombre[0].uppercaseChar()))
}

