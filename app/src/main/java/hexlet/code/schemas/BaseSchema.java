package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema<T> {
    private List<Predicate> allChecks = new ArrayList<>();

    public boolean isValid(Object obj) {
        if (allChecks.isEmpty()) {
            return true;
        }

        for (Predicate predicate : allChecks) {
            return predicate.test(obj);
        }

        return false;
    }

    public void addToList(Predicate<Object> predicate) {
        allChecks.add(predicate);
    }
}
