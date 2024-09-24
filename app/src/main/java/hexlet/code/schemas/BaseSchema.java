package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T> {

    private Map<String, Predicate> predicates = new LinkedHashMap<>();

    public boolean isValid(Object data) {
        for (String key : predicates.keySet()) {
            if (!predicates.get(key).test(data)) {
                return false;
            }
        }
        return true;
    }

    public final void addToList(String str, Predicate<Object> predicate) {
        predicates.put(str, predicate);
    }
}
