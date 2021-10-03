class Medicina(override var descripcion:String?,var nivelCura:Int):Item(descripcion) {

    class Builder(var descripcion: String?=null, var nivelCura: Int){

        fun descripcion(descripcion: String):Builder{
            this.descripcion=descripcion
            return this
        }
        fun nivelCura(nivelCura: Int):Builder{
            this.nivelCura=nivelCura
            return this
        }
        fun build():Medicina{
            return Medicina(descripcion,nivelCura)
        }
    }

}