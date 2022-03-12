package lld.multi_lvl_cache.CacheManager;

import java.util.*;
import lld.multi_lvl_cache.Cache.*;

class CacheOperationResult {
    String value;
    Integer readTimeTaken;
    Integer writeTimeTaken;

    CacheOperationResult() {
        this.value = null;
        this.readTimeTaken = 0;
        this.writeTimeTaken = 0;
    }

    public String toString() {
        String res = "Operation Result: \n";
        res += "Read time taken: " + this.readTimeTaken + " | ";
        res += "Write time taken: " + this.writeTimeTaken;
        return res;
    }

    public Integer getReadTimeTaken() {
        return readTimeTaken;
    }

    public void setReadTimeTaken(Integer readTimeTaken) {
        this.readTimeTaken = readTimeTaken;
    }

    public Integer getWriteTimeTaken() {
        return writeTimeTaken;
    }

    public void setWriteTimeTaken(Integer writeTimeTaken) {
        this.writeTimeTaken = writeTimeTaken;
    }

    public String getValueFound() {
        return value;
    }

    public void setValueFound(String value) {
        this.value = value;
    }
}

public class CacheManager {
    Integer numberOfCaches;
    List<Cache> allCaches;
    Integer numOfOperationToTrack;
    Queue<Integer> lastNReadTime;
    Queue<Integer> lastNWriteTime;

    public CacheManager(Integer numOfCaches, Integer numOfOperation) {
        this.numberOfCaches = numOfCaches;
        this.allCaches = new ArrayList<Cache>(numOfCaches);
        for (Integer i = 0; i < this.numberOfCaches; i++) {
            this.allCaches.add(null);
        }
        this.numOfOperationToTrack = numOfOperation;
        this.lastNReadTime = new LinkedList<>();
        this.lastNWriteTime = new LinkedList<>();
    }

    // cachePrioerity can be from [0, numberOfCaches)
    public void addCache(Integer capacity, Integer readTime, Integer writeTime, Integer cachePriority) {
        this.allCaches.set(cachePriority, new LRUCache(capacity, readTime, writeTime, cachePriority));
    }

    private CacheOperationResult readLevel(String key, Integer curCacheLevel) {
        if (curCacheLevel == this.numberOfCaches) {
            return new CacheOperationResult();
        }

        CacheOperationResult result;
        Cache curCache = this.allCaches.get(curCacheLevel);
        String value = curCache.get(key);

        if (value == null) {
            result = readLevel(key, curCacheLevel + 1);
            if (result.getValueFound() != null) {
                curCache.put(key, result.getValueFound());
                result.setWriteTimeTaken(result.getWriteTimeTaken() + curCache.getWriteTime());
            }
        } else {
            result = new CacheOperationResult();
            result.value = value;
        }
        result.setReadTimeTaken(result.getReadTimeTaken() + curCache.getReadTime());

        return result;
    }

    public CacheOperationResult read(String key) {
        CacheOperationResult result = this.readLevel(key, 0);
        if (this.lastNReadTime.size() >= numOfOperationToTrack) {
            this.lastNReadTime.poll();
        }
        this.lastNReadTime.add(result.readTimeTaken);

        if (this.lastNWriteTime.size() >= numOfOperationToTrack) {
            this.lastNWriteTime.poll();
        }
        this.lastNWriteTime.add(result.writeTimeTaken);
        return result;
    }

    private CacheOperationResult writeLevel(String key, String writeValue, Integer curCacheLevel) {
        if (curCacheLevel == this.numberOfCaches) {
            return new CacheOperationResult();
        }

        CacheOperationResult result = writeLevel(key, writeValue, curCacheLevel + 1);

        Cache curCache = this.allCaches.get(curCacheLevel);
        String value = curCache.get(key);

        // value not present
        if (value == null || value != writeValue) {
            curCache.put(key, writeValue);
            result.setWriteTimeTaken(result.getWriteTimeTaken() + curCache.getWriteTime());
        }

        result.setReadTimeTaken(result.getReadTimeTaken() + curCache.getReadTime());

        return result;
    }

    public CacheOperationResult write(String key, String value) {
        CacheOperationResult result = this.writeLevel(key, value, 0);
        if (this.lastNReadTime.size() >= numOfOperationToTrack) {
            this.lastNReadTime.poll();
        }
        this.lastNReadTime.add(result.readTimeTaken);

        if (this.lastNWriteTime.size() >= numOfOperationToTrack) {
            this.lastNWriteTime.poll();
        }
        this.lastNWriteTime.add(result.writeTimeTaken);
        return result;
    }

    public void showStats() {
        for (Integer curCacheIndex = 0; curCacheIndex < this.numberOfCaches; curCacheIndex++) {
            System.out.println(this.allCaches.get(curCacheIndex));
        }

        Double avaerageReadTime = 0.0;
        for (Integer val : this.lastNReadTime) {
            avaerageReadTime += Double.valueOf(val);
        }
        System.out.println(
                "Average read time of last " + this.numOfOperationToTrack + " operations: "
                        + avaerageReadTime / Double.valueOf(this.lastNReadTime.size()));

        Double avaerageWriteTime = 0.0;
        for (Integer val : this.lastNWriteTime) {
            avaerageWriteTime += Double.valueOf(val);
        }
        System.out.println(
                "Average write time of last " + this.numOfOperationToTrack + " operations: "
                        + avaerageWriteTime / Double.valueOf(this.lastNWriteTime.size()));
    }
}
