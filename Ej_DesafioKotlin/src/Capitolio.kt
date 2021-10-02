import kotlin.random.Random

class Capitolio {
    var listaItems:ArrayList<Item> = ArrayList<Item>(100)
    var listaTributosMuertos:ArrayList<Tributo> = ArrayList<Tributo>(0)

    constructor(listaItems:ArrayList<Item>,listaTributosMuertos:ArrayList<Tributo>){
        this.listaItems=listaItems
        this.listaTributosMuertos=listaTributosMuertos
    }

    fun rellenarItems(){
        for(i in 0..99){
            when(Random.nextInt(0,3)){
                0 -> listaItems.add(Factoria.generarArma())
                1 -> listaItems.add(Factoria.generarMedicina())
                2 -> listaItems.add(Factoria.generarTrampa())
            }
        }
    }

}