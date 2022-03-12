package lld.multi_lvl_cache.Cache;

import java.util.*;

public class LRUCache implements Cache {
    Integer readTime;
    Integer writeTime;
    Integer cacheLevel;
    Integer totalCapacity;
    Integer currentCapacity;

    Queue<String> orderingQ;
    HashMap<String, String> store;

    public LRUCache(Integer capacity, Integer readTime, Integer writeTime, Integer cacheLevel) {
        this.readTime = readTime;
        this.writeTime = writeTime;
        this.cacheLevel = cacheLevel;

        this.currentCapacity = 0;
        this.totalCapacity = capacity;

        this.orderingQ = new LinkedList<>();
        this.store = new HashMap<>();
    }

    public Integer getReadTime() {
        return this.readTime;
    }

    public Integer getWriteTime() {
        return this.writeTime;
    }

    public Integer getCacheLevel() {
        return cacheLevel;
    }

    public Integer getTotalCapacity() {
        return totalCapacity;
    }

    public Integer getCurrentCapacity() {
        return currentCapacity;
    }

    public void put(String key, String value) {
        String wasPresent = this.store.putIfAbsent(key, value);

        // previously existed, update operation
        if (wasPresent != null) {
            this.orderingQ.remove(key);
            this.orderingQ.add(key);
        } else {
            if (this.currentCapacity >= this.totalCapacity) {
                String oldestKey = this.orderingQ.poll();
                this.currentCapacity -= 1;
                this.store.remove(oldestKey);
            }

            this.currentCapacity += 1;
            this.orderingQ.add(key);
        }
    }

    public String get(String key) {
        String value = this.store.get(key);
        if (value != null) {
            this.orderingQ.remove(key);
            this.orderingQ.add(key);
        }

        return value;
    }

    public String toString() {
        String stats = "";
        stats += "Stats of cache level: " + this.cacheLevel + "\n";
        stats += "Current usage: " + Double.valueOf(this.currentCapacity) / Double.valueOf(this.totalCapacity) + "\n";
        return stats;
    }
}
