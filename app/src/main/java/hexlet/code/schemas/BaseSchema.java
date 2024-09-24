package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T> {

    private Map<String, Predicate> predicates = new LinkedHashMap<>();

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

    /**
     * Метод добавляет предикат в лист проверок.
     * @param str название предиката
     * @param predicate сам предикат
     */
    public final void addToList(String str, Predicate<Object> predicate) {
        predicates.put(str, predicate);
    }
}
