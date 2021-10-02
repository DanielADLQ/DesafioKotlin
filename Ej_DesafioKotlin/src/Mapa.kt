class Mapa { //ME DA PROBLEMAS
    var filas:Int?=null
    var columnas:Int?=null
    var tablero:ArrayList<ArrayList<Any?>> = ArrayList()

    constructor(filas:Int,columnas:Int,tablero:ArrayList<ArrayList<Any?>>){
        this.filas=filas
        this.columnas=columnas

        var unaFila = ArrayList<Any?>(0)

        //Rellena el tablero con null, podria poner 0???

        for(i in 0..columnas-1){
            unaFila.add(null)
        }
        for(i in 0..filas-1){
            tablero.add(unaFila)
        }
    }

    fun rellenarItems(c:Capitolio){

    }

}