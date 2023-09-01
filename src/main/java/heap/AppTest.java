package heap;

public class AppTest {
    public static void main(String[] args) {
        //快速排序
        int[] a1 = new int[]{7, 3, 9, 5, 2, 6, 8, 11, 13, 15, 17};
        //int[] a1 = new int[]{2, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(a1, 0, a1.length - 1);
        System.out.println(quickSort.countNum);
        //System.out.println(Arrays.toString(a1));
        //堆排序
        Heap heap = new Heap(11);
        int[] a2 = new int[]{7, 3, 9, 5, 2, 6, 8, 11, 13, 15, 17};
        //int[] a2 = new int[]{2, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21};
        heap.heapSort(a2,a2.length);
        System.out.println(heap.countNum);
        //heap.print();
        System.out.println("I change something");
    }
}
