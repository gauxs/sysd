package lld.multi_lvl_cache.Cache;

public interface Cache {
    void put(String key, String value);

    public String get(String key);

    public Integer getReadTime();

    public Integer getWriteTime();

    public String toString();
}