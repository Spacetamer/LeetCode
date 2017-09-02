package binarySearch.GuressNumber;

public class Solution {
    public static int guessNumber(int n) {
        int left = 1, right = n;
        int guess = left + (right - left)/2;
        for (int result = guess(guess); result != 0; guess = left + (right - left)/2, result = guess(guess)) {
            System.out.println("Guess = "+guess+", Result = "+result);
            if (result == 1) left = guess + 1;
            else right = guess - 1;
        }

        return guess;
    }

    private static int guess(int n){
        int a = 1702766719;
        if (n < a) return 1;
        else if (n == a) return 0;
        else return -1;
    }

    public static void main(String[] args) {
        System.out.println(guessNumber(2126753390));
    }
}
