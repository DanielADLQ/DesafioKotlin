import kotlin.random.Random

object Factoria {
    fun generarTributo(distrito:String):Tributo{
        var vida:Int=0
        var fuerza:Int=0
        var tri:Tributo = Tributo.Builder().vida(vida).fuerza(fuerza).distrito(distrito).build()
        return tri
    }
    fun generarArma():Arma{
        var descripcion:String="Arma para atacar"
        var nivelFuerza:Int=Random.nextInt(50,101) //Valor de 50 a 100
        var arm:Arma = Arma.Builder().descripcion(descripcion).nivelFuerza(nivelFuerza).build()
        return arm
    }
    fun generarMedicina():Medicina{
        var descripcion:String="Medicina para recuperar vida"
        var nivelCura:Int=Random.nextInt(50,101) //Valor de 50 a 100
        var med:Medicina = Medicina.Builder().descripcion(descripcion).nivelCura(nivelCura).build()
        return med
    }
    fun generarTrampa():Trampa{
        var descripcion:String="Trampa mortal. ¡Cuidado donde pisas!"
        var tram:Trampa = Trampa.Builder().descripcion(descripcion).build()
        return tram
    }
}