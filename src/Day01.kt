import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val idsLineRegex = """(\d+) +(\d+)""".toRegex()
        val (ids0, ids1) = input.map {
            val matchGroups = idsLineRegex.matchEntire(it)!!.groupValues
            matchGroups[1].toInt() to matchGroups[2].toInt()
        }.unzip()

        val sumOfDiffs = ids0.sorted().zip(ids1.sorted()).sumOf { (id0, id1) -> abs(id0 - id1) }
        return sumOfDiffs
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
