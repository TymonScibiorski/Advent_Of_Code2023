import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void splitToSubsets() {
        Assertions.assertArrayEquals(new String[]{"3 blue, 4 red", "1 red, 2 green, 6 blue", "2 green"}, Main.splitToSubsets("3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"));
        
    }
}