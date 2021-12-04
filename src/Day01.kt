fun main() {
    fun part1(input: List<String>): Int {
        return input.windowed(2)
            .count { (x, y) -> x.toInt() < y.toInt() }
    }

    fun part2(input: List<String>): Int {
        return input.windowed(3) { (x, y, z) -> x.toInt() + y.toInt() + z.toInt() }
            .windowed(2)
            .count { (x, y) -> x < y }
    }

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
