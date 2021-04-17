import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DelayedTaskExampleTest {

    @Test
    void hashMap(){
        Map<String, Integer> map = new HashMap<>();
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 3);
        map.put("key4", 4);
        map.put("key5", 5);
        map.put("key6", 6);
        map.put("key7", 7);
        List<String> test = Arrays.asList("aa");
        Enumeration<String> en = Collections.enumeration(test);
        en.asIterator().forEachRemaining(System.out::println);

//        map.entrySet().stream().forEach(System.out::println);
//        map.entrySet().stream().filter(x->x.getValue()%2==0).forEach(System.out::println);
//        map.keySet().stream().filter(x->x=="key1").forEach(System.out::println);
        map.values().stream().forEach(System.out::println);

    }

    @Test
    void iterator(){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        Iterator<Integer> itr = arr.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

    }

}