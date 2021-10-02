import kotlin.random.Random

fun main(){

    var listaDistritos= arrayOf<String>("A","B","C","D","E")
    for(i in 0..9){ //10 tributos, 2 en cada distrito
        println(i)
        var t:Tributo= Factoria.generarTributo(listaDistritos[i%5])
    }

    var listaTributosMuertos = ArrayList<Tributo>(0)
    var listaItems = ArrayList<Item>(0)

    //var tipoItem:Int=-1

    /*for(i in 0..99){
        tipoItem=Random.nextInt(0,3)
        when(tipoItem){
            0 -> listaItems.add(Factoria.generarArma())
            1 -> listaItems.add(Factoria.generarMedicina())
            2 -> listaItems.add(Factoria.generarTrampa())
        }
    }*/

    var cap:Capitolio=Capitolio(listaItems,listaTributosMuertos)

    cap.rellenarItems() //Carga 100 objetos aleatorios en listaItems

    /*
    var tablero:ArrayList<ArrayList<Any?>> = ArrayList()
    var filas:Int=5
    var columnas:Int=5

    for(i in 0..filas-1){
        for(j in 0..columnas-1){
            tablero[i][j]=null //Relleno tablero de nulls
        }
    }
    */

    val filas:Int=5
    val columnas:Int=5
    var casillas:ArrayList<ArrayList<Any?>> = ArrayList()
    var tableroJuego:Mapa=Mapa(filas,columnas,casillas) //Tablero vacio


}