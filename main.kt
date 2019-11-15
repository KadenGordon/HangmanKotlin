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
    val dict = File("words.txt").useLines { it.toList() }
    val secret = dict.get((0..7699).random())
    val length = secret.length
    for (i: Int in (1..length)) print("_____  ")
    var current_guess: String?
    var incorrect_guesses = ArrayList<String>()
    var correct_guesses = ArrayList<String>()
    println(boards.get(0))
    while(incorrect_guesses.size<6 && correct_guesses.size<length) {
        current_guess = guess()
        println("\n\n\n\n\n")
        if(secret.contains(current_guess)) {
            for(i: Int in (1..secret.count { it.toString() == current_guess })) correct_guesses.add(current_guess.toString())
        } else {
            incorrect_guesses.add(current_guess)
        }
        println("Correct Guesses: " + correct_guesses)
        println("Incorrect Guesses: " + incorrect_guesses.toString())
        println(boards.get(incorrect_guesses.size)+"\n")
        for(i: Int in (0..length-1)) {
            if(correct_guesses.contains(secret.get(i).toString())) {
                print("  ${secret.get(i)}   ")
            } 
            else {
                print("_____  ")
            }
        }
        println("\n\n\n")
    }
    if(incorrect_guesses.size>=6) {
        println("You have lost. The correct word was \"$secret\"")
    }
    else {
        println("You won!")
    }
}
fun guess(message: String = "\nGuess a letter: "): String {
    print(message)
    return readLine()!!
}