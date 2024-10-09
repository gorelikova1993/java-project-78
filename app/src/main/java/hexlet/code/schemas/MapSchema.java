package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    public final MapSchema required() {
        Predicate<Map> required = new Predicate<Map>() {
            @Override
            public boolean test(Map map) {
                return map != null;
            }
        };
        predicates.put("required", required);
        return this;
    }

    public final MapSchema shape(Map<String, BaseSchema<String>> schemas) {
        Predicate<Map> shape = new Predicate<Map>() {
            @Override
            public boolean test(Map map) {
                for (Map.Entry<String, BaseSchema<String>> schema : schemas.entrySet()) {
                    for (Map.Entry<String, Object> data : ((Map<String, Object>) map).entrySet()) {
                        if (schema.getKey().equals(data.getKey())) {
                            if (!schema.getValue().isValid(data.getValue())) {
                                return false;
                            }
                        }
                    }
                }
                return true;
            }
        };
        predicates.put("shape", shape);
        return this;
    }

    public final MapSchema sizeof(int size) {
        Predicate<Map> sizeof = new Predicate<Map>() {
            @Override
            public boolean test(Map map) {
                return map.size() == size;
            }
        };
        predicates.put("sizeof", sizeof);
        return this;
    }


}
