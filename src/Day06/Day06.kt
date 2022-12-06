package Day06

import readInput

// had a lot of challenge to solve day05. Thanks to https://github.com/James-Ansley/adventofcode/blob/main/kotlin/src/main/kotlin/y2022/day05.kt I figured out how to solve it
fun main() {

    fun items(input: String): List<String> {
        return input.split("\n")
    }

    fun solve(input: String, limit: Int): Int {
        (0..input.length - limit).forEach { num ->
            if (input.subSequence(num, num + limit).toSet().size == limit) {
                return num + limit
            }
        }
        return 0
    }

    fun part1(input: String): Int {
        return solve(input, 4)
    }

    fun part2(input: String): Int {
        return solve(input, 14)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06/Day06_test")
//    check(part1(testInput) == 2)

    val input = readInput("Day06/Day06")
    println(part1(input))
    println(part2(input))
}

