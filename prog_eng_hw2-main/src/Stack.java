public class Stack<E> {
    private Node<E> head;
    public Stack() { head = null; }

    public void push(E item) {
        Node<E> newHead = new Node<E>(item);
        newHead.setNext(head);
        head = newHead;
    }
    public E pop() {
        if (head == null) {
            return null;
        }
        E item = head.getValue();
        head = head.getNext();
        return item;
    }
        public E peek() {
            if (head == null) {
                return null;
            }
            return head.getValue();
        }
        public boolean isEmpty() {
            return head == null;
        }
    }