import java.util.*;

class PairWithGivenSum {
    public static void findAllPairs(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        boolean found = false;

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numMap.containsKey(complement)) {
                System.out.println("Pair found: (" + complement + ", " + nums[i] + ")");
                found = true;
            }


            numMap.put(nums[i], i);
        }

        if (!found) {
            System.out.println("No pairs found.");
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 45, 6, 10, 8, 6, 10};
        int target = 16;

        findAllPairs(nums, target);
    }
}
