import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Dec2HexTest {

	@Test
	public void testPositiveIntegers() {
		// Test converting positive integers to hexadecimal
		assertEquals("0", converter.main(new String[]{"0"}), "Test converting zero");
		assertEquals("1", converter.main(new String[]{"1"}), "Test converting one");
		assertEquals("A", converter.main(new String[]{"10"}), "Test converting ten");
		assertEquals("FF", converter.main(new String[]{"255"}), "Test converting 255");
	}

	@Test
	public void testNegativeIntegers() {
		// Test converting negative integers to hexadecimal
		assertEquals("80000000", converter.main(new String[]{"-2147483648"}), "Test converting -2^31");
		assertEquals("FFFFFFFF", converter.main(new String[]{"2147483647"}), "Test converting 2^31-1");
	}

	@Test
	public void testZero() {
		// Test converting zero to hexadecimal
		assertEquals("0", converter.main(new String[]{"0"}), "Test converting zero");
	}

	@Test
	public void testLargeNumbers() {
		// Test converting large numbers to hexadecimal
		assertEquals("FFFFFFFF", converter.main(new String[]{"4294967295"}), "Test converting 2^32-1");
	}

	@Test
	public void testInvalidInput() {
		// Test handling invalid input
		assertThrows(NumberFormatException.class, () -> converter.main(new String[]{}), "Test empty input");
		assertThrows(NumberFormatException.class, () -> converter.main(new String[]{"abc"}), "Test non-numeric input");
	}

	@Test
	public void testEmptyArray() {
		// Test handling empty array input
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> converter.main(new String[0]), "Test null input");
	}
}
