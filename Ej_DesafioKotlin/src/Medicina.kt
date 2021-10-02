class Medicina(override var descripcion:String?,var nivelCura:Int?=null):Item(descripcion) {

    class Builder(var descripcion: String?=null, var nivelCura: Int?=null){

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