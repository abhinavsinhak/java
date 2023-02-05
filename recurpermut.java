class Solve {

    long maxArea(int A[], int len) {
        int start = 0;
        int end = len - 1;
        int max = 0;
        while (start < end) {
            int result = (end - start) * Math.min(height[start], height[end]);
            if (result > max) {
                max = result;
            }
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return max;

    }

}