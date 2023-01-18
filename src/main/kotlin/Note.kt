class Note(
    val name: String,
    val text: String,
    override val parent: Menu,
    override val options: ArrayList<Openable> = arrayListOf(),
    override val header: String = "note",
    override val viewOnly: Boolean = true
) : Menu, Openable {

    override fun open() {
        println("----$name----\n\t$text\n")
        ScreenNavigator.showMenu(this)
    }

    override fun toString(): String = name
}