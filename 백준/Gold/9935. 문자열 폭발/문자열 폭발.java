import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String t = br.readLine();
        String bomb = br.readLine();
        int bombLength = bomb.length();
        Stack<Character> stack = new Stack<>();

        for (int j = 0; j < t.length(); j++) {
            char ss = t.charAt(j);
            stack.push(ss);
            
            // 폭탄 문자열과 일치하는 부분이면 제거
            if (stack.size() >= bombLength) {
                boolean isBomb = true;
                for (int i = 0; i < bombLength; i++) {
                    if (stack.elementAt(stack.size() - bombLength + i) != bomb.charAt(i)) {
                        isBomb = false;
                        break;
                    }
                }
                if (isBomb) {
                    for (int i = 0; i < bombLength; i++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            sb.reverse();
            System.out.println(sb.toString());
        }
    }
}