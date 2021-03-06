package baekjoon.p1076;
// https://www.acmicpc.net/problem/1076

import java.io.*;

class Main {
    private static final String lineSeparator = System.lineSeparator();

    private static class InputDto {
        final String color1;
        final String color2;
        final String color3;

        InputDto(String color1, String color2, String color3) {
            this.color1 = color1;
            this.color2 = color2;
            this.color3 = color3;
        }

        @Override
        public String toString() {
            return "color1='" + color1 + ", " +
                    ", color2='" + color2 + ", " +
                    ", color3='" + color3;
        }
    }

    private static enum Resistance {
        black(0),
        brown(1),
        red(2),
        orange(3),
        yellow(4),
        green(5),
        blue(6),
        violet(7),
        grey(8),
        white(9);

        final long value;
        final long multiplier;

        Resistance(long value) {
            this.value = value;
            long multiplier = 1;
            for (long i = 0; i < value; i++) {
                multiplier *= 10;
            }
            this.multiplier = multiplier;
        }
    }

    private static String solve(InputDto input) {
        Resistance r1 = Resistance.valueOf(input.color1);
        Resistance r2 = Resistance.valueOf(input.color2);
        Resistance r3 = Resistance.valueOf(input.color3);
        long solution = (r1.value * 10 + r2.value) * r3.multiplier;
        return Long.toString(solution);
    }

    private static void printFail(Object input, Object actual, Object expected) {
        System.err.println(lineSeparator);
        System.err.println("input: " + input);
        System.err.println("actual: " + actual);
        System.err.println("expected: " + expected);
    }

    private static void assertSolve(String expected, InputDto input) {
        String actual = solve(input);
        if (expected.equals(actual)) {
            return;
        }
        printFail(input, actual, expected);
    }

    private static void test() {
        assertSolve("4700", new InputDto("yellow", "violet", "red"));
    }

    private static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String color1 = br.readLine();
        String color2 = br.readLine();
        String color3 = br.readLine();
        InputDto input = new InputDto(color1, color2, color3);

        String output = solve(input);
        bw.write(output);

        br.close();
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        test();
        main();
    }
}
