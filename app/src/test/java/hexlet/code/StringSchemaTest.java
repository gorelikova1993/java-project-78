package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringSchemaTest {
    private Validator v;
    private StringSchema schema;

    @BeforeEach
    void init() {
        v = new Validator();
        schema = v.string();
    }

    @Test
    void testCase1() {
        var actual = schema.isValid(null);
        var expected = true;
        assertEquals(actual, expected);
    }

    @Test
    void testCase2() {
        schema.required();
        var actual = schema.isValid(null);
        var expected = false;
        assertEquals(actual, expected);
    }

    @Test
    void testCase3() {
        var actual = schema.isValid("");
        var expected = true;
        assertEquals(actual, expected);
    }

    @Test
    void testCase4() {
        schema.required();
        var actual = schema.isValid("");
        var expected = false;
        assertEquals(actual, expected);
    }

    @Test
    void testCaseContains1() {
        var actual = schema.contains("wh").isValid("what does the fox say");
        var expected = true;
        assertEquals(actual, expected);
    }

    @Test
    void testCaseContains2() {
        var actual = schema.contains("whatthe").isValid("what does the fox say");
        var expected = false;
        assertEquals(actual, expected);
    }

    @Test
    void testCaseMinLength() {
        var actual = schema.minLength(10).minLength(4).isValid("Hexlet");
        var expected = true;
        assertEquals(actual, expected);
    }
}
