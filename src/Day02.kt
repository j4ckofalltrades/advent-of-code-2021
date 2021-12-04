fun main() {
    fun part1(input: List<String>): Int {
        var depth = 0
        var x = 0

        input.forEach {
            val commands = it.split(" ")
            val direction = commands[0]
            val unit = commands[1].toInt()

            if (direction == "forward") {
                x += unit
            }

            if (direction == "down") {
                depth += unit
            }

            if (direction == "up") {
                depth -= unit
            }
        }

        return depth * x
    }

    fun part2(input: List<String>): Int {
        var depth = 0
        var x = 0
        var aim = 0

        input.forEach {
            val commands = it.split(" ")
            val direction = commands[0]
            val unit = commands[1].toInt()

            if (direction == "down") {
                aim += unit
            }

            if (direction == "up") {
                aim -= unit
            }

            if (direction == "forward") {
                x += unit
                depth += aim * unit
            }
        }

        return depth * x
    }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
