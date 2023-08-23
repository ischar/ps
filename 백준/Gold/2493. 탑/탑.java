import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] h = new int[N+1];
        HashMap<Integer, Integer> map = new HashMap<>();

        String[] s = br.readLine().split(" ");
        Deque<Integer> stack = new ArrayDeque<Integer>();

        for (int i=0; i<N; i++) {
            int num = Integer.parseInt(s[i]);
            h[i+1] = num;
            map.put(num, i+1);

            while (stack.size() != 0 && num > stack.peek())
                stack.pop();
            if (stack.size() != 0) sb.append(map.get(stack.peek())).append(" ");
            else sb.append(0).append(" ");
            stack.push(num);
        }

        System.out.println(sb);
    }
}