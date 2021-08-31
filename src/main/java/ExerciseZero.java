import java.util.*;

public class ExerciseZero {

    public int solution(int[] A) {
        Arrays.sort(A);// write your code in Java SE 8
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
