public class Tester {

    public static void main(String[] args) {
        System.out.println("####################################");
        System.out.println("Testing the KeyIndex class:");
        System.out.println("####################################");
        int[] a = new int[]{-10, 4, 5, 2, 7, 2, 8, 2, 8, 12, -5, -7, 0, 0, 4, 5, 4, 4, 3};
        KeyIndex k = new KeyIndex(a);
        System.out.println("Testing the KeyIndex search method:");
        System.out.println(k.search(-10)); // true
        System.out.println(k.search(10)); // false
        System.out.println(k.search(-1)); // false
        System.out.println(k.search(4)); // true
        System.out.println(k.search(6)); // false
        System.out.println(k.search(12)); // true
        System.out.println(k.search(-12)); // false
        System.out.println("Testing the KeyIndex sort/Counting Sort Method:");
        int[] sortedArray = k.sort();
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i] + " ");
        }
        System.out.println("\n");
        System.out.println("####################################");
        System.out.println("Testing the HashTable search method:");
        System.out.println("####################################");
        System.out.println("For the following values the search method should return true:");
        String[] s = new String[]{"ARXW37WV9", "48A4YL4OF", "59EDMAEYZ", "SXI8GOEUB", "I8AJF84O2", "5ZPDPHS83", "1C97E966C", "8OPLK3XQA", "24HKDYBQM", "XEZCC6OX4"};
        HashTable m = new HashTable(s);
        for (String S : s) {
            System.out.println(m.search(S));
        }
        System.out.println("The following inputs are dummy values and not present in the hashtable, so they should return false");
        String[] dummyValues = new String[]{"UIU8PP98Y", "PPOPPW21U", "89EDKAE65"};
        for (String S : dummyValues) {
            System.out.println(m.search(S));
        }
    }
}
