package Stack

class Node<TTarget>(var value: TTarget, var next: Node<TTarget>? = null)

class Stack<TTarget> {
    private var first: Node<TTarget>? = null
    private var last: Node<TTarget>? = null
    private var size: Int = 0

    fun push(value: TTarget): Int {
        val newNode = Node(value)

        if (first == null) {
            first = newNode
            last = newNode
        } else {
            val temp = first
            first = newNode
            first!!.next = temp
        }

        return ++size
    }

    fun pop(): TTarget? {
        if (first == null) return null

        if (first == last) last = null

        val temp = first
        first = first!!.next
        size--

        return temp!!.value

    }
}

fun main() {
    val stack = Stack<Int>()

    stack.push(1)
    stack.push(2)
    stack.push(3)

    println(stack.pop())
}