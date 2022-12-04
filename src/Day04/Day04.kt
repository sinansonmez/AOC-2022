package Day04

import readInput

fun main() {

    fun items(input: String): List<String> {
        return input.split("\n")
    }

    fun part1(input: String): Int {
        var score = 0
        items(input).forEach { item: String ->
            val areas = item.split(",")
            val firstArray = (areas[0].split("-")[0].toInt()..areas[0].split("-")[1].toInt()).toSet()
            val secondArray = (areas[1].split("-")[0].toInt()..areas[1].split("-")[1].toInt()).toSet()
            val firstcheck = firstArray.containsAll(secondArray)
            val secondCheck = secondArray.containsAll(firstArray)
            if (firstcheck || secondCheck) {
                score++
            }
        }
        return score
    }

    fun part2(input: String): Int {
        var score = 0
        items(input).forEach { item: String ->
            val areas = item.split(",")
            val firstArray = (areas[0].split("-")[0].toInt()..areas[0].split("-")[1].toInt()).toSet()
            val secondArray = (areas[1].split("-")[0].toInt()..areas[1].split("-")[1].toInt()).toSet()
            if (firstArray.intersect(secondArray).isNotEmpty()) {
                score++
            }
        }
        return score
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04/Day04_test")
    check(part1(testInput) == 2)

    val input = readInput("Day04/Day04")
    println(part1(input))
    println(part2(input))
}

