interface Menu {
    val header: String
    val parent: Menu
    val options: ArrayList<Openable>
    val viewOnly: Boolean

    fun create() {
        return
    }
}