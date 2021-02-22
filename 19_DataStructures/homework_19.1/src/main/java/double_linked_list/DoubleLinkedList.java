package double_linked_list;

import java.util.Objects;

public class DoubleLinkedList<T> {
    private ListItem<T> head;
    private ListItem<T> tail;
    private int size;

    public ListItem<T> getHead() {
        return head;
    }

    public ListItem<T> getTail() {
        return tail;
    }


    public ListItem popHeadElement() {
        ListItem listItem = head;
        if (head != null) {
            head = head.getNext();
            head.setPrev(null);
            listItem.setNext(null);
        }
        return listItem;
    }

    public ListItem<T> popTailElement() {
        ListItem listItem = tail;
        if (tail != null) {
            tail = tail.getPrev();
            tail.setNext(null);
            listItem.setPrev(null);
        }
        return listItem;
    }


    public void removeHeadElement() {
        if (head != null) {
            head = head.getNext();
        }
    }

    public void removeTailElement() {
        if (tail != null) {
            tail = tail.getPrev();
            tail.setNext(null);
        }
    }

    public void addToHead(T data) {

    }

    public void addToTail(T data) {
        // TODO
    }

    public int getSize() {
        return size;
    }

    public ListItem<T> getHeadElement() {
        return head;
    }

    public ListItem<T> getTailElement() {
        return tail;
    }

    public boolean isEmpty() {
        return tail == null; //or head == null
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleLinkedList<T> that = (DoubleLinkedList<T>) o;
        return Objects.equals(head, that.head) && Objects.equals(tail, that.tail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail);
    }

    @Override
    public String toString() {
        if (head == null) {
            return "DoubleLinkedList is empty size = " + size;
        }

        StringBuilder stringBuilder = new StringBuilder(head.toString());
        ListItem<T> item = head;
        while (item.next != null) {
            if (item.next.prev == item) {
                stringBuilder.append("<-");
            }

            stringBuilder.append(" -> ").append(item.next);
            item = item.next;
        }

        return "DoubleLinkedList{size=" + size + "\n" + stringBuilder.toString() + "}";
    }
}