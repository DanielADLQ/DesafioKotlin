class Arma(override var descripcion:String?,var nivelFuerza:Int):Item(descripcion) {

    class Builder(var descripcion: String?=null, var nivelFuerza: Int){

        fun descripcion(descripcion: String):Builder{
            this.descripcion=descripcion
            return this
        }
        fun nivelFuerza(nivelFuerza: Int):Builder{
            this.nivelFuerza=nivelFuerza
            return this
        }
        fun build():Arma{
            return Arma(descripcion,nivelFuerza)
        }
    }

}