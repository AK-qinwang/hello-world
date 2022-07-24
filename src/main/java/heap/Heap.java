package heap;

import java.util.Objects;

public class Heap {
    private int[] a; // 数组，从下标1开始存储数据
    private int n;  // 堆可以存储的最大数据个数
    private int count; // 堆中已经存储的数据个数

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    /**
     * 从堆顶删除元素
     */
    public void removeMax() {
        //将堆顶元素和最后一位元素交换位置
        a[1] = a[count--];
        //然后对剩下的count - 1个元素进行堆化
        heapify(a, count - 1, 1);
    }

    /**
     * 插入操作
     *
     * @param data
     */
    public void insert(int data) {
        if (count >= n) {
            //堆满了
            return;
        }
        //新增了一个元素,数组中已存在的元素个数加1
        ++count;
        //将新的数据存入数组
        a[count] = data;
        //从 i 处开始,自下而上进行堆化
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            //元素交换位置
            swap(a, i, i / 2);
            //继续向上进行堆化
            i = i / 2;
        }
    }

    /**
     * 堆化操作,构建大顶堆
     *
     * @param a 待构建数组
     * @param n 数组的元素数量
     * @param i 从哪个位置开始执行堆化
     */
    public void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] <= a[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && a[maxPos] <= a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(a, maxPos, i);
            i = maxPos;
        }
    }

    public static volatile int countNum = 0;

    private void swap(int[] a, int i, int j) {
        countNum++;
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >= 1; --i) {
            heapify(a, n, i);
        }
    }

    /**
     * 数组堆排序
     * a：待排序数组
     * n：数组元素的个数
     * 思路:构建大顶堆,然后不断的从堆顶取元素,和数组的最后一个元素互换位置,之后进行堆化。堆化完成,再从堆顶取元素。持续进行此操作即可完成排序
     */
    public void heapSort(int[] a,int n) {
        if (Objects.nonNull(a)) {
            this.a = new int[n + 1];
            System.arraycopy(a, 0, this.a, 1, a.length);
            count = n;
        }
        //先建堆
        buildHeap(this.a, n);
        //从堆顶取元素放到数组末尾,然后对剩下的元素执行堆化操作,持续进行此操作即可。
        int k = count;
        while (k > 1) {
            swap(this.a, 1, k);
            --k;
            heapify(this.a, k, 1);
        }
    }

    public void print() {
        for (int i = 1; i < count + 1; i++) {
            System.out.println(a[i]);
        }
    }
}
