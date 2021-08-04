package lineal;

public class ListLinked<E> {
    public class Node {
        protected E data;
        protected Node next;

        public Node(E data) {
            this(data, null);
        }

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private int size;

    public ListLinked() {
        this.head = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int size() {
        return this.size;
    }

    public void insertFirst(E data) {
        this.head = new Node(data, this.head);
        this.size++;
    }

    public E search(E data){
        Node aux = searchNode(data);
        if(aux == null){
            return null;
        }else {
            return aux.data;
        }
    }

    private Node searchNode(E data) {
        Node actual = this.head;
        while(actual != null){
            if(actual.data.equals(data)) {
                return actual;
            }else {
                actual = actual.next;
            }
        }
        return null;
    }
}
