package com.srihari.practice.hackerearth.codemonk.arrays_and_strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @see <a https://<a href="www.hackerearth.com/practice/codemonk/">Hacker Earth</a>
 *
 * Monk and Rotation:
 * Monk loves to preform different operations on arrays, and so being the principal of Hackerearth School,
 * he assigned a task to his new student Mishki.
 * Mishki will be provided with an integer array A of size N and an integer K ,
 * where she needs to rotate the array in the right direction by K steps and then print the resultant array.
 * As she is new to the school, please help her to complete the task.
 *
 *
 * Input:
 * The first line will consist of one integer T denoting the number of test cases.
 * For each test case:
 * 1) The first line consists of two integers N and K, N being the number of elements in the array
 * and K denotes the number of steps of rotation.
 * 2) The next line consists of N space separated integers , denoting the elements of the array A.
 *
 *
 * Output:
 * Print the required array.
 *
 * Constraints:
 * 1<= T <= 20
 * 1 <= N <= 10power5
 * 0 <= K <= 10power6
 * 0 <= A[i] <= 10power6
 *
 *
 *
 * Sample Input:
 * 1
 * 5 2
 * 1 2 3 4 5
 *
 * Sample Output:
 * 4 5 1 2 3
 *
 * Explanation:
 * Here T is 1, which means one test case.
 * N = 5 denoting the number of elements in the array and K = 2, denoting the number of steps of rotations.
 * The initial array is: 1, 2, 3, 4, 5
 * In first rotation, 5 will come in the first position and all other elements will move to one position ahead from
 * their current position. Now, the resultant array will be 5, 1, 2, 3, 4
 * In second rotation, 4 will come in the first position and all other elements will move to one position ahead from
 * their current position. Now, the resultant array will be 4, 5, 1, 2, 3
 *
 * Time Limit: 1.0 sec(s) for each input file
 * Memory Limit: 256 MB
 * Source Limit: 1024 KB
 *
 * @author SRIHARI
 */

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class MonkAndRotation {
    public static void main(String[] args) throws Exception {

        MonkAndRotation tc = new MonkAndRotation();

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());                // Reading input from STDIN

        //loop to read test cases
        if(1 <= t && t <=20) {
            for(int i = 0; i < t; i++) {
                Integer[] configArray = tc.splitInputData(br.readLine());
                Integer[] dataArray = tc.splitInputData(br.readLine());

                int n = configArray[0];
                int k = configArray[1];

                if((1 <= n && n <= java.lang.Math.pow(10, 5)) && (0 <= k && k <= java.lang.Math.pow(10, 6))) {
                    tc.rotateAndPrint(dataArray, k);

                }
            }
        }

    }

    public void rotateAndPrint(Integer[] dataArray, int rotationCount) {
        Integer[] temp = new Integer[dataArray.length];

        //rotate Array
        for(int i = 0; i < rotationCount; i++) {
            for(int j = 0; j < dataArray.length-1; j++) {
                if(j == 0) {
                    temp[j] = dataArray[dataArray.length-1];
                }

                temp[j+1] = dataArray[j];
            }

            if(temp.length > 1) {
                copyArray1to2(temp, dataArray);
            }
        }

        //print Array
        printArray(dataArray);

    }

    public Integer[] splitInputData(String input) {
        Integer[] returnArray;
        String[] inputStrArray = input.split(" ");
        returnArray = new Integer[inputStrArray.length];
        returnArray = copyArray1to2(inputStrArray, returnArray);

        return returnArray;
    }

    public void printArray(Integer[] dataArray) {
        for(int i = 0; i < dataArray.length; i++) {
            System.out.print(dataArray[i]);

            if(i != dataArray.length-1) {
                System.out.print(" ");
            } else {
                System.out.println();
            }
        }

    }

    public void copyArray1to2(Integer[] copyData, Integer[] pasteData) {
        System.arraycopy(copyData, 0, pasteData, 0, copyData.length);
    }

    public Integer[] copyArray1to2(String[] copyData, Integer[] pasteData) {
        for(int i = 0; i < copyData.length; i++) {
            pasteData[i] = Integer.parseInt(copyData[i]);
        }

        return pasteData;
    }
}