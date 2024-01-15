fun main () {
    //HACER MENU CON LAS OPCIONES
    u3ejercicio0001v2()
    var opc: Int
    do {
        mostrarMenuPrincipal()
        opc = pedirOpcion(0,3)

        when (opc) {
            1 -> {
                mostrarMenu(1)
            }

            2 -> {
                mostrarMenu(2)
            }

            3 -> {
                mostrarMenu(3)
            }
        }
    }while (opc != 0)

}



fun mostrarMenuPrincipal () {
    println("\n1. Ejericios UNIDAD 1")
    println("2. Ejericios UNIDAD 2")
    println("3. Ejericios UNIDAD 3")
}


fun ejecutarEj(unidad: Int, ejercicio: Int){
    when (unidad){
        1 -> when (ejercicio){
            1 -> ejercicio04()
            2 -> ejercicio06()
            3 -> ejercicio12()
            4 -> ejercicio15()
            5 -> ejercicio18()
            6 -> ejercicio20()
            7 -> ejercicio21()
            8 -> ejercicio22()
            9 -> ejercicio24()
            10 -> ejercicio25()
            11 -> ejercicio26()
            12 -> ejercicio27()
        }

        2 -> when (ejercicio){
            1 -> u2ejercicio02()
            2 -> u2ejercicio03()
            3 -> u2ejercicio06()
            4 -> u2ejercicio08()
            5 -> u2ejercicio10()
            6 -> u2ejercicio002()
            7 -> u2ejercicio004()
            8 -> u2ejercicio006()
            9 -> u2ejercicio007()
            10 -> u2ejercicio008()
            11 -> u2ejercicio013()
            12 -> u2ejercicio015()
            13 -> u2ejercicio018()
            14 -> u2ejercicio019()
            15 -> u2ejercicio025()
            16 -> u2ejercicio0002()
            17 -> u2ejercicio0003()
            18 -> u2ejercicio0004()
        }

        3 -> when (ejercicio){
            1 -> u3ejercicio04()
            2 -> u3ejercicio06()
            3 -> u3ejercicio08()
            4 -> u3ejercicio09()
            5 -> u3ejercicio10()
            6 -> u3ejercicio13()

            7 -> u3ejercicio003()
            8 -> u3ejercicio005()
            9 -> u3ejercicio006()
            10 -> u3ejercicio007()
            11 -> u3ejercicio008()
            12 -> u3ejercicio010()
            13 -> u3ejercicio011()

            14 -> u3ejercicio0001()
            15 -> u3ejercicio0002()
            16 -> u3ejercicio0003()
            17 -> u3ejercicio0004()
            18 -> u3ejercicio0005()
            19 -> u3ejercicio0006()
        }
    }
}
fun mostrarMenu(tipo: Int) {
    when (tipo) {
        1 -> {
            println("\n1. Ejercicio 04")
            println("2. Ejercicio 06")
            println("3. Ejercicio 12")
            println("4. Ejercicio 15")
            println("5. Ejercicio 18")
            println("6. Ejercicio 20")
            println("7. Ejercicio 21")
            println("8. Ejercicio 22")
            println("9. Ejercicio 24")
            println("10. Ejercicio 25")
            println("11. Ejercicio 26")
            println("12. Ejercicio 27")
            val opc = pedirOpcion(0,12) //en el 5 poner el maximo de ejercciios que hay en la U1
            ejecutarEj(1,opc)
        }

        2 -> {
            println("\nCONDICIONALES")
            println("1. Ejercicio 02()")
            println("2. Ejercicio 03()")
            println("3. Ejercicio 06()")
            println("4. Ejercicio 08()")
            println("5. Ejercicio 10()")
            println("\nITERATIVAS")
            println("6. Ejercicio 02()")
            println("7. Ejercicio 04()")
            println("8. Ejercicio 06()")
            println("9. Ejercicio 07()")
            println("10. Ejercicio 08()")
            println("11. Ejercicio 13()")
            println("12. Ejercicio 15()")
            println("13. Ejercicio 18()")
            println("14. Ejercicio 19()")
            println("15. Ejercicio 25()")
            println("\nEXCEPCIONES")
            println("16.Ejercicio 02()")
            println("17. Ejercicio 03()")
            println("18. Ejercicio 04()")
            val opc = pedirOpcion(0,18) //en el 5 poner el maximo de ejercciios que hay en la U1
            ejecutarEj(2,opc)

        }

        3 -> {
            println("\nLISTAS Y TUPLAS")
            println("1. Ejercicio 04")
            println("2. Ejercicio 06")
            println("3. Ejercicio 08")
            println("4. Ejercicio 09")
            println("5. Ejercicio 10")
            println("6. Ejercicio 13")
            println("\nDICCIONARIOS")
            println("7. Ejercicio 03")
            println("8. Ejercicio 05")
            println("9. Ejercicio 06")
            println("10. Ejercicio 07")
            println("11. Ejercicio 08")
            println("12. Ejercicio 10")
            println("13. Ejercicio 11")
            println("\nCONJUNTOS")
            println("14. Ejercicio 01")
            println("15. Ejercicio 02")
            println("16. Ejercicio 03")
            println("17. Ejercicio 04")
            println("18. Ejercicio 05")
            println("19. Ejercicio 06")
            val opc = pedirOpcion(0,19) //en el 5 poner el maximo de ejercciios que hay en la U1
            ejecutarEj(3,opc)
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
