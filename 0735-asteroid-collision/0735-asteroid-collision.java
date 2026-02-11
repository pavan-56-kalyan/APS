class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                int top = stack.peek();
                if (top < -a) {
                    stack.pop();
                    continue;
                } else if (top == -a) {
                    stack.pop();
                }
                a = 0;
                break;
            }
            if (a != 0) {
                stack.push(a);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}