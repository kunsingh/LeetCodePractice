import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Median {

    static double mx=10;
    public static int[] solution(int[] dataStream){
        PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> large = new PriorityQueue<>();
        boolean even = true;
        int[] result = new int[dataStream.length];
        result[0] = dataStream[0];
        for(int i=0;i<dataStream.length;i++) {
            if (even) {
                large.offer(dataStream[i]);
                small.offer(large.poll());
            } else {
                small.offer(dataStream[i]);
                large.offer(small.poll());
            }
            even = !even;

            if (even) {
                int num1 = small.peek();
                int num2 = large.peek();
                result[i] = num1 < num2 ? num1:num2;
            }
            else
                result[i] = small.peek();


        }

       return result;
    }

    private static PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    private static PriorityQueue<Integer> large = new PriorityQueue<>();
    private static boolean even = true;

    public static int findMedian() {
        if (even) {
            int num1 = small.peek();
            int num2 = large.peek();
            return num1 < num2 ? num1:num2;
        }
        else
            return small.peek();
    }

    public static void addNum(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'s', 'o', 's', 'o'},
                {'s', 'o', 'o', 's'},
                {'s', 's', 's', 's'}};
        System.out.println(solution(board, "sos"));
    }

    static  int solution(char[][] board, String word) {
        int matches=0;
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {
                String vertical = null;
                String horizontal = null;
                String diagonal = null;

                for (int letterWord = 0; letterWord < word.length(); letterWord++) {
                    if(j+letterWord <board[i].length) {
                        vertical = vertical + board[i][j + letterWord] + "";// run through the array horizontally
                    }
                    if(i+letterWord< board.length) {
                        horizontal = horizontal+board[i + letterWord][j] + ""; // run through the array vertically
                    }
                    if(i+letterWord< board.length && j+letterWord <board[i].length) {
                        diagonal = diagonal+board[i + letterWord][j + letterWord] + ""; // run through the array diagonally
                    }

                }

                if(vertical.contains(word)){
                    matches++;
                }
                if(horizontal.contains(word)){
                    matches++;
                }
                if(diagonal.contains(word)){
                    matches++;
                }
            }
        }

        return matches;
    }
}
