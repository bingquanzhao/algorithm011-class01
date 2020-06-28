package org.example;

import java.util.Stack;

public class Rain {
    public int trap(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1 ; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int j = i; j >= 0 ; j--) {
                leftMax = Math.max(leftMax,height[j]);
            }
            for (int j = i; j < size ; j++) {
                rightMax = Math.max(rightMax,height[j]);
            }
            //用左右两边的最小值前驱自身高度可得蓄水高度
            ans += Math.min(leftMax,rightMax) - height[i];
        }
        return ans;

    }

    /**
     * 先将左右两边的最大值求出来，就不用在遍历时去求
     * @param height
     * @return
     */
    public int trapV2(int[] height) {
        if (height == null) return 0;
        int ans = 0;
        int size = height.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        leftMax[0] = height[0];
        for (int i = 1; i < size ; i++) {
            leftMax[i] = Math.max(height[i],leftMax[i - 1]);
        }
        rightMax[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0 ; i--) {
            rightMax[i] = Math.max(height[i],rightMax[i + 1]);
        }
        for (int i = 1; i < size - 1 ; i++) {
            ans += Math.min(leftMax[i],rightMax[i]) - height[i];
        }
        return ans;
    }

    public int trapV3(int[] height) {
        Stack<Integer> st = new Stack<>();
        int i = 0 ,ans = 0;
        while (i < height.length){
            //若栈为空 或者当前位置高度大于栈peek出数据(前一个位置的高度时)的高度时
            while(!st.empty() && height[i] > height[st.peek()]){
                int top = st.pop();
                if(st.empty()){
                    break;
                }
                int distance = i - st.peek() - 1;
                int bounded_height = Math.min(height[i],height[st.peek()]) - height[top];
                ans += distance * bounded_height;

            }
            st.push(i++);
        }
        return ans;
    }



}

