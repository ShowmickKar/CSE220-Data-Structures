public class KeyIndex {
    int[] auxiliary, arr;
    int n, m = 0;

    public KeyIndex(int[] a) {
        n = a.length;
        for (int i = 0; i < a.length; i++) {
            if (Math.abs(a[i]) > m) m = Math.abs(a[i]);
        }
        auxiliary = new int[2 * m + 2];
        for (int e : a) {
            if (e >= 0) {
                auxiliary[e]++;
            } else {
                auxiliary[-e + m + 1]++;
            }
        }
    }

    public boolean search(int key) {
        return (key >= 0 ? (auxiliary[key] > 0) : (auxiliary[-key + m + 1] > 0));
    }

    public int[] sort() {
        int[] arr = new int[n];
        int p = 0;
        for (int i = auxiliary.length - 1; i > m; i--) {
            for (int j = 0; j < auxiliary[i]; j++) {
                arr[p] = m - i + 1;
                p++;
            }
        }
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j < auxiliary[i]; j++) {
                arr[p] = i;
                p++;
            }
        }
        return arr;
    }
}
