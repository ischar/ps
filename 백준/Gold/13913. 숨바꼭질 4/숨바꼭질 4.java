import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        int MAX_NUM = 100000;
        int[][] visited = new int[MAX_NUM + 1][2];
        Queue<Integer> queue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        queue.add(N);
        visited[N][0] = 1;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            if (x == K) {
                System.out.println(visited[x][0] - 1);
                stack.push(x);
                int num = x;
                while(num != N) {
                    stack.push(visited[num][1]);
                    num = visited[num][1];
                }

                while (!stack.isEmpty())
                    System.out.print(stack.pop() + " ");
                break;
            }

            int[] nums = {x - 1, x + 1, x * 2};
            for (int num : nums) {
                if (0 <= num && num <= MAX_NUM && visited[num][0] == 0) {
                    visited[num][0] = visited[x][0] + 1;
                    visited[num][1] = x;
                    queue.add(num);
                }
            }
        }
    }
}