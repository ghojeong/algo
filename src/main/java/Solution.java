import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        final IOUtil io = new IOUtil();

        final String str = io.readLine();
        final List<String> list = io.readList();

        io.writeln(str);
        for (String el: list) {
            io.writeln(el);
        }

        io.flush();
        io.close();
    }

    private static final class IOUtil {
        private final String LINE_SEPARATOR = System.lineSeparator();
        private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        private String readLine() throws IOException {
            return br.readLine();
        }

        private List<String> readList() throws IOException {
            final List<String> list = new ArrayList<>();
            final StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                list.add(st.nextToken());
            }
            return list;
        }

        private void write(String str) throws IOException {
            bw.write(str);
        }

        private void writeln(String str) throws IOException {
            write(str);
            write(LINE_SEPARATOR);
        }

        private void flush() throws IOException {
            bw.flush();
        }

        private void close() throws IOException {
            br.close();
            bw.close();
        }
    }
}
