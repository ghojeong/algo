package programmers.p64061;

// https://programmers.co.kr/learn/courses/30/lessons/64061

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        LinkedList<Integer> basket = new LinkedList<>();
        for (int move : moves) {
            answer += play(board, basket, move);
        }
        return answer;
    }

    public int play(int[][] board, LinkedList<Integer> basket, int move) {
        int item = pop(board, move);
        if (item == 0) {
            return 0;
        }
        return putAndBlow(basket, item) ? 2 : 0;
    }

    public int pop(int[][] board, int move) {
        move--;
        int i = -1;
        while (i < board.length - 1
                && board[++i][move] == 0) {}
        int item = board[i][move];
        board[i][move] = 0;
        return item;
    }

    public boolean putAndBlow(LinkedList<Integer> basket, int item) {
        if (basket.size() < 1) {
            basket.add(item);
            return false;
        }
        if (basket.getLast() == item) {
            basket.removeLast();
            return true;
        }
        basket.add(item);
        return false;
    }

    public static String lineSeparator = System.lineSeparator();

    private static class InputDto {
        final int[][] board;
        final int[] moves;

        InputDto(int[][] board, int[] moves) {
            this.board = board;
            this.moves = moves;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(lineSeparator);
            sb.append("board: {");
            sb.append(lineSeparator);
            for (int[] line : board) {
                sb.append(Arrays.toString(line));
                sb.append(lineSeparator);
            }
            sb.append("}, moves: ");
            sb.append(Arrays.toString(moves));
            return sb.toString();
        }
    }

    private static void printFail(Object input, Object actual, Object expected) {
        System.err.println(lineSeparator);
        System.err.println("input: " + input);
        System.err.println("actual: " + actual);
        System.err.println("expected: " + expected);
    }

    private static void assertSolution(InputDto input, int expected) {
        int actual = new Solution().solution(input.board, input.moves);
        if (expected == actual) {
            return;
        }
        printFail(input, actual, expected);
    }

    public static void main(String[] args) {
        assertSolution(new InputDto(
                new int[][]{
                        new int[]{0, 0, 0, 0, 0},
                        new int[]{0, 0, 1, 0, 3},
                        new int[]{0, 2, 5, 0, 1},
                        new int[]{4, 2, 4, 4, 2},
                        new int[]{3, 5, 1, 3, 1}
                },
                new int[]{1, 5, 3, 5, 1, 2, 1, 4}
        ), 4);
    }
}
