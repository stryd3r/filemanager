package java8PlayGround;

import java.util.ArrayList;
import java.util.List;

import java8PlayGround.predicates.Predicate;

public class Main {

	public static void main(String[] args) {
		List<Apple> appleList = new ArrayList<>();
		Apple a1 = new Apple("red", 100);
		Apple a2 = new Apple("red", 150);
		Apple a3 = new Apple("green", 100);
		Apple a4 = new Apple("green", 150);
		appleList.add(a1);
		appleList.add(a2);
		appleList.add(a3);
		appleList.add(a4);

		// declare de predicate (the test which has to pass for adding in the list)
		Predicate<Apple> predicate = (Apple apple) -> "green".equals(apple.getColor());

		// pass the predicate for being filtered
		List<Apple> greenApples = filterList(appleList, predicate);
		System.out.println(greenApples.size());
	}

	// abstract method for filtering a list with any type of objects (in our case a list with apples)
	public static <T> List<T> filterList(List<T> list, Predicate<T> p) {
		List<T> result = new ArrayList<>();
		for (T e : list) {
			if (p.test(e)) {
				result.add(e);
			}
		}
		return result;
	}
}
