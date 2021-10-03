import kotlin.random.Random

fun main(){

    val filas:Int=5
    val columnas:Int=5
    var casillas=Array(filas){Array<Any?>(columnas){null} }
    var tableroJuego:Mapa=Mapa(filas,columnas,casillas) //Tablero vacio de 7x7

    var listaDistritos= arrayOf<String>("A","B","C","D","E")

    for(i in 0..9){ //10 tributos, 2 en cada distrito

        var t:Tributo= Factoria.generarTributo(listaDistritos[i%5])
        tableroJuego.aniadirTributo(t)
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

    tableroJuego.soltarItems(cap,10)

    tableroJuego.mostrarTablero()

    var tiempo:Int=1
    var ganador:Int=-1

    do{ //Comienza el juego

        if(tiempo%2==0){ //Cada 2 segundos

            for(i in 0..filas-1){
                for(j in 0..columnas-1) {
                    if(tableroJuego.tablero[i][j] is Tributo){
                        if(cap.listaTributosMuertos.size<9){
                            ganador=(tableroJuego.tablero[i][j] as Tributo).moverse(tableroJuego,i,j,cap)
                            println("GANADOR: "+ganador)
                            when(ganador){
                                0 -> println("El que se mueve ha ganado\n")
                                1 -> println("El que se mueve ha muerto\n")
                            }
                            println("MUERTOS: "+cap.listaTributosMuertos.size)
                        }
                    }
                }
            }

        }

        if(tiempo%5==0){
            tableroJuego.soltarItems(cap,4)
            tableroJuego.mostrarTablero()
        }
        println(listaTributosMuertos.size)
        tiempo++
    }while(cap.listaTributosMuertos.size<9)

    //--------------------------------------------------ARREGLAR HACIENDO TURNO DE MOVIMIENTOS SOBRE TABLERO AUXILIAR O MEJOR ASEGURANDO QUE SOLO SE MUEVAN UNA VEZ????
    //--------------------------------------------------Y CONTROLAR LOS PRINT QUE ESTA INCOMPLETO ESCRIBIR QUIEN BATALLA, RESULTADO FINAL...

}