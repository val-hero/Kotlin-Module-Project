class Archive(
    val name: String,
    override val parent: Menu,
    override val options: ArrayList<Openable> = arrayListOf(),
    override val header: String = "note",
    override val viewOnly: Boolean = false
) : Menu, Openable {

    override fun open() {
        ScreenNavigator.showMenu(this)
    }

    override fun create() {
        println("Enter note name:")
        val name = InputHandler.getString()
        println("Enter note text: ")
        val text = InputHandler.getString()
        options.add(Note(name, text, this))
        ScreenNavigator.showMenu(this)
    }

    override fun toString(): String = name
}

