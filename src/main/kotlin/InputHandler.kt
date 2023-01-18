object InputHandler {
    fun getString(): String {
        while (true) {
            val input = readLine()
            if (input == null || input.isEmpty())
                println("Input was empty, please try again.")
            else
                return input
        }
    }

    fun getInt(): Int {
        while (true) {
            val input = readLine()
            if (input?.toIntOrNull() == null)
                println("This is not number, please try again.")
            else
                return input.toInt()
        }
    }
}