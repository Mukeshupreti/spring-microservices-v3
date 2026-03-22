HashMap
````java
class MyHashMap {
static class Node {
int hash;
String key;
String value;
Node next;
Node(int hash, String key, String value) {
this.hash = hash;
this.key = key;
this.value = value;
}
}

    Node[] table;
    int capacity = 16;
    float loadFactor = 0.75f;
    int size = 0;

    MyHashMap() {
        table = new Node[capacity];
    }

    void put(String key, String value) {
        int hash = key.hashCode() ^ (key.hashCode() >>> 16);
        int index = hash & (capacity - 1); // extract lower four digit (capcity=16)

        Node newNode = new Node(hash, key, value);

        Node head = table[index];
        if (head == null) {
            table[index] = newNode;
        } else {
            // handle collision: append to linked list
            Node current = head;
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value; // update existing
                    return;
                }
                current = current.next;
            }
            current.next = newNode;
        }
        size++;

        if (size > capacity * loadFactor) {
            resize();
        }
    }

    void resize() {
        capacity = capacity * 2;
        Node[] newTable = new Node[capacity];

        for (Node oldNode : table) {
            while (oldNode != null) {
                Node next = oldNode.next;

                int newIndex = oldNode.hash & (capacity - 1);

                oldNode.next = newTable[newIndex];
                newTable[newIndex] = oldNode;

                oldNode = next;
            }
        }
        table = newTable;
    }
}
