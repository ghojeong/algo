import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
  public static void main(String[] args) throws IOException {
    final IOUtil io = new IOUtil();

    final List<Number> list = io.readList().stream()
      .map(Number::new)
      .collect(Collectors.toList());

    final List<Number> sortedList = ListUtil.sorted(
      list, Comparator.comparingInt(Number::toInt)
    );

    io.writeln(ListUtil.joining(list, " - "));
    io.writeln(ListUtil.joining(sortedList, " _ "));

    io.flush();
    io.close();
  }

  private static final class Number {
    private final int value;

    public Number(String value) {
      this.value = Integer.parseInt(value);
    }

    public Number(int value) {
      this.value = value;
    }

    public int toInt() {
      return this.value;
    }

    @Override
    public String toString() {
      return String.valueOf(this.value);
    }
  }

  private static final class ListUtil {
    private ListUtil() {}

    private static String joining(List<?> list, String delimiter) {
      return list.stream().map(Object::toString).collect(Collectors.joining(delimiter));
    }

    private static <T> List<T> sorted(List<T> list, Comparator<T> comparator) {
      final List<T> result = new ArrayList<>(list);
      quickSort(result, comparator, 0, result.size() - 1);
      return result;
    }

    private static <T> void quickSort(List<T> list, Comparator<T> comparator, int low, int high) {
      if (low >= high) return;
      final int pivotIndex = partition(list, comparator, low, high);
      quickSort(list, comparator, low, pivotIndex - 1);
      quickSort(list, comparator, pivotIndex + 1, high);
    }

    private static <T> int partition(List<T> list, Comparator<T> comparator, int low, int high) {
      final T pivot = list.get(high);
      int i = low - 1;
      for (int j = low; j < high; j++) {
        if (comparator.compare(list.get(j), pivot) <= 0) {
          i++;
          final T tmp = list.get(i);
          list.set(i, list.get(j));
          list.set(j, tmp);
        }
      }
      final T tmp = list.get(i + 1);
      list.set(i + 1, list.get(high));
      list.set(high, tmp);
      return i + 1;
    }
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

    private void println(String str) throws IOException {
      write(str);
      write(LINE_SEPARATOR);
      flush();
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
