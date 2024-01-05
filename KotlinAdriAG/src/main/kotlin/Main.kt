fun main () {
    //HACER MENU CON LAS OPCIONES
/**
    var opc: Int
    do {
        mostrarMenuPrincipal()
        opc = pedirOpcion(0,3)

        when (opc) {
            1 -> {
                menu
            }

            2 -> {

            }

            3 -> {

            }
        }
    }
**/

    //EJERCICIOS UNIDAD 1    DOCUMENTAR LAS FUNCIONES
    //ejemplo03()
    //ejercicio04()
    //ejercicio06()
    //ejercicio12()
    //ejercicio15()
    //ejercicio18()
    //ejercicio20()
    //ejercicio21()
    //ejercicio22()
    //ejercicio24() //mejorar redondeo de los cents a 2 decimales
    //ejercicio25() // comprobar que se iontroduce  numeros en la fecha y no letras
    //ejercicio26()
    //ejercicio27() // preguntar como HACER QUE LA PARTE ENTERA MUESTRE EXCATAMENTE LOS 6 DIGITOS CUANDO SE INTRODUCE MAS DE 6. (AL INTRODUCIR MENOS DE 6 SI SALE BIEN, SE RELLENA CON 0)



    //EJERCICIOS UNIDAD 2


}


/**
fun mostrarMenuPrincipal () {
    println("1. Ejericios UNIDAD 1")
    println("2. Ejericios UNIDAD 2")
    println("3. Ejericios UNIDAD 3")
}

fun mostrarMenu(tipo: Int) {
    when (tipo) {
        1 -> {
            println("Ejericio 04")
            println("Ejericio 06")
            println("Ejericio 12")
            pedirOpcion(0,5) //en el 5 poner el maximo de ejercciios que hay en la U1
        }

        2 -> {
            println("Ejericio 03")
            println("Ejericio 06")
            println("Ejericio 08")
            println("Ejericio 10")
        }

        3 -> {
            println("Ejericio 04")
            println("Ejericio 10")
            println("Ejericio xx")
        }

    }
}

/**
 * Pedir una opcion del menu
 * @param min: Int - Valor minimo de la opcion
 * @param max: Inr - Valor maximo de la opcion
 */
fun pedirOpcion(min: Int, max: Int) : Int{
    var opcion: Int

    do {
        print("Seleccione la opcion (0 = SALIR) >>")

        opcion = try {
            readln().toInt()
        } catch (e: NumberFormatException) {
            println("**OPCION NO VALIDA**")
            -1
        }

        if (opcion !in min..max) {
            println("OPCION NO VALIDA")
        }
    } while (opcion !in min..max)

    return opcion
}
**/