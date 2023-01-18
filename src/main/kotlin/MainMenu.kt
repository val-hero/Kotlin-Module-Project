class MainMenu : Menu {
    override val options: ArrayList<Openable> = ArrayList()
    override val header = "archive"
    override val parent = this
    override val viewOnly = false

    override fun create() {
        println("Enter archive's name: ")
        val name = InputHandler.getString()
        options.add(Archive(name, this))
        println("Archive \"$name\" is created!")

        ScreenNavigator.showMenu(this)
    }
}