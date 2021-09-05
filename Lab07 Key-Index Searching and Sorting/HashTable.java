public class HashTable {
    int n, m;
    String[] keys;
    String[] values;

    public HashTable(String[] arr) {
        n = 9;
        m = n * 2;
        keys = new String[m];
        values = new String[m];
        for (int i = 0; i < arr.length; i++) {
            int key = hash(arr[i]);
            System.out.println("Hash of " + arr[i] + ": " + key);
            String val = arr[i];
            put(key, val);
        }
    }

    private int hash(String key) {
        int sumOfDigits = 0, consonants = 0;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (c <= 'Z' && c >= 'A') {
                if (c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
                    consonants++;
                }
            } else {
                try {
                    sumOfDigits += Integer.parseInt(String.valueOf(c));
                } catch (NumberFormatException e) {
                    System.err.println(e + ": " + c);
                }
            }
        }
        return (consonants * 24 + sumOfDigits) % 9;
    }

    public void put(int key, String val) {
        int i = key;
        while (i < keys.length && keys[i] != null) {
            if (Integer.parseInt(keys[i]) == key) {
                values[i] = val;
            }
            i++;
        }
        keys[i] = String.valueOf((char) key);
        values[i] = val;
    }

    public boolean search(String key) {
        for (int i = hash(key); keys[i] != null && i < keys.length; i++) {

            if (values[i] == key) {
                return true;
            }
        }
        return false;
    }
}
