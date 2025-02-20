import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        ArrayList<String> answer_list = new ArrayList<>();
        char lastChar = '-';
        int turn = 0;
        boolean check = true;

        for(; turn < words.length; ++turn){
            String w = words[turn];

            if(turn != 0) {
                //이전 문자와 같은지 확인
                if(w.charAt(0) != lastChar || answer_list.contains(w)){
                    check = false;
                    break;
                }
            }
            lastChar = w.charAt(w.length() - 1);
            answer_list.add(w);
        }

        if(!check) {
            answer[0] = turn % n + 1;
            answer[1] = turn / n + 1;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Solution T = new Solution();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine().replaceAll("[\\[\\]\"]", "");

        String[] arr = str.split(",\\s*");
        String[] words = new String[arr.length - 1];

        int n = Integer.parseInt(arr[0]);

        System.arraycopy(arr, 1, words, 0, arr.length - 1);

        int[] answer = T.solution(n, words);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(answer[0]).append(",").append(answer[1]).append("]");
        System.out.println(sb);
    }
}