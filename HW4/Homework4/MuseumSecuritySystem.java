package Homework4;

import java.util.Stack;
/**
 * @startuml
 * interface username {
 *    +checkIfValidUsername(String username)
 *   +containsUserNameSpirit(String username, String password1)
 * }
 * interface password1 {
 *  +isBalancedPassword(String password)
 * +isPalindromePossible(String password1)
 * }
 * interface password2 {
 * +isExactDivision(int password2, int[] denominations)
 * }
 * class MuseumSecuritySystem {
 * -username
 * -password1
 * -password2
 * -denominations
 * +MuseumSecuritySystem(String username, String password1, int password2)
 * +MuseumSecuritySystem(String username, String password1, int password2, int[] denominations)
 * +userCheck()
 * }
 * MuseumSecuritySystem --|> username
 * MuseumSecuritySystem --|> password1
 * MuseumSecuritySystem --|> password2
 * @enduml
 */
class MuseumSecuritySystem implements username, password1, password2{
    private String username;
    private String password1;
    private int password2;
    private int[] denominations;
    /**
     * 
     * @param username
     * @param password1
     * @param password2
     */
    protected MuseumSecuritySystem(String username, String password1, int password2) {
        this.username = username;
        this.password1 = password1;
        this.password2 = password2;
        this.denominations = new int[]{4, 17, 29};
    }
    /**
     * 
     * @param username
     * @param password1
     * @param password2
     * @param denominations
     */
    protected MuseumSecuritySystem(String username, String password1, int password2, int[] denominations) {
        this.username = username;
        this.password1 = password1;
        this.password2 = password2;
        this.denominations = denominations;
    }
    /**
     * 
     */
    protected void userCheck() {
       
        if(checkIfValidUsername(username) && isBalancedPassword(password1) && containsUserNameSpirit(username, password1) && isPalindromePossible(password1) && isExactDivision(password2, denominations)) {
            System.out.println("The username and passwords are valid. The door is opening, please wait..");
            System.out.println("Welcome " + username + "!");
        }
    }
    /**
     * 
     */
    @Override
    public boolean checkIfValidUsername(String username) {
        if (username.isEmpty()) {
            System.out.println("The username is invalid. It should have at least 1 character.");
            return false;
        }
        return checkIfValidUsernameRecursive(username);
    }
    /**
     * 
     * @param username
     * @return
     */
    private boolean checkIfValidUsernameRecursive(String username) {
        if (username.isEmpty()) {
            return true;
        }
        if (!Character.isLetter(username.charAt(0))) {
            System.out.println("The username is invalid. It should have letters only");
            return false;
        }
        return checkIfValidUsernameRecursive(username.substring(1));
    }
    /**
     * 
     */
    @Override
    public boolean containsUserNameSpirit(String username, String password1) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < password1.length(); i++) {
            stack.push(password1.charAt(i));
            if (username.indexOf(password1.charAt(i)) != -1) {
                return true;
            }
        }
        System.out.println("The password1 is invalid. It should have at least 1 character from the username.");
        return false;
    }
    /**
     * 
     */
    @Override
    public boolean isBalancedPassword(String password) {
        if (!isValidLength(password)) {
            System.out.println("The password1 is invalid. It should have at least 8 characters.");
            return false;
        }
        if (!hasEnoughBrackets(password)) {
            System.out.println("The password1 is invalid. It should have at least 2 brackets.");
            return false;
        }
        if (!hasLetters(password)) {
            System.out.println("The password1 is invalid. It should have letters too.");
            return false;
        }
        if (!isBalancedBrackets(password)) {
            System.out.println("The password1 is invalid. It should be balanced.");
            return false;
        }
        return true;
    }
    /**
     * 
     * @param password
     * @return
     */
    private boolean isValidLength(String password) {
        return password.length() >= 8;
    }
    /**
     * 
     * @param password
     * @return
     */
    private boolean hasEnoughBrackets(String password) {
        return password.replaceAll("[^\\[\\]\\(\\)\\{\\}]", "").length() >= 2;
    }
    /**
     * 
     * @param password
     * @return
     */
    private boolean hasLetters(String password) {
        return !password.replaceAll("[a-zA-Z]", "").equals(password);
    }
    /**
     * 
     * @param password
     * @return
     */
    private boolean isBalancedBrackets(String password) {
        Stack<Character> stack = new Stack<>();
        for (char ch : password.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char openBracket = stack.pop();
                if ((ch == ')' && openBracket != '(') || (ch == '}' && openBracket != '{') || (ch == ']' && openBracket != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    /**
     * 
     */
    @Override
    public boolean isPalindromePossible(String password) {
        if(password1.isEmpty()) {
            return false;
        }
        String passwordWithoutBrackets = password1.replaceAll("[\\[\\]\\(\\)\\{\\}]", "");
        int[] charCounter = new int[60];
        return isPalindromePossibleRecursive(passwordWithoutBrackets, charCounter, 0, 0);
    }
    /**
     * 
     * @param password
     * @param charCounter
     * @param index
     * @param oddNumberCounter
     * @return
     */
    private boolean isPalindromePossibleRecursive(String password, int[] charCounter, int index, int oddNumberCounter) {
        if (index >= password.length()) {
            if (oddNumberCounter > 1) {
                System.out.println("The password1 is invalid. It should be possible to obtain a palindrome from the password1.");
                return false;
            }
            return oddNumberCounter <= 1;
        }
        int charIndex = password.charAt(index) - 65;
        charCounter[charIndex]++;
        int updatedoddNumberCounter;
        if (charCounter[charIndex] % 2 == 0) {
            updatedoddNumberCounter = oddNumberCounter - 1;
        } 
        else {
            updatedoddNumberCounter = oddNumberCounter + 1;
        }
        return isPalindromePossibleRecursive(password, charCounter, index + 1, updatedoddNumberCounter);
    }
    /**
     * 
     */
    @Override
    public boolean isExactDivision(int password2, int[] denominations) {
        if(password2 < 10 || password2 > 10000) {
            System.out.println("The password2 is invalid. It should be between 10 and 10000.");
            return false;
        }

        boolean result = isExactDivisionRecursive(password2, denominations, 0);

        if(!result) {
            System.out.println("The password2 is invalid. It is not compatible with the denominations.");
        }

        return result;
    }
    /**
     * 
     * @param password2
     * @param denominations
     * @param currentIndex
     * @return
     */
    private boolean isExactDivisionRecursive(int password2, int[] denominations, int currentIndex) {
        if (password2 == 0) {
            return true;
        }
        if (password2 < 0 || currentIndex >= denominations.length) {
            return false;
        }
        
        return isExactDivisionRecursive(password2 - denominations[currentIndex], denominations, currentIndex) || 
                isExactDivisionRecursive(password2, denominations, currentIndex + 1);
    }
}