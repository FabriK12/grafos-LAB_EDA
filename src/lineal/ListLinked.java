package lineal;

import java.util.Iterator;

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

    public E remove() {
        if(!this.isEmpty()) {
            Node aux = this.head;
            this.head = this.head.next;
            return aux.data;
        }
        return null;
    }

    public E first() {
        if(!this.isEmpty())
            return this.head.data;
        else
            return null;
    }

    //2.Implementar un iterator para la lista y mostrar todos sus elementos.

    private Node getKPosition(int k) throws IllegalStateException{
        if(!this.isEmpty() && k>=0 && k < this.size()) {
            Node aux = this.head;
            for (int i = this.size() - 1; ; i--) {//SE COMIENZA DESDE ATRAS YA QUE LA CABEZA SE ENCUENTRA AHI
                if (i == k) {//AQUI SE DEVUELVE EL NODO EN LA POSICION K
                    return aux;
                } else {//SINO SE SIGUE RECORRIENDO
                    aux = aux.next;
                }
            }
        }else {
            throw new IllegalStateException("IndexOutOfBoundsException");
        }

    }

    public Iterator<E> iterator(){
        return new ListLinkedIterator();
    }

    private class ListLinkedIterator implements Iterator<E>{
        private Node next = head;
        private int cont = 0;

        public boolean hasNext() {
            return cont < ListLinked.this.size();
        }

        public E next() {
//            Node aux = getKPosition(cont);//cont comienza desde 0 osea k-esima posicion k=0
            Node aux;
            if(this.next != null){
                aux = this.next;
            }else {
                return null;
            }
            if(this.next.next != null){
                this.next = this.next.next;
            }else {
                this.next = null;
            }
            cont++;
            return aux.data;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (!this.isEmpty()) {
            Node aux = this.head;
            while(aux != null){
                sb.append(aux.data);
                aux = aux.next;
//                if(aux != null) {
//                    sb.append(", ");
//                }
            }
            sb.append("]");
        }else {
            sb = new StringBuilder("[]");
        }
        return sb.toString();
    }
}
