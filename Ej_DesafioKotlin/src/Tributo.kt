class Tributo(var vida:Int?=null,var fuerza:Int?=null,var distrito:String?=null) {

    override fun toString(): String {
        return "Tributo: (" + this.vida + ", " + this.fuerza + ", "+ this.distrito+")"
    }

    class Builder(var vida:Int?=null,var fuerza:Int?=null,var distrito:String?=null){
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

}