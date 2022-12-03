package Day03

import readInput

fun main() {

    fun items(input: String): List<String> {
        return input.split("\n")
    }

    fun getPoint(letter: Char): Int {
        val lowerLetters = ('a'..'z').toMutableList()
        val capitalLetters = ('A'..'Z').toMutableList()
        val combinedList = lowerLetters.plus(capitalLetters)
        return combinedList.indexOf(letter) + 1
    }

    fun part1(input: String): Int {
        var score = 0
        items(input).forEach { item: String ->
            val firstPart = item.substring(0,item.length / 2).split("")
            val secondPart = item.substring(item.length / 2, item.length).split("")
            val commonChar = firstPart.intersect(secondPart).elementAt(1).single()
            score += getPoint(commonChar)
        }
        return score
    }

    fun part2(input: String): Int {
        return items(input).map { it.split("\n").sumOf(String::toInt) }.sortedDescending().take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03/Day03_test")
    check(part1(testInput) == 157)

    val input = readInput("Day03/Day03")
    println(part1(input))
//    println(part2(input))
}
