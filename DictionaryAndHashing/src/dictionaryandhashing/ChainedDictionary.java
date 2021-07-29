package dictionaryandhashing;

public class ChainedDictionary<K, V> {

    private static final double LOAD_FACTOR = .75;
    private TableEntry<K, V>[] hashTable;
    private int numberOfEntries;

    public ChainedDictionary() {
        // don't be lazy like this in real life - use prime numbers is best
        hashTable = (TableEntry<K, V>[]) new TableEntry[11];
    }

    public V removeKey(K key) {
        int index = getHashIndex(key);
        if (hashTable[index] == null) {
            return null;
        }
        TableEntry<K, V> currentEntry = hashTable[index];
        if (key.equals(currentEntry.getKey())) {
            V value = currentEntry.getValue();
            hashTable[index] = currentEntry.getNext();
            return value;
        }

        while (currentEntry.getNext() != null) {
            if (key.equals(currentEntry.getNext().getKey())) {
                V value = currentEntry.getNext().getValue();
                currentEntry.setNext(currentEntry.getNext().getNext());
                return value;
            }
            currentEntry = currentEntry.getNext();
        }

        return null;

    }
    
    public boolean contains(K key){
        int index = getHashIndex(key);
        if (hashTable[index] == null) {
            return false;
        }
        TableEntry<K, V> currentEntry = hashTable[index];
        while (currentEntry != null) {
            if (key.equals(currentEntry.getKey())) {
                return true;
            }
            currentEntry = currentEntry.getNext();
        }
        return false;
    }

    public V getValue(K key) {
        int index = getHashIndex(key);
        if (hashTable[index] == null) {
            return null;
        }
        TableEntry<K, V> currentEntry = hashTable[index];
        while (currentEntry != null) {
            if (key.equals(currentEntry.getKey())) {
                return currentEntry.getValue();
            }
            currentEntry = currentEntry.getNext();
        }
        return null;
    }

    public V add(K key, V value) {
        int index = getHashIndex(key);
        if (hashTable[index] == null) {
            hashTable[index] = new TableEntry<K, V>(key, value);
            numberOfEntries++;
            checkForResize();
            return null;
        } else {
            TableEntry<K, V> currentEntry = hashTable[index];
            while (currentEntry != null) {
                if (currentEntry.getKey().equals(key)) {
                    V oldValue = currentEntry.getValue();
                    currentEntry.setValue(value);
                    return oldValue;
                }
                currentEntry = currentEntry.getNext();
            }
            hashTable[index] = new TableEntry<K, V>(key, value, hashTable[index]);
            numberOfEntries++;
            checkForResize();
            return null;
        }
    }

    private void checkForResize() {
        if (numberOfEntries > hashTable.length * LOAD_FACTOR) {
            TableEntry<K, V>[] oldHashTable = hashTable;
            // please use primes
            hashTable = (TableEntry<K, V>[]) new TableEntry[oldHashTable.length * 2];

            for (TableEntry<K, V> entry : oldHashTable) {
                TableEntry<K, V> currentEntry = entry;

                while (currentEntry != null) {
                    add(currentEntry.getKey(), currentEntry.getValue());
                    currentEntry = currentEntry.getNext();
                }
            }
        }
    }

    private int getHashIndex(K key) {
        int index = key.hashCode() % hashTable.length;
        if (index < 0) {
            index *= -1;
        }
        return index;
    }

    private static class TableEntry<S, T> {

        private S key;
        private T value;
        private TableEntry<S, T> next;

        public TableEntry(S key, T value) {
            this(key, value, null);
        }

        public TableEntry(S key, T value, TableEntry<S, T> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public S getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public TableEntry<S, T> getNext() {
            return next;
        }

        public void setNext(TableEntry<S, T> next) {
            this.next = next;
        }
    }
}
