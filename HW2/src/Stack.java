public class Stack {
    private Node head;

    public Stack() { this.head = null; }

    public void push(Expression item) {
        Node newHead = new Node(item);
        newHead.setNext(this.head);
        this.head = newHead;
    }
    public Expression pop() {
        if (this.head == null) {
            return null;
        }
        Expression item = (Expression) this.head.getValue();
        this.head = this.head.getNext();
        return item;
    }
    public Expression peek() {
        if (this.head == null) {
            return null;
        }
        return (Expression) this.head.getValue();
    }
    public boolean isEmpty() {
        return this.head == null;
    }
}