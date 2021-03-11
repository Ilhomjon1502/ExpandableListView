package obektMalumot

class Product(var type:String, var name:String, var malumot:String) {
    override fun toString(): String {
        return "Product(type='$type', name='$name', malumot='$malumot')"
    }
}