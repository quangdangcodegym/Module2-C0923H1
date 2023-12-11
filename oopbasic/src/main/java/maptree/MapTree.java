package maptree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTree {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("uQuang", "1");
        map.put("aQuang", "2");
        map.put("cQuang", "3");
        map.put("av", "adv");
        map.put("1", "1");



        System.out.println(map.get(1));
    }
}
