import java.util.HashMap;
import java.util.Map;

public class Generics<K, V> {
    K key;
    V value;

    Map<K, V> map = new HashMap<>();

    void printType(K key, V value) {
        map.put(key, value);
        System.out.println(map.get(key));
    }

}
