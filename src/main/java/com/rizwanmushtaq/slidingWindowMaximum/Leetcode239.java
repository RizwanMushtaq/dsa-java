package com.rizwanmushtaq.slidingWindowMaximum;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://leetcode.com/problems/sliding-window-maximum/
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * Return the max sliding window.
 * Example 1:
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -3 [5  3  6] 7       6
 *  1  3  -3  5 [3  6  7]       7
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 * Example 3:
 * Input: nums = [1,-1], k = 1
 * Output: [1,-1]
 */
public class Leetcode239 {
  public int[] solution(int[] nums, int k) {
    // assume nums is not null
    int n = nums.length;
    if (n == 0 || k == 0) {
      return new int[0];
    }

    Deque<Integer> deque = new ArrayDeque<>();
    int[] result = new int[nums.length - k + 1];

    for (int i = 0; i < nums.length; i++) {
      // remove indices from deque, which are not part of current window
      while (deque.size() > 0 && deque.getFirst() <= i - k) {
        deque.removeFirst();
      }
      // remove indices whose corresponding values are less than nums[i]
      while (deque.size() > 0 && nums[deque.getLast()] <= nums[i]) {
        deque.removeLast();
      }
      // add nums[i]
      deque.addLast(i);

      if (i >= k - 1) {
        result[i - k + 1] = nums[deque.getFirst()];
      }
    }

    return result;
  }
}
