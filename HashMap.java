public class HashMap<K, V> {
    private static final int INITIAL_SIZE = 1 << 4;
    private static final int MAXIMUM_CAPACITY = 1 << 30;

    private Entry<K, V>[] hashTable;

    @SuppressWarnings("unchecked")
    public HashMap() {
        hashTable = new Entry[INITIAL_SIZE];

    }

    @SuppressWarnings("unchecked")
    HashMap(int capacity) {
        int tableSize = tableSizeFor(capacity);
        hashTable = new Entry[tableSize];
    }

    final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K k, V v) {
            this.key = k;
            this.value = v;
        }

        public K geKtKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

    }

    public boolean containsKey(K key) {
        int hashCode = Math.abs(key.hashCode() % hashTable.length);
        Entry<K, V> node = hashTable[hashCode];

        while (node != null) {
            if (node.key.equals(key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void remove(K key) {
        int hashCode = Math.abs(key.hashCode() % hashTable.length);
        Entry<K, V> node = hashTable[hashCode];
        Entry<K, V> previous = null;

        while (node != null) {
            if (node.key.equals(key)) {
                if (previous == null) {
                    hashTable[hashCode] = node.next;
                } else {
                    previous.next = node.next;
                }
                return;
            }
            previous = node;
            node = node.next;
        }
    }

    public void remove(K key, V value) {
        int hashCode = Math.abs(key.hashCode() % hashTable.length);
        Entry<K, V> node = hashTable[hashCode];
        Entry<K, V> previous = null;

        while (node != null) {
            if (node.key.equals(key) && node.value.equals(value)) {
                if (previous == null) {
                    // Removing the head of the linked list
                    hashTable[hashCode] = node.next;
                } else {
                    // Bypassing the node to remove it
                    previous.next = node.next;
                }
                return; // Key-value pair found and removed, exit the method
            }
            previous = node; // Move to the next node
            node = node.next;
        }
    }

    public int size() {
        int count = 0;
        for(Entry<K, V> node : hashTable) {
            while (node != null) {
                count++;
                node = node.next; 
            }
        }
        return count;
    }

    public void put(K key, V value) {
        int hashCode = Math.abs(key.hashCode() % hashTable.length);
        Entry<K, V> node = hashTable[hashCode];

        if (node == null) {
            hashTable[hashCode] = new Entry<>(key, value);
        } else {
            Entry<K, V> previousNode = node;
            while (node != null) {
                if (node.key == key) {
                    node.value = value;
                    return;
                }
                previousNode = node;
                node = node.next;
            }
            previousNode.next = new Entry<>(key, value);
        }
    }

    public V get(K key) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry<K, V> node = hashTable[hashCode];

        while (node != null) {
            if (node.key.equals(key)) {
                return (V) node.value;
            }
            node = node.next;
        }
        return null;
    }

    public void printAll() {
        for (int i = 0; i < hashTable.length; i++) {
            Entry<K, V> node = hashTable[i];
            while (node != null) {
                System.out.println("Key: " + node.key + ", Value: " + node.value);
                node = node.next;
            }
        }
    }

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>(7);

        map.put(1, "hi");
        map.put(2, "my");
        map.put(3, "name");
        map.put(4, "is");
        map.put(5, "Zaheer");
        map.put(6, "how");
        map.put(7, "are");
        map.put(8, "you");
        map.put(9, "friends");
        map.put(10, "?");

        System.out.println(map.size());

        System.out.println(map.containsKey(11));

        // map.printAll();

    }
}