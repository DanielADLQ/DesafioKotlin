class Trampa(override var descripcion:String?):Item(descripcion) {

    class Builder(var descripcion: String?=null){

        fun descripcion(descripcion: String):Builder{
            this.descripcion=descripcion
            return this
        }

        fun build():Trampa{
            return Trampa(descripcion)
        }
    }

}