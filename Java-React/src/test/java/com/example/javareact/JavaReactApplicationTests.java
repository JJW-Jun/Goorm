package com.example.javareact;

import com.example.javareact.user.Person;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.lang.NonNull;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class JavaReactApplicationTests {
    public static void main(String args []){
        Person p = new Person("김가은", 30, "부산");
        Person p1 = new Person("차은우", 22, "서울");
        Person p2= new Person("육지담", 26, "대구");
        Person p3 = new Person("금정원", 15, "부산");
        Person p4 = new Person("정가은", 30, "대전");
        Person p5 = new Person("윤규수", 42, "서울");
        Person p6 = new Person("오민정", 33, "서울");
        Person p7 = new Person("김석훈", 23, "광주");
        Person p8 = new Person("허향문", 30, "강원");
        Person p9 = new Person("신지항", 49, "서울");

        List<Person> lst = new ArrayList<>();
        lst.add(p);
        lst.add(p1);
        lst.add(p2);
        lst.add(p3);
        lst.add(p4);
        lst.add(p5);
        lst.add(p6);
        lst.add(p7);
        lst.add(p8);
        lst.add(p9);




        Map<String, String> mapByAddress = lst.stream().collect(Collectors.groupingBy(Person::getAddress,
                Collectors.mapping(Person::getName,
                        Collectors.joining(","))));

        mapByAddress.entrySet().stream().forEach(System.out::println);

    }

    @Test
    void ttttte3(){
        Fruit fruit = new Fruit("Grape", "A",3);

        Fruit fruit2 = new Fruit("Grape", "A",3);

        assertEquals(fruit, fruit2);
    }
//    ArrayList<Fruit> arrayList = new ArrayList();
//    LinkedList<Fruit> arrayList2 = new LinkedList();
//
//    //    @BeforeEach
//    void beforeEach() {
//        for (int i = 0; i < 5000000; i++) {
//            Fruit fruit = new Fruit();
//            arrayList.add(fruit);
//        }
//        for (int i = 0; i < 5000000; i++) {
//            Fruit fruit = new Fruit();
//            arrayList2.add(fruit);
//
//        }
//        System.out.println("==Finish");
//    }
//
//    @Test
//    void ee() {
//        ArrayList<Integer> arr = new ArrayList<>(10);
//        for(int j=0; j<10; j++) {
//            Long start = System.currentTimeMillis();
//            arr.clear();
//            for (int i = 0; i < 5000000; i++) {
//                Fruit fruit = new Fruit();
//                arr.add(i);
//            }
//            Long end = System.currentTimeMillis();
//            System.out.println("result= " + (end - start));
//        }
//    }
//
//    @Test
//    void timeT() {
//        for (int i = 0; i < 10; i++) {
//
//            Long start = System.currentTimeMillis();
//            arrayList.get(2500000);
//            Long end = System.currentTimeMillis();
//            System.out.println("result= " + (end - start));
//        }
//        System.out.println("====================");
//        for (int i = 0; i < 10; i++) {
//
//            Long start = System.currentTimeMillis();
//            arrayList2.get(2500000);
//            Long end = System.currentTimeMillis();
//            System.out.println("result= " + (end - start));
//        }
//    }
//
//    @Test
//    void reset() {
//
//        for (int j = 0; j < 10; j++) {
//            Long start = System.currentTimeMillis();
//            arrayList.clear();
//            for (int i = 0; i < 20000; i++) {
//
//                Fruit fruit = new Fruit();
//
//                arrayList.add(fruit);
//                if (arrayList.size() > 5000) {
//                    arrayList.add(3000, new Fruit());
//                }
//
//            }
//            System.out.println(arrayList.get(19999));
//            Long end = System.currentTimeMillis();
//            System.out.println("result= " + (end - start));
//        }
//
//        System.out.println("==========");
//        for (int j = 0; j < 10; j++) {
//            Long start = System.currentTimeMillis();
//            arrayList2.clear();
//            for (int i = 0; i < 20000; i++) {
//                Fruit fruit = new Fruit();
//                arrayList2.add(fruit);
//                if (arrayList2.size() > 5000) {
//                    arrayList2.add(30, new Fruit());
//                }
//            }
//            Long end = System.currentTimeMillis();
//            System.out.println(arrayList2.get(19999));
//            System.out.println("result= " + (end - start));
//        }
//    }
//
//    @Test
//    void execute() {
//        System.out.println("Ex");
//        System.out.println("====================");
//        arrayList.ensureCapacity(30);
//        System.out.println(arrayList.size());
//        System.out.println("====================");
//    }
//
//    @Test
//    void contextLoads() {
//        List<Integer> lst = new ArrayList<>(100);
//        lst.add(1);
//        lst.add(2);
//        lst.add(3);
//        lst.add(4);
//        List<Integer> lst2 = new ArrayList<>();
//        lst2.add(3);
//        lst2.add(4);
//        lst2.add(1);
//        lst.sort(Comparator.comparing(Integer::intValue).reversed());
//        lst2.sort(Comparator.comparing(Integer::intValue));
//
//        for (int i = 0; i < lst2.size(); i++) {
//            if (lst.contains(lst2.get(i))) {
//                lst.remove(lst2.get(i));
//                lst.stream().forEach(System.out::println);
//                System.out.println("==========");
//            }
//        }
//
////        System.arraycopy();
//
//
//    }
//
//    @Test
//    void search() throws Exception {
//        List<String> dictionary = new ArrayList<>();
//        dictionary.add("a");
//        dictionary.add("b");
//        dictionary.add("c");
//        dictionary.add("d");
//
//        Optional<String> keyword = Optional.ofNullable(null);
//
//        dictionary.contains(nonNull_get(keyword));
//    }
//
//    String nonNull(Optional<String> keyword) {
//        if (keyword.isPresent()) {
//            return keyword.orElseGet(() -> "There is no result");
//        }
//        System.out.println("====================");
//        throw new NullPointerException("Keyword is Null");
//    }
//
//    String nonNull_get(Optional<String> keyword) {
//        if (keyword.isPresent()) {
//            return keyword.get();
//
//        }
//        throw new NullPointerException("Keyword is NullPointException");
//
//    }

//    @Test
//    void test() {
//        Stack<String> stack = new Stack();
//        Queue<String> queue = new LinkedList();
//        List<String> str = new ArrayList<>();
//        ArrayList<String> str2 = new ArrayList<>();
//        Map<String, String> map = new HashMap();
//        map.put("a", "1");
//        map.put("b", "2");
//        map.put("c", "3");
//        map.put("d", "3");
//        map.put("e", "3");
//        map.put("f", "3");
////        map.keySet().iterator().forEachRemaining(System.out::println);
//
//        Set<String> set = new HashSet();
//        set.add("a");
//        set.add("b");
//        set.add("c");
//
//        set.iterator().forEachRemaining(System.out::println);
//
//    }

    // 공식 사전
    static final List<String> officialDictionary = new ArrayList<>();
    static final List<String> words = new ArrayList<>();

    //    @BeforeEach
    void beforeTest() {
        // 임의의 단어목록
        words.add("word_A");
        words.add("word_B");

        // 단어 검사
        check(words);
    }

    @Test
    void immutableList() throws Exception {
        // 검증된 단어들 선별
        List<String> verifiedWords = update(words);

        // 공식 사전에 추가
        officialDictionary.addAll(verifiedWords);
        words.clear();

        try {
            // 검증된 단어목록에 추가 -> 예외 발생
            verifiedWords.add("word_C");

        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
            System.out.println("Message= " + e.getMessage());
        }

        assertEquals(2, officialDictionary.size());
    }

    public List<String> update(@NonNull List<String> dictionary) {
        return Collections.unmodifiableList(dictionary);
    }

    public void check(@NonNull List<String> words) {
        words.removeIf(officialDictionary::contains);
    }

    @Test
    void isApple() throws Exception {


    }

    @Test
    void ttt() {
        List<String> a = Arrays.asList("a", "b");
        int answer = a.stream().collect(Collectors.counting()).intValue();
//        List<String> b = a;
//        a.clear();
        System.out.println("===========================");
//        System.out.println(a.size());
//        b.stream().forEach(System.out::println);
        System.out.println("===========================");
    }
}
