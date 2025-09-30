import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main{
    public static void main(String[] args) {
        String sentence = "see you tonight bad idea right";
        Pattern pattern = Pattern.compile(" ");
        Stream<String> stream = pattern.splitAsStream(sentence);
        List<String> list = stream.collect(Collectors.toList());
        list.sort((s1,s2)->s1.compareToIgnoreCase(s2));
        System.out.println(list);

        List<String> letters = sentence.chars().
                mapToObj(codePoint ->(char) codePoint)
                .map(Object::toString)
                .map(s->s.trim())
                .filter(s->!(s.isEmpty()))
                .sorted((s1, s2)->s1.compareToIgnoreCase(s2))
                        .toList();

        System.out.println(letters);

//        Object[] words = { " " , '3' , null , "2" , 1 , "" };
//        Arrays.stream(words)
//                .filter(Objects::nonNull)
//                .map(Objects::toString)
//                .map(s->s.trim())
//                .filter(s->!s.isEmpty())
//                .map(Integer::parseInt)
//                .sorted()
//                .forEach(System.out::println);
    }
}
