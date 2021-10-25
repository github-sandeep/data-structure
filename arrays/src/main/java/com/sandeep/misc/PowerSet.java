package com.sandeep.misc;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public void subsetsUtil(int[] nums, List<Integer> curr, int index, List<List<Integer>> ans) {
        if(index == nums.length) {
            ans.add(curr);
            return;
        }
        subsetsUtil(nums, new ArrayList<>(curr), index+1, ans);
        curr.add(nums[index]);
        subsetsUtil(nums, new ArrayList<>(curr), index+1, ans);
    }

    public static void main(String args[]) {
        List<List<Integer>> ans = new ArrayList<>();
        new PowerSet().subsetsUtil(new int[]{1,2,3}, new ArrayList<>(), 0, ans);
        for(List<Integer> list: ans) {
            System.out.println(list);
        }
    }
}
