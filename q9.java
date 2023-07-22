import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> countMap = new HashMap<>(); // To store the frequency of integers in the current subarray
        int n = in.nextInt();
        int m = in.nextInt();
        int maxUnique = 0; // To store the maximum number of unique integers

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            // Add the new element to the end of the deque and update its frequency in the map
            deque.addLast(num);
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);

            // If the size of the deque exceeds m, remove the leftmost element and update its frequency
            if (deque.size() > m) {
                int leftNum = deque.removeFirst();
                countMap.put(leftNum, countMap.get(leftNum) - 1);
                if (countMap.get(leftNum) == 0) {
                    countMap.remove(leftNum);
                }
            }

            // Update the maximum number of unique integers found so far
            maxUnique = Math.max(maxUnique, countMap.size());
        }

        System.out.println(maxUnique);

        in.close();
    }
}
