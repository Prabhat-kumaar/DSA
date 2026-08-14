class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int[] stack = new int[asteroids.length];
        int top = -1;

        for (int asteroid : asteroids) {
            boolean alive = true;

            while (alive && top >= 0 &&
                   stack[top] > 0 && asteroid < 0) {

                if (stack[top] < -asteroid) {
                    top--;
                } 
                else if (stack[top] == -asteroid) {
                    top--;
                    alive = false;
                } 
                else {
                    alive = false;
                }
            }

            if (alive) {
                stack[++top] = asteroid;
            }
        }

        return Arrays.copyOf(stack, top + 1);
    }
}