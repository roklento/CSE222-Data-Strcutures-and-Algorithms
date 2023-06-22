package LDLinkedList;

import java.util.AbstractList;

public class LDLinkedList<E> extends AbstractList<E>{

    private Node<E> head;
    private Node<E> tail;
    private int size;
    private int numMarked;
    /** */
    private static class Node<E> {
        E data;
        Node<E> next;
        boolean marked;

        Node(E element) {
            data = element;
            next = null;
            marked = false;
        }
    }
    /**
     * 
     */
    public LDLinkedList() {
        head = null;
        tail = null;
        size = 0;
        numMarked = 0;
    }
    /**
     * 
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    /**
     * 
     */
    @Override
    public int size() {
        return size;
    }
    /**
     * 
     */
    @Override
    public boolean add(E element) {
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
        return true;
    }
    /** */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head;
        Node<E> previous = null;
        for (int i = 0; i < index; i++) {
            previous = current;
            current = current.next;
        }
        current.marked = true;
        numMarked++;

        if (numMarked == 2) {
            removeMarked();
        }
        return current.data;
    }
    /** */
    private void removeMarked() {
        Node<E> current = head;
        Node<E> previous = null;
        while (current != null) {
            if (current.marked) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                if (tail == current) {
                    tail = previous;
                }
                size--;
                numMarked--;
                if (numMarked == 0) {
                    break;
                }
                current = current.next;
            } 
            else {
                previous = current;
                current = current.next;
            }
        }
    }
}

