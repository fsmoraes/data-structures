package SinglyLinkedLists

fun main() {
    val list = SinglyLinkedList<Int>()

    list.push(1)
    list.push(2)
    list.push(4)

//    val pop = list.pop()
//    val shift = list.shift()

    list.unshift(9)

    val node = list.get(3)

    list.set(0, 10)
}

class Node<TTarget>(var value: TTarget) {
    var next: Node<TTarget>? = null
}

class SinglyLinkedList<TTarget> {

    private var head: Node<TTarget>? = null
    private var tail: Node<TTarget>? = null
    private var length: Int = 0

    //Adiciona um elemento no fim da lista
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

    //Remove e retorna o último elemento da lista
    fun pop(): Node<TTarget>? {
        if (head == null) return null

        var current = head
        var newTail = current

        while (current!!.next != null) {
            newTail = current
            current = current.next
        }

        length--

        if (length == 0) {
            head = null
            tail = null
        } else {
            tail = newTail
            tail!!.next = null
        }

        return current
    }

    //Remove e retorna o primeiro elemento da lista
    fun shift(): Node<TTarget>? {
        if (head == null) return null

        val currentHead = head
        head = currentHead!!.next
        length--

        if (length == 0) {
            tail = null
        }

        return currentHead
    }

    //Adiciona um elemento no ínicio da lista
    fun unshift(value: TTarget) {

        val newNode = Node(value)

        if (head == null) {
            head = newNode
            tail = head
        } else {
            newNode.next = head
            head = newNode
        }

        length++
    }

    //Obtém um elemento da lista pelo indice
    fun get(index: Int): Node<TTarget>? {
        if (index < 0 || index >= length) return null

        var counter = 0
        var current = head

        while (counter != index) {
            current = current!!.next
            counter++
        }

        return current
    }

    //Atribui um novo valor ao elemento do indice informado
    fun set(index: Int, value: TTarget): Boolean {
        var node = get(index)

        if (node != null) {
            node.value = value
            return true
        }

        return false
    }
}