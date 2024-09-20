package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberSchemaTest {
    private Validator v;
    private NumberSchema schema;

    @BeforeEach
    void init() {
        v = new Validator();
        schema = v.number();
    }

    @Test
    void testNumber() {
        var actual = schema.isValid(5);
        var expected = true;
        assertEquals(actual, expected);
    }

    @Test
    void test2Case() {
        var actual = schema.positive().isValid(null);
        var expected = true;
        assertEquals(actual, expected);
    }

    @Test
    void test3Case() {
        var actual = schema.required().isValid(null);
        var expected = false;
        assertEquals(actual, expected);
    }
}

