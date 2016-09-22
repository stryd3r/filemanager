package java8PlayGround.predicates;

@FunctionalInterface
public interface Predicate<T> {

	boolean test(T e);
}
