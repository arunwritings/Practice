package data_structures.strings.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore_981 {

    private final Map<String, TreeMap<Integer, String>> timeMap;

    public TimeBasedKeyValueStore_981() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) return "";
        TreeMap<Integer, String> timestamps = timeMap.get(key);
        Map.Entry<Integer, String> entry = timestamps.floorEntry(timestamp); // floorEntry(timestamp) is a method of the TreeMap class that returns the greatest entry (key-value pair) whose key is less than or equal to the specified timestamp
        return entry == null ? "" : entry.getValue();
    }

    public static void main(String[] args) {
        TimeBasedKeyValueStore_981 timeBasedKeyValueStore981 = new TimeBasedKeyValueStore_981();
        timeBasedKeyValueStore981.set("foo","bar",1);
        timeBasedKeyValueStore981.get("foo",1);
        timeBasedKeyValueStore981.get("foo",3);
    }
}
