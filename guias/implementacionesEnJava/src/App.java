public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    public static boolean contiene( ) {
        int[] s = {2, 6, 3, 5, 8};
        int x = 5;
        int i = 0;
        while (i < s.length && s[i] != x) {
        i = i + 1;
        }
        return i < s.length;
    }
}
