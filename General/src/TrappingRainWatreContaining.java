import java.util.Arrays;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 *
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class TrappingRainWatreContaining {

    //this will only work if 0 in between every number
    public int waterContainIfZero(int[] height) {

        if(height == null){
            return 0;
        }

        int max = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0] = height[0];
        for(int i=1; i< height.length; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        rightMax[height.length-1] = height[height.length-1];
        for(int i=height.length-2; i>= 0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        System.out.println(Arrays.toString(height));
        System.out.println(Arrays.toString(leftMax));
        System.out.println(Arrays.toString(rightMax));
        for(int i=1; i< height.length; i++){
            max = max+ Math.min(leftMax[i], rightMax[i]) - height[i];
        }



        return max;
    }

    public static void main(String[] args) {
//        int max = new WaterContaining().maxArea(new int[]{1,8,6,2,5,4,8,3,7});
//        int max = new WaterContaining().waterContainIfZero(new int[]{0,1, 0, 2, 1, 0, 1,3, 2, 1, 2, 1});
        int max1 = new TrappingRainWatreContaining().waterContainIfZero(new int[]{0,1, 0, 2, 1, 0, 3, 2, 0, 1, 0, 2});
        System.out.println(max1);
    }


}
