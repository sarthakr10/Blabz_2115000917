import java.util.*;

class ZeroSumSubarrays {
    public static List<int[]> findZeroSumSubarrays(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        int sum = 0;
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                for (int startIndex : map.get(sum)) {
                    result.add(new int[]{startIndex + 1, i});
                }
            }
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -7, 1, 2, -6, 1, 4, -2, 1};
        List<int[]> subarrays = findZeroSumSubarrays(nums);

        System.out.println("Subarrays with zero sum:");
        for (int[] subarray : subarrays) {
            System.out.println(Arrays.toString(subarray));
        }
    }
}
