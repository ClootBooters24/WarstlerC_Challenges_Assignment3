import java.util.*;

public class NAJPFStandard {
    public static void main(String[] args) {
        // Your code here
        Scanner scanner = new Scanner(System.in);
        int numTests = scanner.nextInt();
        
        for(int i = 0; i < numTests; i++){
            String string = scanner.next();
            String pattern = scanner.next();
            List<Integer> indices = new ArrayList<Integer>();
            int count = 0;

            for(int j = 0; j <= string.length() - pattern.length(); j++){
                if(string.substring(j, j + pattern.length()).equals(pattern)) {
                    indices.add(j + 1);
                    count++;
                }
            }
            
            if(count > 0){
                System.out.println(count);
                for(int j = 0; j < indices.size(); j++){
                    System.out.print(indices.get(j) + " ");
                }
                System.out.println();
            } else {
                System.out.println("Not Found");
            }

            if(i < numTests - 1){
                System.out.println();
            }
        }

        scanner.close();
    }
}