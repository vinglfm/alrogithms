package validation;

import java.util.function.Predicate;

public interface Validator {
    <T> void validate(Predicate<T> predicate, T data, Procedure procedure);
}
