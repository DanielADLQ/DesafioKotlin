open class Item(open var descripcion:String?=null) {
    override fun toString():String{
        return ""+descripcion
    }
}