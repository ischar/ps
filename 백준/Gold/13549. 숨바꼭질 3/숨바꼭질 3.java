import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        int MAX_NUM = 100000;
        int[] visited = new int[MAX_NUM+1];
        int ans = Integer.MAX_VALUE;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(N);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int[] nums = {x-1, x+1};
            if (x == K) {
                ans = Math.min(ans ,visited[K]);
            }
            if (0<= x*2 && x*2 <=MAX_NUM) {
                if (visited[x*2] == 0) {
                    visited[x*2] = visited[x];
                    queue.add(x*2);
                }
            }

            for (int num: nums) {
                if (0 <= num && num <= MAX_NUM) {
                    if (visited[num] == 0) {
                        visited[num] = visited[x]+1;
                        queue.add(num);
                    }
                }
            }
        }
        if (N == 1)
            ans--;
        System.out.println(ans);
    }
}