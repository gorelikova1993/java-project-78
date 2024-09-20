package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema{
    public MapSchema required() {
        Predicate<Map> required = new Predicate<Map>() {
            @Override
            public boolean test(Map map) {
                return map != null;
            }
        };
        addToList(required);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
            Predicate<Map> shape = new Predicate<Map>() {
                @Override
                public boolean test(Map map) {
                    for (Map.Entry<String, BaseSchema> schema : schemas.entrySet()) {
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
            addToList(shape);
        return this;
    };

    public MapSchema sizeof(int size) {
        Predicate<Map> sizeof = new Predicate<Map>() {
            @Override
            public boolean test(Map map) {
                return map.size() == size;
            }
        };
        addToList(sizeof);
        return this;
    }


}
