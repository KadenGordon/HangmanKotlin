import java.time.LocalDateTime
import java.io.File

val board0 = 
            "        __________ \n" + 
            "        |        | \n" + 
            "        |        | \n" + 
            "                 | \n" + 
            "                 | \n" + 
            "                 | \n" + 
            "                 | \n" + 
            "                 | \n" + 
            "                 | \n" + 
            "                 | \n" + 
            "     -------------------------"

val board1 = 
            "        __________ \n" + 
            "        |        | \n" + 
            "        |        | \n" + 
            "       / \\       |\n" + 
            "       \\_/       |\n" + 
            "                 | \n" + 
            "                 | \n" + 
            "                 | \n" + 
            "                 | \n" + 
            "                 | \n" + 
            "     -------------------------"

val board2 = 
            "        __________ \n" + 
            "        |        | \n" + 
            "        |        | \n" + 
            "       / \\       |\n" + 
            "       \\_/       |\n" + 
            "        |        | \n" + 
            "        |        | \n" + 
            "                 | \n" + 
            "                 | \n" + 
            "                 | \n" + 
            "     -------------------------"

val board3 = 
            "        __________ \n" + 
            "        |        | \n" + 
            "        |        | \n" + 
            "       / \\       |\n" + 
            "       \\_/       |\n" + 
            "     ___|        | \n" + 
            "        |        | \n" + 
            "                 | \n" + 
            "                 | \n" + 
            "                 | \n" + 
            "     -------------------------"

val board4 = 
            "        __________ \n" + 
            "        |        | \n" + 
            "        |        | \n" + 
            "       / \\       |\n" + 
            "       \\_/       |\n" + 
            "     ___|___     | \n" + 
            "        |        | \n" + 
            "                 | \n" + 
            "                 | \n" + 
            "                 | \n" + 
            "     -------------------------"

val board5 = 
            "        __________ \n" + 
            "        |        | \n" + 
            "        |        | \n" + 
            "       / \\       |\n" + 
            "       \\_/       |\n" + 
            "     ___|___     | \n" + 
            "        |        | \n" + 
            "       /         | \n" + 
            "      /          | \n" + 
            "                 | \n" + 
            "     -------------------------"

val board6 = 
            "        __________ \n" + 
            "        |        | \n" + 
            "        |        | \n" + 
            "       / \\       |\n" + 
            "       \\_/       |\n" + 
            "     ___|___     | \n" + 
            "        |        | \n" + 
            "       / \\       | \n" + 
            "      /   \\      | \n" + 
            "                 | \n" + 
            "     -------------------------"

val boards = listOf(board0, board1, board2, board3, board4, board5, board6)
fun main(args: Array<String>) {
    //for(board in boards) println(board) //to print all boards
    val dict = File("words.txt").useLines { it.toList() }
    val secret = dict.get((0..7699).random())
    val length = secret.length
    println(boards.get(0) + "\n\n")
    for (i: Int in (1..length)) print("_____  ")
    var guess: String?
    var incorrect_guesses = 0
    var correct_guesses = 0
    while(incorrect_guesses<6 && correct_guesses<length) {
        print("\nGuess a letter: ")
        guess = readLine()
    }
}