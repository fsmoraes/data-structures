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

    fun pop(): Node<TTarget>? {

        if (head == null) return null

        val temp = tail

        if (length == 1) {
            head = null
            tail = null
        } else {
            tail = tail!!.prev
            tail!!.next = null
            temp!!.prev = null
        }

        length--

        return temp
    }

    fun shift(): Node<TTarget>? {

        if (head == null) return null

        val oldHead = head

        if (length == 1) {
            head = null
            tail = null
        } else {
            head = oldHead!!.next
            head!!.prev = null
            oldHead.next = null
        }

        length--

        return oldHead
    }

    fun unshift(value: TTarget) {
        val newNode = Node(value)

        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            head!!.prev = newNode
            newNode.next = head
            head = newNode
        }

        length++
    }

    fun get(index: Int): Node<TTarget>? {

        if (length == 0 || index < 0 || index >= length) return null

        var current: Node<TTarget>?

        if (index < length / 2) {
            //Começa pelo inicio da lista
            var count = 0
            current = head!!

            while (count != index) {
                current = current!!.next
                count++
            }
        } else {
            //Começa pelo fim da lista
            var count = length - 1
            current = tail!!

            while (count != index) {
                current = current!!.prev
                count--
            }
        }

        return current
    }
}

fun main() {
    val dll = DoublyLinkedList<Int>()

    dll.push(1)
    dll.push(2)
    dll.push(3)

    println(dll.get(-1))
    println(dll.get(0)?.value)
    println(dll.get(2)?.value)
    println(dll.get(3))
}