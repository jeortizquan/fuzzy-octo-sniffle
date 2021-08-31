public class ExerciseTwo {


    public int solution(String S) {
        int result = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            String prefix = S.substring(0, i);
            String suffix = S.substring(S.length() - i);

            if (prefix.length() == suffix.length() && prefix.equals(suffix)) {
                result = prefix.length();
                break;
            }
        }
        return result;
    }
}
