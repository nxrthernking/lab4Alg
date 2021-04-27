import java.util.Arrays;
import java.util.Objects;

public class CustomHashTable {
    public static final int CAPACITY = 100;
    int size = 0;
    private Node[] nodes = new Node[CAPACITY];

    public void add(int value){
        Node node = new Node(value);
        int index = hash(value);
        if(nodes[index] == null){
            nodes[index] = node;
        }else{
            Node iterator = nodes[index];
            while(iterator.next != null){
                iterator = iterator.next;
            }
            node.prev = iterator;
            iterator.next = node;

        }
    }


    public Node find(int value){
        int index = hash(value);
        Node node = nodes[index];
        if(node != null){
            if(node.value != value){
                Node iterator = node;
                while(iterator.next != null){
                    if(iterator.value == value){
                        return iterator;
                    }
                    iterator = iterator.next;
                }
            }else{
                return node;
            }
        }
        return null;
    }

    public void remove(int value){
        int index = hash(value);
        Node node = nodes[index];
        if(node != null){
            if(node.value == value){
                if(node.next != null){
                    nodes[index] = node.next;
                }else{
                    nodes[index] = null;
                }
            }else{
                Node iterator = node;
                while(iterator.next != null /*&& iterator.value != value*/){
                    if(iterator.value == value){
                        iterator.prev.next = iterator.next;
                        iterator.next.prev = iterator.prev;
                        iterator = null;
                        break;
                    }
                    iterator = iterator.next;
                }
            }
        }
    }

    private int hash(int value){
        return (value ^ 69) % CAPACITY ;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Arrays.stream(nodes)
                .filter(Objects::nonNull)
                .forEach(s -> result.append(s).append("\n"));
        return result.toString();
    }

    private static class Node{
        private int value;
        private Node next;
        private Node prev;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
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
