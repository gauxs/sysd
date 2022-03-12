package lld.multi_lvl_cache;

import lld.multi_lvl_cache.CacheManager.CacheManager;

public class Main {
    public static void main(String[] args) {
        Integer numOfCaches = 3;
        CacheManager cm = new CacheManager(numOfCaches, 10);

        cm.addCache(2, 5, 10, 0);
        cm.addCache(4, 10, 15, 1);
        cm.addCache(3, 15, 20, 2);

        System.out.println(cm.write("a", "b"));
        System.out.println(cm.write("g", "h"));
        System.out.println(cm.write("c", "d"));
        System.out.println(cm.read("a"));
        System.out.println(cm.write("e", "f"));
        System.out.println(cm.read("g"));
        cm.showStats();
    }
}
