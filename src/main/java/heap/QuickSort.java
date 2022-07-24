package heap;

public class QuickSort {

    public void sort(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(a, p, r);
        sort(a, p, q - 1);
        sort(a, q + 1, r);
    }

    private int partition(int[] a, int start, int end) {
        int pivot = a[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (a[j] < pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, end);
        return i;
    }
    public static volatile int countNum = 0;
    public void swap(int[] a, int i, int j) {
        countNum++;
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
