package org.example;

public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int capacity;

    private Entry<K, V>[] table;
    //Real size of table
    private int size;

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        this.table = (Entry<K, V>[]) new Entry[capacity];
    }

    private static class Entry<K, V> {
        private final K key;
        private V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    /**
     * 0x7fffffff ensures hash values are always positive
     * @param key
     * @param capacity
     * @return
     */
    private int hash(K key, int capacity) {
//        return (key.hashCode() & 0x7fffffff) % capacity;
        return (key.hashCode() & 0x7fffffff) & (capacity - 1); //Use bit AND operator, instead of mod(%) for better performance
    }

    public void put(K key, V value) {
        //Assume not null
        if (key == null) return;

        int index = hash(key, capacity);
        Entry<K, V> entry = table[index];

        while (entry != null) {
            if (entry.key.equals(key)) {
                entry.value = value; //Replace existing
                return;
            }
            entry = entry.next;
        }
        //Insert new entry to the beginning of table[index]
        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.next = table[index];
        table[index] = newEntry;
        //Resize
        size++;
        if (size > capacity * DEFAULT_LOAD_FACTOR)
            resize();
    }

    public V get(K key) {
        //Assume not null
        if (key == null) return null;

        int index = hash(key, capacity);
        Entry<K, V> entry = table[index];
        while (entry != null) {
            if (entry.key.equals(key)) return entry.value;
            entry = entry.next;
        }
        return null;
    }

    public void remove(K key) {
        //Assume not null
        if (key == null) return;
        int index = hash(key, capacity);
        Entry<K, V> entry = table[index];
        Entry<K, V> prev = null;
        while (entry != null) {
            if (entry.key.equals(key)) {
                if (prev == null) {
                    table[index] = entry.next;//skip current entry & point to next entry
                } else {
                    prev.next = entry.next;
                }
                size--;
                return;
            }
            prev = entry;
            entry = entry.next;
        }
    }

    private void resize() {
        int newCapacity = capacity * 2;
        Entry<K, V>[] newTable = new Entry[newCapacity];
        //Move current elements to newTable
        for(int i = 0; i < capacity; i++){
            Entry<K, V> entry = table[i];
            while (entry != null){
                Entry<K, V> next = entry.next;
                int newIndex = hash(entry.key, newCapacity);
                //Add to the beginning of newTable[newIndex]
                entry.next = newTable[newIndex];
                newTable[newIndex] = entry;
                entry = next; //Switch to old next entry
            }
        }
        table = newTable;
        capacity = newCapacity;
    }
}
