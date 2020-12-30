import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("main 함수 테스트")
    void main() throws IOException {
        BufferedReader br = mock(BufferedReader.class);
        when(br.readLine()).thenReturn("2 4", "1 2 3 4", "5 6 7 8");

        BufferedWriter bw = mock(BufferedWriter.class);
        ArgumentCaptor<String> bwCaptor = ArgumentCaptor.forClass(String.class);

        Main.main(br, bw);
        verify(bw, times(4)).write(bwCaptor.capture());
        List<String> output = bwCaptor.getAllValues();

        assertThat(output).isEqualTo(Arrays.asList(
                "[1, 2, 3, 4]", Main.lineSeparator,
                "[5, 6, 7, 8]", Main.lineSeparator
        ));
    }
}
