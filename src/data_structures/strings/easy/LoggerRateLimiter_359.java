package data_structures.strings.easy;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter_359 {

    private final Map<String, Integer> messageMap;

    public LoggerRateLimiter_359() {
        messageMap = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!messageMap.containsKey(message) || timestamp - messageMap.get(message) >= 10) {
            messageMap.put(message, timestamp);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LoggerRateLimiter_359 loggerRateLimiter359 = new LoggerRateLimiter_359();
        boolean result = loggerRateLimiter359.shouldPrintMessage(4, "Hi");
        System.out.println(result);
    }
}
