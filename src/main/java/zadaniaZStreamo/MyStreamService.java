package zadaniaZStreamo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyStreamService implements StreamService {
    @Override
    public void sortAndPrint(List<String> names) {
        names.stream()
                .sorted()
                .forEach(s -> System.out.println(s));
    }

    @Override
    public int distinctAndCountNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .distinct()
                .sum();

    }

    @Override
    public List<String> computeMaleNames(List<String> names) {
        return names.stream()
                .filter(name -> !name.endsWith("a"))
                .collect(Collectors.toList());
    }

    @Override
    public void printNumbersOfRange(int[] numbers, int minValue, int maxValue) {
        Arrays.stream(numbers)
                .filter(number -> number >= minValue && number <= maxValue)
                .forEach(name -> System.out.println(name));


    }

    @Override
    public List<Integer> computeNamesLength(List<String> names) {
        return names.stream()
                .map(name -> name.length())
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> buildPeopleWithNames(List<String> names) {
        return names.stream()
                .map((name -> new MyPerson(name)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> findPeopleOfIdGreaterThan(List<Person> people, int id) {
        return people.stream()
                .filter(person -> person.getId() > id)
                .collect(Collectors.toList());
    }

    @Override
    public boolean hasSenior(List<Person> people) {
        return people.stream()
                .filter(person -> person.getAge() > 60)
                .count() > 0;
    }

    @Override
    public double sumTotalCash(List<Person> people) {
        return people.stream()
                .mapToDouble(person -> person.getCash())
                .sum();
    }


    @Override
    public Person findRichestPerson(List<Person> people) {
        return people.stream()
                .sorted(Comparator.comparingDouble(Person::getCash))
                .findFirst()
                .get();
    }


    @Override
    public double computeAverageAge(List<Person> people) {
        return people.stream()
                .mapToDouble(person-> person.getCash())
                .sum()/ people.size();
    }
}
