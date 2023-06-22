package hw7;

import java.util.LinkedHashMap;

/**
 * myMap class
 * 
 */
public class myMap {
    LinkedHashMap<String, info> map;
    int mapSize;
    String str;

    /**
     * Default constructor
     * @param str
     */
    public myMap(String str) {
        this.str = str;
        map = new LinkedHashMap<>();
        mapSize = 0;
        String[] words = str.split(" ");
        for (String word : words) {
            for (char letter : word.toCharArray()) {
                String letterStr = String.valueOf(letter);
                map.putIfAbsent(letterStr, new info());
                map.get(letterStr).push(word);
            }
        }
        mapSize = map.size();
    }
    /**
     * 
     */
    protected void printMap() {
        for (String key : map.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < map.get(key).words.length; i++) {
                sb.append(map.get(key).words[i]);
                if (i < map.get(key).words.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            System.out.println("Letter: " + key + " - Count: " + map.get(key).count + " - Words: " + sb.toString());
        }
    }
}
