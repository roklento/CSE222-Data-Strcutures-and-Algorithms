package hw7;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * mergeSort class
 * 
 */
public class mergeSort {
    myMap originalMap;
    myMap sortedMap;
    ArrayList<String> aux;

    /**
     * Default constructor
     * @param map
     */
    public mergeSort(myMap map) {
        originalMap = map;
        sortedMap = new myMap(map.str);
        aux = new ArrayList<>();
        aux.addAll(originalMap.map.keySet());
        mergeSortFunc(0, aux.size() - 1);
        LinkedHashMap<String, info> sorted = new LinkedHashMap<>();
        for (String key : aux) {
            sorted.put(key, originalMap.map.get(key));
        }
        sortedMap.map = sorted;
    }
    /**
     * 
     * @param low
     * @param high
     */
    private void mergeSortFunc(int low, int high) {
        if (high <= low) {
            return;
        }
    
        int mid = (low + high)/2;
        mergeSortFunc(low, mid);
        mergeSortFunc(mid + 1, high);
        
        ArrayList<String> left = new ArrayList<>(aux.subList(low, mid + 1));
        ArrayList<String> right = new ArrayList<>(aux.subList(mid + 1, high + 1));
    
        int i = 0;
        int j = 0;
        for (int k = low; k <= high; k++) {
            if (i >= left.size()) {
                aux.set(k, right.get(j++));
            } 
            else if (j >= right.size() || originalMap.map.get(left.get(i)).count <= originalMap.map.get(right.get(j)).count) {
                aux.set(k, left.get(i++));
            } 
            else {
                aux.set(k, right.get(j++));
            }
        }
    }
    /**
     * 
     */
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
        mergeSortFunc(0, aux.size() - 1);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
