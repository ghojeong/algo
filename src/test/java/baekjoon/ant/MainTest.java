package baekjoon.ant;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class MainTest {

    @Test
    void case_0() throws IOException {
        BufferedReader br = mock(BufferedReader.class);
        when(br.readLine()).thenReturn("3 3", "ABC", "DEF", "0");

        BufferedWriter bw = mock(BufferedWriter.class);
        ArgumentCaptor<String> bwCaptor = ArgumentCaptor.forClass(String.class);

        Main.main(br, bw);
        verify(bw, times(1)).write(bwCaptor.capture());
        List<String> output = bwCaptor.getAllValues();

        assertThat(output).isEqualTo(Arrays.asList("CBADEF"));
    }

    @Test
    void case_1() throws IOException {
        BufferedReader br = mock(BufferedReader.class);
        when(br.readLine()).thenReturn("3 3", "ABC", "DEF", "1");

        BufferedWriter bw = mock(BufferedWriter.class);
        ArgumentCaptor<String> bwCaptor = ArgumentCaptor.forClass(String.class);

        Main.main(br, bw);
        verify(bw, times(1)).write(bwCaptor.capture());
        List<String> output = bwCaptor.getAllValues();

        assertThat(output).isEqualTo(Arrays.asList("CBDAEF"));
    }

    @Test
    void case_2() throws IOException {
        BufferedReader br = mock(BufferedReader.class);
        when(br.readLine()).thenReturn("3 3", "ABC", "DEF", "2");

        BufferedWriter bw = mock(BufferedWriter.class);
        ArgumentCaptor<String> bwCaptor = ArgumentCaptor.forClass(String.class);

        Main.main(br, bw);
        verify(bw, times(1)).write(bwCaptor.capture());
        List<String> output = bwCaptor.getAllValues();

        assertThat(output).isEqualTo(Arrays.asList("CDBEAF"));
    }

    @Test
    void case_3() throws IOException {
        BufferedReader br = mock(BufferedReader.class);
        when(br.readLine()).thenReturn("3 4", "JLA", "CRUO", "3");

        BufferedWriter bw = mock(BufferedWriter.class);
        ArgumentCaptor<String> bwCaptor = ArgumentCaptor.forClass(String.class);

        Main.main(br, bw);
        verify(bw, times(1)).write(bwCaptor.capture());
        List<String> output = bwCaptor.getAllValues();

        assertThat(output).isEqualTo(Arrays.asList("CARLUJO"));
    }
}
