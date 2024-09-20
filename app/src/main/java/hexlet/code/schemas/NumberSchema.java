package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema{

    public NumberSchema required() {
        Predicate<Integer> required = new Predicate<Integer>() {
            @Override
            public boolean test(Integer i) {
                return i != null;
            }
        };
        addToList(required);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Integer> positive = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 0;
            }
        };
        addToList(positive);
        return this;
    }

    public NumberSchema range(Integer integer1, Integer integer2) {
        Predicate<Integer> range = new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return number >= integer1 && number <= integer2;
            }
        };
        addToList(range);
        return this;
    }
}