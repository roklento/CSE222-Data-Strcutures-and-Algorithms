package hw6;


/**
 * mainTest class
 * 
 */
public class mainTest3 {
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        run();
    }
    /**
     * 
     */
    public static void run() {
        // Example 1
        System.out.println("Example 1:");
        try {
            String input1 = "";
            String preprocessed1 = preprocess(input1);
            System.out.println("Original String: " + input1);
            System.out.println("Preprocessed String: " + preprocessed1);
            

            myMap myMap1 = new myMap(preprocessed1);
            System.out.println("\nThe original (unsorted) map:");
            myMap1.printMap();

            insertionSort insertionSort1 = new insertionSort(myMap1);
            System.out.println("\nThe sorted map:");
            insertionSort1.printSortedMap();

        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Example 2
        System.out.println("\nExample 2:");
        try {
            String input2 = "Buzzing bees buzz.";
            String preprocessed2 = preprocess(input2);
            System.out.println("Original String: " + input2);
            System.out.println("Preprocessed String: " + preprocessed2);

            myMap myMap2 = new myMap(preprocessed2);
            System.out.println("\nThe original (unsorted) map:");
            myMap2.printMap();

            insertionSort insertionSort2 = new insertionSort(myMap2);
            System.out.println("\nThe sorted map:");
            insertionSort2.printSortedMap();
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Example 3
        System.out.println("\nExample 3:");
        try {
            String input3 = "'Hush, hush!' whispered the rushing wind.";
            String preprocessed3 = preprocess(input3);
            System.out.println("Original String: " + input3);
            System.out.println("Preprocessed String: " + preprocessed3);

            myMap myMap3 = new myMap(preprocessed3);
            System.out.println("\nThe original (unsorted) map:");
            myMap3.printMap();

            insertionSort insertionSort3 = new insertionSort(myMap3);
            System.out.println("\nThe sorted map:");
            insertionSort3.printSortedMap();
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // time test for insertionSort
        System.out.println("\n-----------------------------------------");
        System.out.println("\nTime test for insertionSort:");
        warmup();
        bestCase();
        averageCase();
        worstCase();

    }
    /**
     * 
     * @param input
     * @return
     */
    private static String preprocess(String input) {
        // if input is null, return null
        if (input.equals("")) {
            System.out.println("Input is null.");
            return null;
        }
        String preprocessed = input.toLowerCase();
        preprocessed = preprocessed.replaceAll("[^a-z ]", "");
        return preprocessed;
    }

    private static void warmup() {
        for (int i = 0; i < 10000; i++) {
            // empty loop
        }
    }

    private static void bestCase() {
        long result = 0;
        System.out.println("\nbase case:");
        long time = 0;
        for (int i = 0; i < 1000; i++) {
            myMap myMap4 = new myMap(preprocess("d d c c c b b b a a a a "));
            insertionSort insertionSort4 = new insertionSort(myMap4);
            time = insertionSort4.runSort();
            result += time;
        }
        System.out.println("\ninput: d d c c c b b b a a a a");
        myMap myMap4 = new myMap(preprocess("d d c c c b b b a a a a"));
        insertionSort insertionSort4 = new insertionSort(myMap4);
        System.out.println("\nThe original (unsorted) map:");
        myMap4.printMap();
        System.out.println("\nThe sorted map:");
        insertionSort4.printSortedMap();
        System.out.println("\nAverage time for 1000 runs: " + result/1000 + " nanoseconds.");
    }

    private static void averageCase() {
        long result = 0;
        System.out.println("\naverage case:");
        long time = 0;
        for (int i = 0; i < 1000; i++) {
            myMap myMap4 = new myMap(preprocess("b b a a c d c a b d a c"));
            insertionSort insertionSort4 = new insertionSort(myMap4);
            time = insertionSort4.runSort();
            result += time;
        }
        System.out.println("\ninput: b b a a c d c a b d c");
        myMap myMap4 = new myMap(preprocess("b b a a c d c a b d a c"));
        insertionSort insertionSort4 = new insertionSort(myMap4);
        System.out.println("\nThe original (unsorted) map:");
        myMap4.printMap();
        System.out.println("\nThe sorted map:");
        insertionSort4.printSortedMap();
        System.out.println("\nAverage time for 1000 runs: " + result/1000 + " nanoseconds.");
    }
    
    private static void worstCase() {
        long result = 0;
        System.out.println("\nworst case:");
        long time = 0;
        for (int i = 0; i < 1000; i++) {
            myMap myMap4 = new myMap(preprocess("a a a a b b b c c c d d"));
            insertionSort insertionSort4 = new insertionSort(myMap4);
            time = insertionSort4.runSort();
            result += time;
        }
        System.out.println("\ninput: a a a a b b b c c c d d");
        myMap myMap4 = new myMap(preprocess("a a a a b b b c c c d d"));
        insertionSort insertionSort4 = new insertionSort(myMap4);
        System.out.println("\nThe original (unsorted) map:");
        myMap4.printMap();
        System.out.println("\nThe sorted map:");
        insertionSort4.printSortedMap();
        System.out.println("\nAverage time for 1000 runs: " + result/1000 + " nanoseconds.");
    }
    
}