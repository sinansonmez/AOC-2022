fun main() {
    
    private val calories = input.split("\n\n").map { group -> Elf(group.split("\n").map { it.toInt() }) }
    
    fun part1(input: List<String>): Int {
        return calories.maxOf { it.calories.sum() }
    }

    fun part2(input: List<String>): Int {
        return calories.map { it.calories.sum() }.sortedDescending().take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 1)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
