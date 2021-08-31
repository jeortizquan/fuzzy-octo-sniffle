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
public class CodingExcercises {
    public static void main(String [] args) {
        ExerciseZero e0 = new ExerciseZero();
        System.out.println(e0.solution(new int[] {-1000000,-1,1,2,4,0}));

        ExerciseTwo e2 = new ExerciseTwo();
        System.out.println(e2.solution("abbabba"));
    }
}
