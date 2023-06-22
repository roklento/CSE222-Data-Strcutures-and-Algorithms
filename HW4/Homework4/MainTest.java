package Homework4;

class MainTest {
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        MuseumSecuritySystem test1 = new MuseumSecuritySystem("sibelgulmez", "[rac()ecar]", 74);
        System.out.println("Test1:");
        test1.userCheck();

        MuseumSecuritySystem test2 = new MuseumSecuritySystem("", "[rac()ecar]", 74);
        System.out.println("Test2:");
        test2.userCheck();

        MuseumSecuritySystem test3 = new MuseumSecuritySystem("sibel1", "[rac()ecar]", 74);
        System.out.println("Test3:");
        test3.userCheck();

        MuseumSecuritySystem test4 = new MuseumSecuritySystem("sibel", "pass[]", 74);
        System.out.println("Test4:");
        test4.userCheck();

        MuseumSecuritySystem test5 = new MuseumSecuritySystem("sibel", "abcdabcd", 74);
        System.out.println("Test5:");
        test5.userCheck();

        MuseumSecuritySystem test6 = new MuseumSecuritySystem("sibel", "[[[[]]]]", 74);
        System.out.println("Test6:");
        test6.userCheck();

        MuseumSecuritySystem test7 = new MuseumSecuritySystem("sibel", "[no](no)", 74);
        System.out.println("Test7:");
        test7.userCheck();

        MuseumSecuritySystem test8 = new MuseumSecuritySystem("sibel", "[rac()ecar]]", 74);
        System.out.println("Test8:");
        test8.userCheck();

        MuseumSecuritySystem test9 = new MuseumSecuritySystem("sibel", "[rac()ecars]", 74);
        System.out.println("Test9:");
        test9.userCheck();

        MuseumSecuritySystem test10 = new MuseumSecuritySystem("sibel", "[rac()ecar]", 5);
        System.out.println("Test10:");
        test10.userCheck();

        MuseumSecuritySystem test11 = new MuseumSecuritySystem("sibel", "[rac()ecar]", 35);
        System.out.println("Test11:");
        test11.userCheck();
    }
}


