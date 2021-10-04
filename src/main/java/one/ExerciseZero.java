package one;

import java.util.*;

/*
* Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
* */

public class ExerciseZero {

    public int solution(int[] A) {
        Arrays.sort(A);
        if (A[A.length - 1] < 0)
            return 1;
        else if (A[0] > 1) {
            return 1;
        } else {
            for (int i = 0; i < A.length - 1; i++) {
                if (A[i + 1] >0 && A[i]>0 && A[i + 1] - A[i] >= 2)
                    return A[i] + 1;
            }
            return A[A.length - 1] + 1;
        }
    }
}
