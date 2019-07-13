package DLL

class Node<TTarget>(var value: TTarget, var next: Node<TTarget>? = null, var prev: Node<TTarget>? = null)

class DoublyLinkedList<TTarget> {
    private var head: Node<TTarget>? = null
    private var tail: Node<TTarget>? = null
    private var length: Int = 0

    fun push(value: TTarget) {
        val newNode = Node(value)

        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            tail!!.next = newNode
            newNode.prev = tail
            tail = newNode
        }

        length++
    }
}