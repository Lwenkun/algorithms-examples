package me.lwenkun;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            System.out.println(f);
            f = f + g;
            g = f - g;
        }

        System.out.println(lnN(232));

        float s = 0;
        for (int i = 1; i <= 232; i++) {
            s += Math.log(i);
        }

        System.out.println("s :" + s);

        Scanner si = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println(si.nextInt());
        }

        Stack<String> strings = new Stack<>();

        int a[] = new int[12];

        System.out.print(new String[3]);
        strings.push("I");
        strings.push("love");
        strings.push("China");
        strings.push(".");
        strings.push("and");
        strings.push("I");
        strings.push("love");
        strings.push("Japan");
        strings.push(",");
        strings.push("too");
        strings.push(".");

        strings.print();
    }


    public static double lnN(int N) {
        if (N == 1) {
            return Math.log((double)N);
        } else if (N > 1) {
            return Math.log((double)N) + lnN(N-1);
        } else {
            throw new IllegalArgumentException("N cannot less than or equal to 0");
        }

    }


}
