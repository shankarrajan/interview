## Details
Programming Language: Java

## Description
1. Works based on [hashing](/hashing). 
1. Gets and puts value in O(1) complexity 
1. Values are stored in Map.Entry

## Working
### Parameters
1. Initial capacity
    1. Provided during creation of hash map. 
    1. Indicates the number of buckets to create. 
    1. Affects the iteration performance
    1. Default: 16
1. Load Factor
    1. Mentions when the bucket size should be doubled. 
    1. Lower load factor: multiple rehashing. (Capacity increase)
    1. Higher load factor: Multiple collisions causing higher lookup costs. 
    1. Default: .75

### Structure
Structure of class where the key value is stored
```java

static class Entry<K,V> implements Map.Entry<K,V> {
    final K key;
    V value;
    Entry<K,V> next;
    final int hash;
}


```
Structure of the array which stores the above class. 
```java
Entry[] table
```

### put(key, value)
1. hash= key.hashcode()
1. int i = indexFor(hash, table.length); //returns the value of the bucket where it is to be stored. 
1. Entry entry = table[i]
1. Set the value as the last entry in that entry linked list. 

### get(key)
1. hash= key.hashcode()
1. int i = indexFor(hash, table.length);
1. Entry entry = table[i]
1. Loop through entry and return entry.key == key

### resize
1. Create a old array of Entry (Entry[] oldTable = table)
1. Create a new array of Entry (Entry[] newTable = new Entry[newCapacity])
1. Copy oldTable to newTable (transfer(newTable))
1. Set threshold as newTable size * load factor

### Iteration
1. Loops through all the buckets, and all the values in each bucket
1. Affected by the bucket size (Hence Initial capacity should not be huge)
### Collisions
![Image with collsion](../Maps/hashmap_simplistic_withcollisions.gif) 


## Where to use
## Properties
1. Synchronization: Unsynchronized  (To synchronize: Map m = Collections.synchronizedMap(new HashMap(...)))
1. Failure Type: Fail- fast (Throws ConcurrentModificationException if modified by anything except iterator)
1. Null support: One null for key, and any number of null values 
1. Performance Tuning:    
    1. Initial Capacity: Number of buckets created at the start. Affects the iteration performance
    1. Load factor: T
1. Order of Data: Not maintained
1. Same key: Overwrites the value of the existing key. 

## External references
Official Code: http://www.docjar.com/html/api/java/util/HashMap.java.html
