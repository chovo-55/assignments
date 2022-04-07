package Creational.Prototype;

import java.util.Hashtable;
import java.util.Map;

public class Cache {
    private static Map<Long, Vitamin> vitaminsMap  = new Hashtable<>();

    public static Vitamin getType(Long Id) {
        Vitamin cachedVitamins = vitaminsMap.get(Id);
        return (Vitamin) cachedVitamins.clone();
    }

    public static void loadCache() {
        B b = new B();
        b.setId(1L);
        vitaminsMap.put(b.getId(),b);

        C c = new C();
        c.setId(2L);
        vitaminsMap.put(c.getId(),c);
    }
}
