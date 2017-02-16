package me.lwenkun;

/**
 * Created by lwenkun on 2017/2/14.
 */
public class Sort {

    private final static int b[] = {12,23,43,32,123,54,65,43,78,54,43,89,54,21,34,12,65,786,321,457,423,32,49,4,64,43,32,123,54,65,43,78,54,43,89};

    private static int[] test;

    private static int[] selectSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            exch(a, i, min);
        }

        return a;
    }

    private static void exch(int[] a, int src, int dest) {
        int temp = a[src];
        a[src] = a[dest];
        a[dest] = temp;
    }

    public static void main(String[] args) {

        test = new int[b.length];

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10000000; i++)
      // insertSort(test);
      //  selectSort(test);
        //shellSort(test);
            mergeSort(b, 0, b.length - 1);
          //  quickSort(b, 0, b.length - 1);
           // heapSort(b, 0, b.length -1);
        long resume = (System.currentTimeMillis() - startTime);

        for (int i = 0; i < b.length; i ++) {
            System.out.println(b[i]);
        }
        System.out.printf("resume %sms\n", resume);
    }

    private static int[] insertSort(int[] a) {
        for (int i = 1; i < a.length; i ++) {
            int key = a[i];
            for(int j = i - 1 ; j >= 0; j--) {
                if (a[j] > key) {
                    a[j + 1] = a[j];
                } else {
                    a[j + 1] = key;
                    break;
                }
            }
        }
        return a;

    }

    private static int[] shellSort(int[] a) {
        int h = 1;
        int N = a.length;
        while (h < N / 25) {
            h = h * 3 + 1;
        }
        while(h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i;j >= h && a[j] < a[j - h] ; j -= h) {
                    exch(a, j, j - h);
                }
            }
            h /= 3;
        }

        return a;
    }

    private static int[] mergeSort(int[] a, int low, int hi) {

        if (hi - low == 1) {
            if (test[low] > test[hi]) {
                exch(a, low, hi);
            }
            return a;
        } else if (low == hi) {
            return a;
        }

        int mid = low + (hi - low) / 2;//将数组分成两组


        mergeSort(a, low, mid);//对前一半数组进行排序
        mergeSort(a, mid + 1, hi);//对后一半数组进行排序

        merge(a, low, mid, hi);

        return a;
    }

    private static void merge(int[]a, int low, int mid, int hi) {

        int i = low;
        int j = mid + 1;

        for (int k = low; k <= hi; k++) {
            test[k] = b[k];
        }

        for (int k = 0; k < hi - low + 1; k++) {
            if (i > mid) {
                a[low + k] = test[j];
                j++;
            } else if (j > hi) {
                a[low + k] = test[i];
                i++;
            } else if (test[j] > test[i]) {
                a[low + k] = test[i];
                i++;
            } else {
                a[low + k] = test[j];
                j++;
            }
        }
    }

    private static void quickSort(int a[], int low, int hi) {

        if (low >= hi) return;

        int key = a[low];
        int leftIndex = low + 1;
        int rightIndex = hi;

        while (true) {

            while (leftIndex <= hi && a[leftIndex] <= key) {
                leftIndex++;
            }
            while (rightIndex >= low + 1 && a[rightIndex] >= key) {
                rightIndex--;
            }
            if (rightIndex <= leftIndex) {
                exch(a, low, rightIndex);
                break;
            }
            exch(a, rightIndex, leftIndex);
        }

        quickSort(a, low, rightIndex - 1);
        quickSort(a, rightIndex + 1, hi);

    }

    private static void heapSort(int a[], int low, int hi) {
        int N = hi - low + 1;
        int delta = low - 1;
        for (int i = N / 2; i >= 1; i--) {
            sink(a, i, N, delta);//delta 在这里指的是实际位置和堆中的逻辑位置的偏移量
        }

        while(N > 1) {
            exch(a, 1 + delta, N + delta);//将末尾的元素和最大元素交换，则最大元素的位置已经确定;同时对最小元素进行下沉操作，注意此时末尾的元素
            //已经不属于该堆了， 要将堆的大小减一
            sink(a, 1, --N, delta);
        }
    }

    private static void sink(int[] a, int k, int N, int delta) {
        while (k * 2 <= N) { // 只要有左子节点就可以继续尝试下称
            int j = k * 2; //假设左子节点最大
            if (k * 2 +1 <= N && a[k * 2 + 1 + delta] > a[k * 2 + delta]) j ++; //如果存在右子节点并且右子节点大于左子节点， 那么将j 指向右子节点
            if (a[k + delta] >= a[j + delta] ) break;//如果子节点没有一个比自己大， 那么就不必下沉了， 循环结束
            exch(a, k + delta, j + delta); // 与最大的子节点交换位置
            k = j;//重新将 k 指向该节点，继续下一次循环
        }
    }





    }



