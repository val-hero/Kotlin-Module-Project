import kotlin.system.exitProcess

object ScreenNavigator {
    var currentMenu: Menu = MainMenu()
    private val createOption: Int = 0
    private var exitOption: Int = 1

    fun showMenu(menu: Menu) {
        currentMenu = menu
        if (!currentMenu.viewOnly) {
            println("List of ${currentMenu.header}s")
            println("$createOption. Create new ${currentMenu.header}")
        }
        if (currentMenu.options.isNotEmpty()) {
            currentMenu.options.forEachIndexed { index, element ->
                println("${index + 1}. $element")
            }
        }
        exitOption = currentMenu.options.size + 1
        println("$exitOption. Exit")

        select()
    }

    private fun select() {
        while (true) {
            val option = InputHandler.getInt()
            if (option !in 0..exitOption || (currentMenu.viewOnly && option != exitOption)) {
                println("There's no such option, go again.")
            } else {
                when (option) {
                    createOption -> currentMenu.create()
                    exitOption -> exit()
                    else -> currentMenu.options[option - 1].open()
                }
            }
        }
    }

    private fun exit() {
        if (currentMenu is MainMenu)
            exitProcess(0)
        else
            showMenu(currentMenu.parent)
    }
}