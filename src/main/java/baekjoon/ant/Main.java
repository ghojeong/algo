package baekjoon.ant;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://www.acmicpc.net/problem/3048
public class Main {
    static class Ant {
        final char ch;
        final boolean isLeft;

        Ant(char ch, boolean isLeft) {
            this.ch = ch;
            this.isLeft = isLeft;
        }
    }

    static void main(List<Ant> ants, int times) {
        while (times-- > 0) {
            for (int i = 0; i < ants.size() - 1; i++) {
                if (ants.get(i).isLeft == true &&
                        ants.get(i + 1).isLeft == false) {
                    Collections.swap(ants, i, ++i);
                }
            }
        }
    }

    static void main(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        List<Ant> leftAnts = br.readLine().chars()
                .mapToObj(ch -> new Ant((char) ch, true))
                .collect(Collectors.toList());
        Collections.reverse(leftAnts);

        List<Ant> rightAnts = br.readLine().chars()
                .mapToObj(ch -> new Ant((char) ch, false))
                .collect(Collectors.toList());
        int times = Integer.parseInt(br.readLine());

        List<Ant> ants = Stream.concat(leftAnts.stream(), rightAnts.stream())
                .collect(Collectors.toList());

        main(ants, times);

        StringBuilder sb = new StringBuilder();
        ants.forEach(ant -> sb.append(ant.ch));
        bw.write(sb.toString());
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
