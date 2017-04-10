import com.sun.istack.internal.Nullable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T>{

    private int count;
    private Node<T> head;
    private Node<T> tail;

    public LinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void add (T element){
        if (head == null){
            head = new Node<>(element);
            tail = head;
        }else {
            Node<T> node = new Node<>(element);
            tail.next = node;
            tail = node;
        }
        count++;
    }

    public void addAll(LinkedList<T> elements) {
        Node<T> actualNode = elements.head;
        if ( head != null){
            this.tail.next = actualNode;
        }else if (actualNode != null) {
            this.head = actualNode;
            this.tail = elements.tail;
        }
        count+=elements.count;
    }

    @Nullable
    public T get(int index) {
        Node<T> actualNode = head;
        int cont = 0;
        while (actualNode != null){
            if (index == cont){
                return actualNode.value;
            }else {
                actualNode = actualNode.next;
                cont++;
            }
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<T>(head);
    }

    public boolean remove(T element) {

        if (element == null) {
            return false;
        }
        if (count == 0) {
            return false;
        }

        if (head.value.equals(element)) {
            head = head.next;
            if (count == 1) {
                tail = null;
            }
            count--;
            return true;
        }

        Node<T> ant = head;
        Node<T> aux = head.next;

        for (int i = 1; i < count; i++) {
            if (aux.value.equals(element)) {
                if (aux == tail) {
                    tail = ant;
                    tail.next = null;
                } else {
                    ant.next = aux.next;
                }
                count--;
                return true;
            }
            ant = ant.next;
            aux = aux.next;
        }

        return false;
    }

    public int size(){
        return count;
    }

    static class LinkedListIterator<T> implements Iterator<T>{

        private Node<T> current;

        LinkedListIterator(Node<T> current){
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            Node<T> next = current;
            current = current.next;
            return next.value;
        }
    }

    static class Node<T>{
        T value;
        Node<T> next;
        Node(T value){
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

}