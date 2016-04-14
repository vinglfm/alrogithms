package com.algorithms;

import java.util.Scanner;

public class MultiplicationProvider {

    public int multiplyBySeven(int number) {
        return (number << 3) - number;
    }

    public static void main(String[] args) {
        System.out.print("Enter number to multiply by seven: ");

        MultiplicationProvider multiplicationProvider = new MultiplicationProvider();

        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        System.out.print("Result of multiplication: " + multiplicationProvider.multiplyBySeven(number));
    }
}
