package baekjoon.ant;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static String lineSeparator = System.lineSeparator();

    static void swap(char[] output, int i, int j) {
        char temp = output[i];
        output[i] = output[j];
        output[j] = temp;
    }

    static void main(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        StringBuffer buffer = new StringBuffer();
        buffer.append(br.readLine());
        String left = buffer.reverse().toString();
        char[] output = (left + br.readLine()).toCharArray();
        int times = Integer.parseInt(br.readLine());

        swap(output, m, m - 1);

        bw.write(String.valueOf(output));
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
