package Creational.Prototype;

import java.util.Hashtable;

public class Cache {
    private static Hashtable<Long, Vitamins> vitaminsMap  = new Hashtable<>();

    public static Vitamins getType(Long Id) {
        Vitamins cachedVitamins = vitaminsMap.get(Id);
        return (Vitamins) cachedVitamins.clone();
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
