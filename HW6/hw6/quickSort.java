package hw6;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * quickSort class
 * 
 */
public class quickSort {
    myMap originalMap;
    myMap sortedMap;
    ArrayList<String> aux;

    /**
     * Default constructor
     * @param map
     */
    public quickSort(myMap map) {
        originalMap = map;
        sortedMap = new myMap(map.str);
        aux = new ArrayList<>();
        aux.addAll(originalMap.map.keySet());
        quickSortFunc(0, aux.size()-1);
        LinkedHashMap<String, info> sorted = new LinkedHashMap<>();
        for (String key : aux) {
            sorted.put(key, originalMap.map.get(key));
        }
        sortedMap.map = sorted;
    }

    private void quickSortFunc(int low, int high) {
        if (low < high) {
            int pi = quickSortFuncHelper(low, high);

            quickSortFunc(low, pi - 1);
            quickSortFunc(pi + 1, high);
        }
    }

    private int quickSortFuncHelper(int low, int high) {
        String pivot = aux.get(high);
        int i = (low - 1); 
        for (int j = low; j < high; j++) {
            if (originalMap.map.get(aux.get(j)).count <= originalMap.map.get(pivot).count) {
                i++;
                String temp = aux.get(i);
                aux.set(i, aux.get(j));
                aux.set(j, temp);
            }
        }
        String temp = aux.get(i+1);
        aux.set(i+1, aux.get(high));
        aux.set(high, temp);

        return i + 1;
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
        quickSortFunc(0, aux.size()-1);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
