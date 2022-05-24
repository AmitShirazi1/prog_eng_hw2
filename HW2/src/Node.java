public class Node {
    private Expression value;
    private Node next;

    public Node(Expression value, Node next) {
        this.value = value;
        this.next = next;
    }
    public Node(Expression value) { this(value, null); }
    public Expression getValue() { return value; }
    public Node getNext() { return next; }
    public void setValue(Expression value) { this.value = value; }
    public void setNext(Node next) { this.next = next; }
}
