package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapSchemaTest {
    Validator v;
    private MapSchema schema;

    @BeforeEach
    void init() {
        v = new Validator();
        schema = v.map();
    }

    @Test
    void testCaseIsValid1() {
        var actual = schema.isValid(null);
        var expected = true;
        assertEquals(actual, expected);
    }

    @Test
    void testCaseIsValid2() {
        schema.required();
        var actual = schema.isValid(null);
        var expected = false;
        assertEquals(actual, expected);
    }

    @Test
    void testCaseIsValid3() {
        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        var actual = schema.isValid(data);
        var expected = true;
        assertEquals(actual, expected);
    }

    @Test
    void testCaseSizeOf1() {
        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        schema.sizeof(2);
        var actual = schema.isValid(data);
        var expected = false;
        assertEquals(actual, expected);
    }

    @Test
    void testCaseSizeOf2() {
        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        data.put("key2", "value2");
        schema.sizeof(2);
        var actual = schema.isValid(data);
        var expected = true;
        assertEquals(actual, expected);
    }
    @Test
    void testCaseShape1() {
        Map<String, BaseSchema> schemas = new HashMap<>();
        StringSchema stringSchema = v.string();
        stringSchema.required();
        schemas.put("name", stringSchema);
        schemas.put("age", v.number().positive());
        schema.shape(schemas);

        Map<String, Object> human = new HashMap<>();
        human.put("name", "John");
        human.put("age", Integer.MAX_VALUE);
        var actual = schema.isValid(human);
        var expected = true;
        assertEquals(actual, expected);
    }

    @Test
    void testCaseShape2() {
        Map<String, BaseSchema> schemas = new HashMap<>();
        StringSchema stringSchema = v.string();
        stringSchema.required();
        schemas.put("name", stringSchema);
        schemas.put("lastname", v.string().required().minLength(2));
        schema.shape(schemas);

        Map<String, Object> human = new HashMap<>();
        human.put("name", "John");
        human.put("lastname", "B");
        var actual = schema.isValid(human);
        var expected = false;
        assertEquals(actual, expected);
    }

}
