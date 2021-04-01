package stock.reader.utils;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class CalculateTest {

    private int[] intArray;

    @BeforeEach
    void setUp() {
        intArray = new int[]{13,55,9,120,88};
    }

    @Test
    void testGetMaxValue() {
        assertEquals(120, Calculate.getMaxValue(intArray));
    }

    @Test
    void testGetMinValue() {
        assertEquals(9, Calculate.getMinValue(intArray));
    }
}