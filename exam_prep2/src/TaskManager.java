import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TaskManager {
    public static void main(String[] args) {
        List<Task> mytasks = new ArrayList<>();
        mytasks.add(new Task("java", 2,3));
        mytasks.add(new Task("math",1,2));
        mytasks.add(new Task("tcs", 3,2));

        Iterator<Task> it = mytasks.iterator();
        while(it.hasNext()){
            Task task = it.next();
            System.out.println(task);
        }
        System.out.println("");

        Collections.sort(mytasks);
        mytasks.forEach(System.out::println);
        System.out.println("");

        mytasks.sort((t1, t2)->t1.getDescript().compareTo(t2.getDescript()));
        mytasks.forEach(System.out::println);
        System.out.println("");

        mytasks.sort((t1,t2)->Integer.compare(t1.getUrgency(), t2.getUrgency()));
        mytasks.forEach(System.out::println);
    }
}
