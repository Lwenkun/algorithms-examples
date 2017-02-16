package me.lwenkun;

import java.util.Arrays;

/**
 * Created by lwenkun on 2017/2/7.
 */
public class Stack<T> {

    private static final int DEF_SIZE = 10;

    private int size;

    private T[] value;

    @SuppressWarnings("unchecked")
    public Stack() {
        size = 0;
        value = (T[]) new Object[DEF_SIZE];
    }

    public T pop() {
        T v = peek();
        value[size - 1] = null;
        size--;
        return v;
    }

    public T peek() {
        return value[size - 1];
    }

    private void resize(int max) {
        value = Arrays.copyOf(value, max);
    }

    public void push(T item) {
        if (isFull()) {
            resize(2 * value.length);
        }

        value[size] = item;
        size++;
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return size == value.length;
    }

    public void print() {
        int size = size();
        for (int i = 0; i < size; i++) {
            System.out.println(pop().toString() + ", size : " + size());
        }

    }


}
