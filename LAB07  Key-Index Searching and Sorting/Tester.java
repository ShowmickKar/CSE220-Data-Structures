public class Tester {

    public static void main(String[] args) {
        String[] s = {"ST1E89B8A32"};
        HashTable m = new HashTable(s);
        System.out.println(m.search("ST1E89B8A32"));

        int[] a = new int[]{-10, 4, 5, 2, 7, 2, 8, 2, 8, 12, -5, -7, 0, 0, 4, 5, 4, 4, 3};
        KeyIndex k = new KeyIndex(a);
        System.out.println(k.search(-10)); // true
        System.out.println(k.search(10)); // false
        System.out.println(k.search(-1)); // false
        System.out.println(k.search(4)); // true
        System.out.println(k.search(6)); // false
        System.out.println(k.search(12)); // true
        System.out.println(k.search(-12)); // false

        int[] sortedArray = k.sort();
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i] + " ");
        }
        System.out.println();
    }
}
