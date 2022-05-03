package com.srihari.practice.hackerearth.algorithms.string_algorithms.basics_of_string_manipulation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @see <a href="https://www.hackerearth.com/practice/algorithms/string-algorithm/basics-of-string-manipulation/practice-problems/algorithm/unique-subsequence-264057c9/">Hacker Earth</a>
 *
 * Problem:
 *
 * You are given a string S that contains N characters.
 * Your task is to determine the maximum possible size of the subsequence T of S such that
 * no two adjacent characters in T are the same.
 *
 * Note: The string contains only lowercase English alphabets.
 *
 *
 * Input format:
 *
 * First line: A single integer T denoting the number of test cases
 * For each test case:
 * First line: Single integer N denoting the size of the string
 * Second line: S denoting the string
 *
 *
 * Output format:
 *
 * For each test case, print a single line containing one integer that represents
 * the maximum size of the subsequence that satisfies the provided condition.
 *
 * Constraints
 * 1<=T<=10power3
 * 1<=N<=10power5
 *
 * Note: The sum of N overall test cases do not exceed 10power6.
 *
 * Sample Input:
 *  2
 *  5
 *  ababa
 *  5
 *  aaaac
 *
 * Sample Output:
 *  5
 *  2
 *
 * Time Limit: 1
 * Memory Limit: 256
 * Source Limit:
 *
 *
 * Explanation:
 *
 * For the string  we can select the complete string as T, since no two adjacent characters are identical,
 * so answer is 5.
 *
 * For the string aaaac the maximum possible T which can be formed is ac so answer is 2.
 *
 * @author SRIHARI
 */

/* IMPORTANT: Multiple classes and nested static classes are supported */

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class UniqueSubsequences {
    public static void main(String[] args) throws Exception {
        // Write your code here
        String[] inputDataArr = readInputData();

        if (inputDataArr != null && inputDataArr.length > 0) {
            Integer[] outputArr = findOutput(inputDataArr);

            if(outputArr != null && outputArr.length > 0) {
                printOut(outputArr);
            }
        }
    }

    private static void printOut(Integer[] outputArr) {
        Arrays.asList(outputArr).forEach(System.out::println);
    }

    private static Integer[] findOutput(String[] inputDataArr) {
        Integer[] outputArr = new Integer[inputDataArr.length];

        for (int i = 0; i < inputDataArr.length; i++) {
            outputArr[i] = findUniqueSubsequences(inputDataArr[i]);
        }

        return outputArr;
    }

    private static Integer findUniqueSubsequences(String inputString) {
        int count = 0;

        if (inputString.length() > 1) {
            count++;
        }

        for (int i = 1; i < inputString.length(); i++) {
            if(inputString.charAt(i-1) != inputString.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    private static String[] readInputData() throws Exception {
        String[] inputDataArr = null;
        Scanner s = new Scanner(System.in);
        String noOfTestCasesStr = s.nextLine();

        if(noOfTestCasesStr != null && Integer.parseInt(noOfTestCasesStr) <= Math.pow(10, 5)) {
            Integer noOfTestCases = Integer.parseInt(noOfTestCasesStr);

            inputDataArr = new String[noOfTestCases];

            for (int i = 0; i < noOfTestCases; i++) {
                Long sizeOfInputData = Long.parseLong(s.nextLine());

                if (sizeOfInputData > Math.pow(10,3)) {
                    throw new Exception("test case size invalid");
                }
                String inputData = s.nextLine();
                if(sizeOfInputData == inputData.length()) {
                    inputDataArr[i] = inputData;
                } else {
                    throw new Exception("Input data text length miss match");
                }
            }
        } else {
            throw new Exception("No.of test cases size invalid");
        }

        return inputDataArr;
    }
}
