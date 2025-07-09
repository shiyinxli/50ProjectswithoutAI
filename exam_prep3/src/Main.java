import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> citys = Arrays.asList("Berlin", "Los Angeles", "Boston", "Paris", "Hong Kong", "Taipei");
        citys.stream().filter(s->s.startsWith("L"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        Object[] words = { " " , '3' , null , "2" , 1 , "" };
        Arrays.stream(words).filter(Objects::nonNull)
                .map(Object::toString)
                .map(String::trim)
                .filter(s->!(s.isEmpty()))
                .map(Integer::parseInt)
                .sorted()
                .forEach(System.out::println);

        List<String> bcitis = citys.stream().filter(s->s.startsWith("B"))
                .collect(Collectors.toList());
        System.out.println(bcitis);

    }
}
