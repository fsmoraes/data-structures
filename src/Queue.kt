package Queue

class Node<TTarget>(var value: TTarget, var next: Node<TTarget>? = null)

class Queue<TTarget> {
    private var first: Node<TTarget>? = null
    private var last: Node<TTarget>? = null
    private var size: Int = 0

    fun enqueue(value: TTarget) {
        val newNode = Node(value)

        if (first == null) {
            first = newNode
            last = newNode
        } else {
            last!!.next = newNode
            last = newNode
        }

        size++
    }

    fun dequeue(): TTarget? {
        if (first == null) return null

        if (first == last) last = null

        val temp = first!!

        first = first!!.next
        size--

        return temp.value
    }
}

fun main() {
    val queue = Queue<Int>()

    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)

    println(queue.dequeue())
    println(queue.dequeue())
    println(queue.dequeue())
}