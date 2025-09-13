package MapsUsingHash;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Integer> set = new HashMap<>();
        set.put("John", 77);
        set.put("Doe", 99);

        System.out.println(set.get("John"));

        MapsUsingHash mapHash = new MapsUsingHash();
        mapHash.put("John", "Doe");
        mapHash.put("Edward", "Williams");
        mapHash.put("Praveen", "Pagadala");
        mapHash.put("Prakash", "Gantela");

        System.out.println(mapHash.get("Praveen"));
        mapHash.remove("John");
        System.out.println(mapHash.get("John"));

        MapUsingHashFinal<String, Integer> set1 = new MapUsingHashFinal<>();
        set1.put("John", 77);
        set1.put("Doe", 99);

        System.out.println(set.get("John"));
        System.out.println(set1.toString());
    }
}
