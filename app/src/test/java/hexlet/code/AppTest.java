package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    private Validator v;
    private StringSchema schema;
    @BeforeEach
    void init() {
        v = new Validator();
        schema = v.string();
    }

    @Test
    void testEmptyString() {
        //test empty string
        var actual = schema.isValid("");
        var result = true;
        assertEquals(actual, result);
    }

    @Test
    void testSimpleString() {
        var actual = schema.isValid("what does the fox say");
        var result = true;
        assertEquals(actual, result);
    }

    @Test
    void testRequiredEmptyString() {
        schema.required();
        var actual = schema.isValid("");
        var result = false;
        assertEquals(actual, result);
    }

    @Test
    void testRequiredSimpleString() {
        schema.required();
        var actual = schema.isValid("what does the fox say");
        var result = true;
        assertEquals(actual, result);
    }

    @Test
    void testContains() {
        var actual = schema.contains("wh").isValid("what does the fox say");
        var result = true;
        assertEquals(actual, result);
    }

    @Test
    void testNotContains() {
        var actual = schema.contains("whatthe").isValid("what does the fox say");
        var result = false;
        assertEquals(actual, result);
    }

    @Test
    void testAllChecks() {
        var actual = schema.required().minLength(7).contains("hex").isValid("hexlet");
        var result = true;
        assertEquals(actual, result);
    }

}
