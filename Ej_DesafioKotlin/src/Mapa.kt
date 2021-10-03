import kotlin.random.Random

class Mapa { //ME DA PROBLEMAS
    var filas:Int=0
    var columnas:Int=0
    //var tablero:ArrayList<ArrayList<Any?>> = ArrayList()
    var tablero=Array(filas){Array<Any?>(columnas){null} }

    constructor(filas:Int,columnas:Int,tablero:Array<Array<Any?>>){
        this.filas=filas
        this.columnas=columnas

        this.tablero=tablero
    }

    fun soltarItems(c:Capitolio,cantidad:Int){

        var lleno=true

        for(i in 1..cantidad){

            lleno=true
            for(i in 0..filas-1){ //Comprobar si el tablero esta lleno para ver si puedo introducir items
                for(j in 0..columnas-1) {
                    if(tablero[i][j]==null){
                        lleno=false
                    }
                }
            }

            if(!lleno && c.listaItems.size>0) { //Si hay sitio en el mapa y objetos disponibles ene l capitolio

                var filaAle: Int = -1
                var colAle: Int = -1

                do {
                    //println("inicia bucle")
                    filaAle = Random.nextInt(0, this.filas)
                    colAle = Random.nextInt(0, this.columnas)

                } while (tablero[filaAle][colAle] is Arma || tablero[filaAle][colAle] is Medicina || tablero[filaAle][colAle] is Trampa || tablero[filaAle][colAle] is Tributo)

                tablero[filaAle][colAle] = c.listaItems[0]
                c.listaItems.removeAt(0)

            }
        }
    }

    fun aniadirTributo(t:Tributo){
        var filaAle:Int=-1
        var colAle:Int=-1

        do{
            //println("inicia bucle")
            filaAle=Random.nextInt(0,this.filas)
            colAle=Random.nextInt(0,this.columnas)

        }while(tablero[filaAle][colAle] is Arma || tablero[filaAle][colAle] is Medicina || tablero[filaAle][colAle] is Trampa || tablero[filaAle][colAle] is Tributo)

        tablero[filaAle][colAle]=t
    }

    fun mostrarTablero(){
        for(i in 0..filas-1){
            for(j in 0..columnas-1) {
                print(tablero[i][j])
                print(" ")
            }
            println()
        }
        println()
    }

}