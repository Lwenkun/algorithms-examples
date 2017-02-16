package me.lwenkun;

/**
 * Created by lwenkun on 2017/2/16.
 */
public class Heap<T extends Comparable<T>> {

    private T[] pq = (T[]) new Comparable[1];

    private int size = 0;

    private Heap(T[] a) {
        for (T v : a) {
            insert(v);
        }
    }

    public void insert(T v) {
        if (pq.length - 1 == size) resize( pq.length * 2);
        pq[++size] = v;
        swim(size);
    }

    public T max() {
        return pq[1];
    }

    public T delMax() {
        T v = max();
        exch(1, size);
        pq[size--] = null;
        if (size < pq.length / 4) resize(pq.length / 2);
        sink(1);
        return v;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean less(int a, int b) {
        return pq[a].compareTo(pq[b]) < 0;
    }

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k/2, k);
            k /= 2;
        }
    }

    private void resize(int size) {
        T[] temp = (T[]) new Comparable[size];
        for (int i = 1; i <= size(); i++ ) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    private void exch(int a, int b) {
        T temp = pq[a];
        pq[a] = pq[b];
        pq[b] = temp;
    }

    private void sink(int k) {
        while (2 * k <= size()) {
            int max = 2 * k;
            if (2 * k + 1 <= size() && less(2 * k, 2 * k + 1)) max ++;
            if (!less(k, max))break;
            exch(k, max);
            k = max;
        }
    }

    public static void main(String[] args) {
        String[] test = {"q", "u", "i", "c", "k", "s", "o", "r", "t"};
        Heap<String> myHeap = new Heap<>(test);
        for (int i = myHeap.size(); i > 0; i--) {
            System.out.println(myHeap.delMax());
        }
    }

}
