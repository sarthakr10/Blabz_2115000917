import java.util.LinkedList;

class CustomHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] buckets;
    private int size;


    static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    public CustomHashMap() {
        buckets = new LinkedList[DEFAULT_CAPACITY];
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }


    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode() % DEFAULT_CAPACITY);
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        bucket.add(new Entry<>(key, value));
        size++;
    }


    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }


    public void remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                size--;
                return;
            }
        }
    }


    public int size() {
        return size;
    }


    public void printHashMap() {
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            if (!buckets[i].isEmpty()) {
                System.out.print("Bucket " + i + ": ");
                for (Entry<K, V> entry : buckets[i]) {
                    System.out.print("(" + entry.key + " -> " + entry.value + ") ");
                }
                System.out.println();
            }
        }
    }


    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);
        map.put("David", 40);

        System.out.println("Value for 'Bob': " + map.get("Bob"));

        map.remove("Charlie");
        System.out.println("Value for 'Charlie': " + map.get("Charlie"));

        map.put("Eve", 50);
        map.printHashMap();
    }
}
