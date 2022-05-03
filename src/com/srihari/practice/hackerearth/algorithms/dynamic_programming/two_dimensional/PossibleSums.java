package com.srihari.practice.hackerearth.algorithms.dynamic_programming.two_dimensional;

import java.util.Scanner;

/**
 * @see <a href="https://www.hackerearth.com/practice/algorithms/dynamic-programming/2-dimensional/practice-problems/algorithm/possible-sums-5/">Haceker Earth</a>
 *
 * Problem:
 * Given an array A of N elements, find the number of distinct possible sums that
 * can be obtained by taking any number of elements from the array and adding them.
 *
 * Note that 0 can always be obtained by taking none.
 *
 * First line of the input contains number of test cases T. Each test case has two lines.
 * First line has N, the number of elements in the array followed by N values which are elements of the array.
 * For each test case, print a single line, the distinct possible sums that can be obtained.
 *
 * Constraints:
 * 1 <= T <= 10
 * 1 <= N <= 100
 * 0 <= A[i] <= 100 for 0 <= i < N
 *
 * Sample Input:
 * 3
 * 3
 * 1 2 3
 * 5
 * 5 1 3 2 7
 * 4
 * 1 2 4 8
 *
 * Sample Output:
 * 7
 * 19
 * 16
 *
 * Time Limit: 3
 *
 * Memory Limit: 256
 *
 * Source Limit:
 *
 * Explanation:
 *      For the test case 1: Possible values are 0, 1, 2, 3, 4, 5, 6.
 *      For the test case 2: All numbers between 0 and 18 inclusive.
 *      For the test case 3: All numbers between 0 and 15 inclusive.
 *
 * @author SRIHARI
 */

/* IMPORTANT: Multiple classes and nested static classes are supported */

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class PossibleSums {
    public static void main(String args[] ) throws Exception {
        String[] inputDataArr = readInputData();

        if (inputDataArr != null && inputDataArr.length > 0) {
            findOutput(inputDataArr);
        }
    }

    private static String[] readInputData() throws Exception {
        String[] inputDataArr = null;
        Scanner s = new Scanner(System.in);
        String noOfTestCasesStr = s.nextLine();

        if(noOfTestCasesStr != null && Integer.parseInt(noOfTestCasesStr) <= 10 && Integer.parseInt(noOfTestCasesStr) >= 1) {
            Integer noOfTestCases = Integer.parseInt(noOfTestCasesStr);

            inputDataArr = new String[noOfTestCases];

            for (int i = 0; i < noOfTestCases; i++) {
                Long sizeOfInputData = Long.parseLong(s.nextLine());

                if (sizeOfInputData <= 1 || sizeOfInputData >= 100) {
                    throw new Exception("test case size invalid");
                }
                String inputData = s.nextLine();
                inputDataArr[i] = inputData;
            }
        } else {
            throw new Exception("No.of test cases size invalid");
        }

        return inputDataArr;
    }

    private static void findOutput(String[] inputDataArr) throws Exception {
        for (int i = 0; i < inputDataArr.length; i++) {
            System.out.println(findPossibleSums(inputDataArr[i]));
        }
    }

    private static Long findPossibleSums(String s) throws Exception {
        Long sumValue = 1l;
        String[] inputDataArr = s.split(" ");

        for (String input: inputDataArr) {
            Long inputVal = Long.parseLong(input);
            if (inputVal >= 0 && inputVal <= 100) {
                sumValue = sumValue + inputVal;
            } else {
                throw new Exception("Constraints failed");
            }
        }

        return sumValue;
    }
}

