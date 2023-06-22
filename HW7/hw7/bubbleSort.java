package hw7;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * bubbleSort class
 * 
 */
public class bubbleSort {
    myMap originalMap;
    myMap sortedMap;
    ArrayList<String> aux;

    /**
     * Default constructor
     * @param map
     */
    public bubbleSort(myMap map) {
        originalMap = map;
        sortedMap = new myMap(map.str);
        aux = new ArrayList<>();
        aux.addAll(originalMap.map.keySet());
        bubbleSortFunc();
        LinkedHashMap<String, info> sorted = new LinkedHashMap<>();
        for (String key : aux) {
            sorted.put(key, originalMap.map.get(key));
        }
        sortedMap.map = sorted;
    }

    private void bubbleSortFunc() {
        int n = aux.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (originalMap.map.get(aux.get(j)).count > originalMap.map.get(aux.get(j+1)).count) {
                    String temp = aux.get(j);
                    aux.set(j, aux.get(j+1));
                    aux.set(j+1, temp);
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
        bubbleSortFunc();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
