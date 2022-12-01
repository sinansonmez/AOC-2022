fun main() {
    
    fun calories(input: String): List<String> {
        return input.split("\n\n")
    }
    
    fun part1(input: String): Int {
        return calories(input).maxOf { it.split("\n").sumOf(String::toInt) }
    }

    fun part2(input: String): Int {
        return calories(input).map { it.split("\n").sumOf(String::toInt) }.sortedDescending().take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 1)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
