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


    var cap:Capitolio=Capitolio(listaItems,listaTributosMuertos)

    cap.rellenarItems() //Carga 100 objetos aleatorios en listaItems

    tableroJuego.soltarItems(cap,10)

    tableroJuego.mostrarTablero()

    var tiempo:Int=1
    var ganador:Int=-1
    var distritoJugando:String=""
    var tableroAuxiliar=Array(filas){Array<Any?>(columnas){null} } //Para controlar que nadie se mueva dos veces en un turno

    do{ //Comienza el juego
        println("Tiempo: "+tiempo+"\n")
        if(tiempo%2==0){ //Cada 2 segundos

            for(i in 0..filas-1) {
                for (j in 0..columnas-1) {
                    tableroAuxiliar[i][j] = tableroJuego.tablero[i][j] //Copia el tablero actual
                }
            }

            for(i in 0..filas-1){
                for(j in 0..columnas-1){
                    if(tableroAuxiliar[i][j] is Tributo){
                    //if(tableroJuego.tablero[i][j] is Tributo)
                        if(cap.listaTributosMuertos.size<9){
                            distritoJugando=(tableroJuego.tablero[i][j] as Tributo).distrito
                            ganador=(tableroJuego.tablero[i][j] as Tributo).moverse(tableroJuego,i,j,cap)
                            //println("GANADOR: "+ganador)
                            when(ganador){
                                0 -> println("El tributo del distrito "+distritoJugando+" vence a su rival y ocupa su posicion\n ")
                                1 -> println("El tributo del distrito "+distritoJugando+" muere a manos y de un rival\n ")
                                2 -> println("El tributo del distrito "+distritoJugando+" ha muerto al pisar una trampa\n")
                            }
                        }
                    }
                }
            }
            println("Han muerto "+listaTributosMuertos.size+ " tributos\n")
        }

        if(tiempo%5==0){
            tableroJuego.soltarItems(cap,4)
            tableroJuego.mostrarTablero()
        }
        tiempo++
        //Thread.sleep(500)

    }while(cap.listaTributosMuertos.size<9)

    println("Ha ganado el distrito "+tableroJuego.quienGana()+"\n")

    tableroJuego.mostrarTablero()
}