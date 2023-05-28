package Easy_Java;

import java.util.Arrays;
import java.util.Comparator;

public class _2418 {
	public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        String[] result = new String[n];

        // Create an array of Person objects
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            people[i] = new Person(names[i], heights[i]);
        }

        // Sort the array of Person objects in descending order of height
        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return Integer.compare(p2.height, p1.height);
            }
        });

        // Copy the sorted names into the result array
        for (int i = 0; i < n; i++) {
            result[i] = people[i].name;
        }

        return result;
    }

    private static class Person {
        String name;
        int height;

        Person(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }
}
