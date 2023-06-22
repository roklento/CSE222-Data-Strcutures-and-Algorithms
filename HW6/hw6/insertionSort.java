package hw6;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * insertionSort class
 * 
 */
public class insertionSort {
    myMap originalMap;
    myMap sortedMap;
    ArrayList<String> aux;

    /**
     * Default constructor
     * @param map
     */
    public insertionSort(myMap map) {
        originalMap = map;
        sortedMap = new myMap(map.str);
        aux = new ArrayList<>();
        aux.addAll(originalMap.map.keySet());
        insertionSortFunc();
        LinkedHashMap<String, info> sorted = new LinkedHashMap<>();
        for (String key : aux) {
            sorted.put(key, originalMap.map.get(key));
        }
        sortedMap.map = sorted;
    }

    private void insertionSortFunc() {
        int n = aux.size();
        for (int i = 1; i < n; ++i) {
            String key = aux.get(i);
            int j = i - 1;

            while (j >= 0 && originalMap.map.get(aux.get(j)).count > originalMap.map.get(key).count) {
                aux.set(j + 1, aux.get(j));
                j = j - 1;
            }
            aux.set(j + 1, key);
        }
    }

    protected void printSortedMap() {
        for (String key : sortedMap.map.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < sortedMap.map.get(key).words.length; i++) {
                sb.append(sortedMap.map.get(key).words[i]);
                if (i < sortedMap.map.get(key).words.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            System.out.println("Letter: " + key + " - Count: " + sortedMap.map.get(key).count + " - Words: " + sb.toString());
        }
    }

    protected long runSort() {
        long startTime = System.nanoTime();
        insertionSortFunc();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
