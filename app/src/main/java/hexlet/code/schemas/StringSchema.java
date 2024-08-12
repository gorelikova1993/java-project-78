package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StringSchema {
    private List<Predicate> allChecks = new ArrayList<>();

    public boolean isValid(String obj) {
        if (obj == null) {
            return true;
        }
        if (allChecks.isEmpty()) {
            return true;
        }

        for (Predicate<String> predicate : allChecks) {
            return predicate.test(obj);
        }
        return false;
    }

    public StringSchema required() {
        Predicate<String> isNotEmpty = new Predicate<String>() {
            @Override
            public boolean test(String string) {
                return string != null && !(string.trim().isEmpty());
            }
        };
        allChecks.add(isNotEmpty);
        return this;
    }

    public  StringSchema contains(String str) {
        Predicate<String> contains = new Predicate<String>() {
            @Override
            public boolean test(String string) {
                return string.contains(str);
            }
        };
        allChecks.add(contains);
        return this;
    }

    public StringSchema minLength(int size) {
        Predicate<String> minLength = new Predicate<String>() {
            @Override
            public boolean test(String string) {
                return string.length() <= size;
            }
        };
        allChecks.add(minLength);
        return this;
    }
}
