package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T> {

    protected Map<String, Predicate> predicates = new LinkedHashMap<>();

    /**
     * Метод проверяет данные на сконфигурированной схеме.
     * @param data данные которые мы проверяем
     * @return true, если данные соответствуют всем заданным в схеме правилам, или false, если не соответствуют
     */
    public boolean isValid(Object data) {
        for (String key : predicates.keySet()) {
            if (!predicates.get(key).test(data)) {
                return false;
            }
        }
        return true;
    }
}
