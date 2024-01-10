import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

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
    println(nombre.lowercase().replaceFirst(nombre[0], nombre[0].uppercaseChar()))
}


fun ejercicio20(){
    print("Marque numero con el siguiente formato(+34-913724710-56): ")

    val numero : String

    try {
        numero = readln()
        if (!(numero.length == 16 && numero.startsWith("+34") && numero.endsWith("-56"))){
            throw IllegalArgumentException("Formato del numero no valido.")
        }
        if (!(numero.substring(4,13).matches(Regex("[0-9]+")))){
            throw IllegalArgumentException("No has introducido valores numericos.")
        }

        println("Su numero es ${numero.substring(4,13)}")
    }catch (e: IllegalArgumentException){
        println("**ERROR** - $e")
    }

}

fun ejercicio21() {
    print("Introduce una frase para ser mostrada al reves: ")

    try {
        val frase: String = readln()
        if (frase.isNotEmpty()){
            println(frase.reversed())
        }
        else{
            throw IllegalArgumentException("No has introducido nada")
        }
    }catch (e: IllegalArgumentException){
        println("*ERROR* - $e")
    }
    val frase = readln()

}


fun ejercicio22(){

    try {
        print("Escribe una frase: " )
        val frase: String = readln()

        println("Escribe una vocal: ")
        val vocal: String = readln()

        if (!(frase.isNotEmpty() && vocal.isNotEmpty())){
            throw IllegalArgumentException("Ta falta datos por introducir")
            }

        println("Frase final: ${frase.replace(vocal, vocal.uppercase())}")
    } catch (e: IllegalArgumentException){
        println("**ERROR** - $e")
    }

}

fun ejercicio24(){
    print("Introduce precio producto en euros y dos decimales: ")

    try {
        val precio = readln().toFloat()
        val euros = precio.toInt()
        val cents = (precio - euros) * 100

        println("El producto cuesta ${euros}€ y ${cents}cents")

    }catch (e: NumberFormatException){
        println("*ERROR* - Debes introducir numero decimal: $e")
    }
}

fun ejercicio25(){
    print("Introduce tu fecha de nacimiento en formato dd/mm/aaaa")

    try {
        val fecha: String = readln()

        if (!(fecha[2] == '/' && fecha[5] == '/' && fecha.length == 10)){
            throw IllegalArgumentException("El formato introducido no es correcto")
        }
        println("Fecha introducida: Dia ${fecha.substring(0,2)}, Mes ${fecha.substring(3,5)} Año ${fecha.substring(6)}")

    }catch (e: IllegalArgumentException){
        println("**ERROR** - $e")
    }
    catch (e: Exception){
        println("**ERROR** - $e")
    }

}

fun ejercicio26() {
    print("Introduce prodcutos de la compra separados por coma: ")

    val productos:String = readln()


    if (productos.isNotBlank() && productos.contains(",") && productos != ",") {
        val listaProductos = productos.split(",")

        for (producto in listaProductos) {
            println(producto.trim())
        }
    }
    else{
        println("Formato erroneo")
    }
}

fun ejercicio27(){
    val producto: String
    val precio: Double
    val unidades: Int


    try {
        print("Introduce producto: ")
        producto = readln()

        print("Introduce precio: ")
        precio = readln().toDouble()

        print("Introduce unidades: ")
        unidades = readln().toInt()

        val entera = String.format("%09.2f", precio)


        println("Producto: ${producto}\nPrecio: $entera€ \nUnidades: $unidades")
    }catch (e: NumberFormatException){
        println("**ERROR** - Dato introducido erroneo")
    }
}