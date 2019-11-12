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
    println(secret)
    val length = secret.length
    println(boards.get(0) + "\n\n")
    for (i: Int in (1..length)) print("_____  ")
    var current_guess: String?
    var incorrect_guesses = ArrayList<String>()
    var correct_guesses = ArrayList<String>()
    while(incorrect_guesses.size<6 && correct_guesses.size<length) {
        current_guess = guess()
        if(secret.contains(current_guess)) {
            //println("Guess was: " + current_guess + " and it is in the word")
            for(i: Int in (0..secret.count { it == current_guess })) correct_guesses.add(current_guess.toString())
            println("Correct Guesses: " + correct_guesses)
        } else {
            //println("Guess was: " + current_guess + " and it is not in the word")
            incorrect_guesses.add(current_guess)
            println("Incorrect Gueses: " + incorrect_guesses.toString())
        }
        //Start reaction to guess here
        println(boards.get(incorrect_guesses.size))
        for(i: Int in (0..length-1)) {
            if(correct_guesses.contains(secret.get(i).toString())) {
                print("  ${secret.get(i)}   ")
            } 
            else {
                print("_____  ")
            }
        }
    }
}
fun guess(message: String = "\nGuess a letter: "): String {
    print(message)
    return readLine()!!
}