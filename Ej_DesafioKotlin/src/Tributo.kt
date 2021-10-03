import kotlin.math.abs
import kotlin.random.Random

class Tributo(var vida:Int, var fuerza:Int, var distrito:String) {

    override fun toString(): String {
        return "Tr:"+ this.distrito
    }

    class Builder(var vida:Int,var fuerza:Int,var distrito:String){
        fun vida(vida:Int):Builder{
            this.vida=vida
            return this
        }
        fun fuerza(fuerza:Int):Builder{
            this.fuerza=fuerza
            return this
        }
        fun distrito(distrito:String):Builder{
            this.distrito=distrito
            return this
        }
        fun build():Tributo{
            return Tributo(vida,fuerza,distrito)
        }
    }

    fun recogerArma(a:Arma){
        this.fuerza = this.fuerza + a.nivelFuerza
    }
    fun recogerMedicina(m:Medicina){
        this.vida = this.vida + m.nivelCura
    }
    fun combatir(t2:Tributo):Int{ //-1 no combate, 0 gana el que ataca, 2 gana el otro
        var ganador:Int=-1
        println("Tributo1: Fuerza = "+this.fuerza+", vida = "+this.vida+", distrito = "+this.distrito)
        println("Tributo2: Fuerza = "+t2.fuerza+", vida = "+t2.vida+", distrito = "+t2.distrito)
        if(this.fuerza>t2.fuerza){
            ganador=0
        }else if(this.fuerza<t2.fuerza){
            ganador=1
        }else{ //Misma fuerza
            if(this.vida>t2.vida){
                ganador=0
            }else if(this.vida<t2.vida){
                ganador=1
            }else{ //Tambien tienen la misma vida
                when(Random.nextInt(0,2)){ //Moneda al aire
                    0 -> ganador=0
                    1 -> ganador=1
                }

            }
        }

        return ganador
    }

    fun moverse(tableroJuego:Mapa,posH:Int,posV:Int,c:Capitolio):Int{
        var movV:Int=0
        var movH:Int=0
        var finalizado:Boolean=false
        var ganador:Int=-1 // -1: no hay combate ni trampa, se queda como estaba
        do{
            movH= Random.nextInt(-1,2)
            movV= Random.nextInt(-1,2) //-1,0,1

            if(abs(movH)+ abs(movV)==1){ //Para moverse un solo paso
                if(posH+movH>=0 && posH+movH<tableroJuego.filas){ //Si esta dentro del tablero
                    if(posV+movV>=0 && posV+movV<tableroJuego.columnas){

                        if(tableroJuego.tablero[posH+movH][posV+movV] !is Tributo){ //Si no hay un tributo donde se quiere mover

                            when(tableroJuego.tablero[posH+movH][posV+movV]){
                                is Arma -> {
                                    this.recogerArma(tableroJuego.tablero[posH+movH][posV+movV] as Arma)
                                    tableroJuego.tablero[posH+movH][posV+movV]=tableroJuego.tablero[posH][posV]//Se mueve a la posicion elegida
                                    tableroJuego.tablero[posH][posV]=null //La casilla anterior queda vacia
                                }
                                is Medicina -> {
                                    this.recogerMedicina(tableroJuego.tablero[posH+movH][posV+movV] as Medicina)
                                    tableroJuego.tablero[posH+movH][posV+movV]=tableroJuego.tablero[posH][posV]//Se mueve a la posicion elegida
                                    tableroJuego.tablero[posH][posV]=null //La casilla anterior queda vacia
                                }
                                is Trampa -> { //Muere
                                    c.listaTributosMuertos.add(tableroJuego.tablero[posH][posV] as Tributo)
                                    tableroJuego.tablero[posH][posV]=null
                                    tableroJuego.tablero[posH+movH][posV+movV]=null //Se mueve a la posicion elegida
                                    ganador=2 //Gana la trampa...
                                    //println("El tributo ha muerto al pisar una trampa")
                                }
                            }

                        }else{ //Si encuentra un tributo
                            println("COMBATE!\n")
                            ganador=this.combatir(tableroJuego.tablero[posH+movH][posV+movV] as Tributo) //Devuelve 0 o 1
                            when(ganador){
                                0 -> { //Gana el que ataca y ocupa la nueva posicion, muere el otro
                                    c.listaTributosMuertos.add(tableroJuego.tablero[posH+movH][posV+movV] as Tributo)
                                    tableroJuego.tablero[posH+movH][posV+movV]=tableroJuego.tablero[posH][posV]
                                    tableroJuego.tablero[posH][posV]=null
                                }
                                1 -> { //Muere el que se queria mover, el otro se queda en su sitio
                                    c.listaTributosMuertos.add(tableroJuego.tablero[posH][posV] as Tributo)
                                    tableroJuego.tablero[posH][posV]=null
                                }
                            }
                        }
                        finalizado=true
                    }
                }
            }

        }while(!finalizado)
        return ganador
    }

}