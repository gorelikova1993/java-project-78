package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema<String> {
    @Override
    public final boolean isValid(Object obj) {
        return super.isValid(obj);
    }

    public final StringSchema required() {
        Predicate<String> isNotEmpty = new Predicate<String>() {
            @Override
            public boolean test(String string) {
                return string != null && !(string.trim().isEmpty());
            }
        };
        predicates.put("isNotEmpty", isNotEmpty);
        return this;
    }

    public final StringSchema contains(String str) {
        Predicate<String> contains = new Predicate<String>() {
            @Override
            public boolean test(String string) {
                return string.contains(str);
            }
        };
        predicates.put("contains", contains);
        return this;
    }

    public final StringSchema minLength(int min) {
        Predicate<String> minLength = new Predicate<String>() {
            @Override
            public boolean test(String string) {
                return string.length() >= min;
            }
        };
        predicates.put("minLength", minLength);
        return this;
    }
}
