public class Node {

    Integer priority;
    Object value;

    public Node(Integer priority, Object value) {
        this.priority = priority;
        this.value = value;
    }

    public Node(Integer value) {
        this.priority = value;
        this.value = value;
    }
}
