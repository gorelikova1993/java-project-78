package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {

    /**
     * Добавляет в схему ограничение, которое не позволяет использовать null в качестве значения.
     * @return NumberSchema
     */
    public final NumberSchema required() {
        Predicate<Integer> required = new Predicate<Integer>() {
            @Override
            public boolean test(Integer i) {
                return i != null;
            }
        };
        predicates.put("required", required);
        return this;
    }

    /**
     * Добавляет ограничение на знак числа. Число должно быть положительным.
     * @return NumberSchema с ограничением positive
     */
    public final NumberSchema positive() {
        Predicate<Integer> positive = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer == null) {
                    return true;
                } else {
                    return integer > 0;
                }
            }
        };
        predicates.put("positive", positive);
        return this;
    }

    /**
     * Добавляет допустимый диапазон, в который должно попадать значение числа включая границы.
     * @param integer1 начала диапозона включительно
     * @param integer2 конец диапозона включительно
     * @return NumberSchema с данным ограничением
     */
    public final NumberSchema range(Integer integer1, Integer integer2) {
        Predicate<Integer> range = new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return number >= integer1 && number <= integer2;
            }
        };
        predicates.put("range", range);
        return this;
    }
}
