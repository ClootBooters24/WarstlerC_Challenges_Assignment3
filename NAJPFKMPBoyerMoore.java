import java.util.*;

public class NAJPFKMPBoyerMoore {

    static List<Integer> occurences = new ArrayList<Integer>();

    public static void prefixSuffixArray(char[] pat, int M, int[] pps) {
        int length = 0;
        pps[0] = 0;
        int i = 1;
        while (i < M) {
            if (pat[i] == pat[length]) {
                length++;
                pps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = pps[length - 1];
                } else {
                    pps[i] = 0;
                    i++;
                }
            }
        }
    }

    public static void KMPAlgorithm(char[] text, char[] pattern) {
        int M = pattern.length;
        int N = text.length;
        int pps[] = new int[M];
        prefixSuffixArray(pattern, M, pps);
        int i = 0;
        int j = 0;
        while (i < N) {
            if (pattern[j] == text[i]) {
                j++;
                i++;
            }
            if (j == M) {
                occurences.add(i - j + 1);
                // System.out.println(i - j + 1);
                j = pps[j - 1];
            } else if (i < N && pattern[j] != text[i]) {
                if (j != 0) {
                    j = pps[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Your code here
        Scanner scanner = new Scanner(System.in);
        int numTests = scanner.nextInt();

        for (int i = 0; i < numTests; i++) {
            occurences.clear();
            String string = scanner.next();
            String pattern = scanner.next();
            char[] text = string.toCharArray();
            char[] pat = pattern.toCharArray();
            KMPAlgorithm(text, pat);
            
            if(occurences.size() > 0){
                System.out.println(occurences.size());
                for(int j = 0; j < occurences.size(); j++){
                    System.out.print(occurences.get(j) + " ");
                }
                System.out.println();
            } else {
                System.out.println("Not Found");
            }

            System.out.println();
        }

        scanner.close();
    }
}