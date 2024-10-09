package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public final class NumberSchemaTest {
    private Validator v;
    private NumberSchema schema;

    @BeforeEach
    public void init() {
        v = new Validator();
        schema = v.number();
    }

    @Test
    public void testNumber() {
        var actual = schema.isValid(5);
        var expected = true;
        assertEquals(actual, expected);
    }

    @Test
    public void test2Case() {
        var actual = schema.positive().isValid(null);
        var expected = true;
        assertEquals(actual, expected);
    }

    @Test
    public void test3Case() {
        var actual = schema.required().isValid(null);
        var expected = false;
        assertEquals(actual, expected);
    }

    @Test
    public void testCase4() {
        var actual = schema.required().positive().range(3, 10).isValid(6);
        var expected = true;
        assertEquals(actual, expected);
    }

    @Test
    public void testCase5() {
        var actual = schema.required().positive().range(3, 10).isValid(70);
        var expected = false;
        assertEquals(actual, expected);
    }
}

