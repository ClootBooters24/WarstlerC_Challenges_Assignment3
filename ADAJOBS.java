import java.util.*;

public class ADAJOBS {
    public static void main(String[] args) {
        // Your code here
        Scanner scanner = new Scanner(System.in);
        Map<String, Boolean> todoList = new HashMap<>();
        int queries = scanner.nextInt();

        for(int i = 0; i < queries; i++) {
            Integer value = scanner.nextInt();
            String name = scanner.next();

            if(value == 0) {
                todoList.put(name, true);
            } else{
                boolean exists = checkSubstring(todoList, name);
                if(exists) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }                
        }

        scanner.close();
    }

    public static boolean checkSubstring(Map<String, Boolean> todoList, String query) {
        for(String job : todoList.keySet()) {
            if(job.contains(query) || query.contains(job)) {
                return true;
            }
        }
        return false;
    }
}