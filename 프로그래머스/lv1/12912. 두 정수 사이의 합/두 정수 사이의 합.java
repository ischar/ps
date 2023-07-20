class Solution {
    public long solution(int a, int b) {
        
        if (a > b) {
            int tmp = b;
            b = a;
            a = tmp;
        }
        
        long answer = 0;
        
        for (int i = a; i <=b; i++)
            answer += i;
        
        return answer;
    }
}