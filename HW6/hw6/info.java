package hw6;

/**
 * info class
 * 
 */
public class info {
    int count;
    String[] words;

    /**
     * Default constructor
     * 
     */
    public info() {
        count = 0;
        words = new String[0];
    }
    /**
     * 
     * @param word
     */
    public void push(String word) {
        String[] newWords = new String[words.length + 1];
        System.arraycopy(words, 0, newWords, 0, words.length);
        newWords[words.length] = word;
        words = newWords;
        count++;
    }
}
