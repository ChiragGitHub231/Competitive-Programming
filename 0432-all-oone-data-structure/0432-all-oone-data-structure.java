class Node {
    int frequency;
    Set<String> strings;
    Node previous, next;
    
    public Node(int frequency, Node previous, Node next){
        this.frequency = frequency;
        this.strings = new HashSet<>();
        this.previous = previous;
        this.next = next;
    }
}

class AllOne {
    
    private Node head, tail;
    private HashMap<String, Node> strings;

    public AllOne() {
        head = new Node(Integer.MIN_VALUE, null, null);
        tail = new Node(Integer.MAX_VALUE, null, null);
        head.next = tail;
        tail.previous = head;
        strings = new HashMap<>();
    }
    
    public void inc(String key) {
        if(!strings.containsKey(key)){
            if(head.next.frequency != 1){
                Node newNode = new Node(1, head, head.next);
                head.next.previous = newNode;
                head.next = newNode;
            }
            head.next.strings.add(key);
            strings.put(key, head.next);
        } else {
            Node node = strings.get(key);
            node.strings.remove(key);
            int nextFrequency = node.frequency + 1;
                
            if(node.next.frequency != nextFrequency){
                Node newNode = new Node(nextFrequency, node, node.next);
                node.next.previous = newNode;
                node.next = newNode;
            }
            node.next.strings.add(key);
            strings.put(key, node.next);
                
            if(node.strings.isEmpty()) removeNode(node);
        }
    }
    
    public void dec(String key) {
        Node node = strings.get(key);
        node.strings.remove(key);
        if(node.frequency == 1) strings.remove(key);
        else {
            int previousFrequency = node.frequency - 1;
            if(node.previous.frequency != previousFrequency){
                Node newNode = new Node(previousFrequency, node.previous, node);
                node.previous.next = newNode;
                node.previous = newNode;
            }
            node.previous.strings.add(key);
            strings.put(key, node.previous);
        }
        
        if(node.strings.isEmpty()) removeNode(node);
    }
    
    public String getMaxKey() {
        if(tail.previous == head) return "";
        Iterator<String> iterator = tail.previous.strings.iterator();
        return iterator.next();
    }
    
    public String getMinKey() {
        if(head.next == tail) return "";
        Iterator<String> iterator = head.next.strings.iterator();
        return iterator.next();
    }
    
    private void removeNode(Node node){
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */