package hw7;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * selectionSort class
 * 
 */
public class selectionSort {
    myMap originalMap;
    myMap sortedMap;
    ArrayList<String> aux;

    /**
     * Default constructor
     * @param map
     */
    public selectionSort(myMap map) {
        originalMap = map;
        sortedMap = new myMap(map.str);
        aux = new ArrayList<>();
        aux.addAll(originalMap.map.keySet());
        selectionSortFunc();
        LinkedHashMap<String, info> sorted = new LinkedHashMap<>();
        for (String key : aux) {
            sorted.put(key, originalMap.map.get(key));
        }
        sortedMap.map = sorted;
    }

    private void selectionSortFunc() {
        int n = aux.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (originalMap.map.get(aux.get(j)).count < originalMap.map.get(aux.get(minIndex)).count) {
                    minIndex = j;
                }
            }
            String temp = aux.get(minIndex);
            aux.set(minIndex, aux.get(i));
            aux.set(i, temp);
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
        selectionSortFunc();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}