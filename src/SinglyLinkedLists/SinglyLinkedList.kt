package SinglyLinkedLists

fun main() {
    val list = SinglyLinkedList<Int>()

    list.push(1)
    list.push(2)
    list.push(4)


}

class Node<TTarget>(val value: TTarget) {
    lateinit var next: Node<TTarget>
}

class SinglyLinkedList<TTarget> {

    private var head: Node<TTarget>? = null
    private var tail: Node<TTarget>? = null
    private var length: Int = 0

    fun push(value: TTarget) {
        val newNode = Node(value)

        if (head == null) {
            head = newNode
            tail = head
        } else {
            tail!!.next = newNode
            tail = newNode
        }

        length++
    }
}