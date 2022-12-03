package Day03

import readInput

fun main() {

    fun items(input: String): List<String> {
        return input.split("\n")
    }

    fun getPoint(letter: Char): Int {
        val lowerLetters = ('a'..'z')
        val capitalLetters = ('A'..'Z')
        val combinedList = lowerLetters.plus(capitalLetters)
        return combinedList.indexOf(letter) + 1
    }

    fun part1(input: String): Int {
        var score = 0
        items(input).forEach { item: String ->
            val firstPart = item.substring(0, item.length / 2).toCharArray().toSet()
            val secondPart = item.substring(item.length / 2, item.length).toCharArray().toSet()
            val commonChar = firstPart.intersect(secondPart).first()
            score += getPoint(commonChar)
        }
        return score
    }

    fun part2(input: String): Int {
        var score = 0
        val subList = items(input).chunked(3)
        subList.forEach { list ->
            val first = list.elementAt(0).toCharArray().toSet()
            val second = list.elementAt(1).toCharArray().toSet()
            val third = list.elementAt(2).toCharArray().toSet()
            val commonChar = first.intersect(second).intersect(third).first()
            score += getPoint(commonChar)
        }
        return score
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03/Day03_test")
    check(part2(testInput) == 70)

    val input = readInput("Day03/Day03")
    println(part1(input))
    println(part2(input))
}

