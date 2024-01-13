
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