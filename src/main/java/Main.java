import java.util.*;
import java.io.*;

class Main {
    static String lineSeparator = System.lineSeparator();

    static void main(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] board = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            bw.write(Arrays.toString(board[i]));
            bw.write(lineSeparator);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        main(br, bw);
        br.close();
        bw.flush();
        bw.close();
    }
}
