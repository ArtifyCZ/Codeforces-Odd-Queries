// solution for https://codeforces.com/contest/1807/problem/D
fun main() {
    for (t in (1..readln().toInt())) {
        val (_, q) = readln().split(' ').map { it.toInt() }
        val a: List<Triple<Int, Boolean, Boolean>> = run {
            var tmp = false
            val a = readln().split(' ').map { it.toInt() }
                .map { tmp = if(it % 2 == 0) tmp else !tmp; Pair(it, tmp) }
            tmp = false
            a.reversed()
                .map { (it, fromStart) -> tmp = if(it % 2 == 0) tmp else !tmp; Triple(it, fromStart, tmp) }
                .reversed()
        }

        for(qi in (1..q)) {
            val (l, r, k) = readln().split(' ').map { it.toInt() }
            val fromStart = a.getOrNull(l - 2)?.second ?: false
            val fromEnd = a.getOrNull(r)?.third ?: false
            val ends = fromStart != fromEnd
            val inMiddle = (k % 2 != 0 && (r - l) % 2 == 0)
            println(if(inMiddle != ends) "YES" else "NO")
        }
    }
}
