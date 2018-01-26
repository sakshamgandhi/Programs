package algos.graphs.api;

import java.util.Iterator;

public class Bag implements Iterable<Integer> {

    Node first, last = null;
    int N = 0;

    public void enqueue(int i) {
        Node current = last;
        last = new Node(i);
        last.next = null;
        if (size() == 0) {
            first = last;
        } else {
            current.next = last;
        }

        N++;

    }

    public int size() {
        return N;
    }

    private class Node {

        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new CustomIetrator();
    }

    private class CustomIetrator implements Iterator<Integer> {

        Node current = first;

        @Override
        public Integer next() {
            Node x = current;
            current = current.next;
            return x.value;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
        }
    }
}