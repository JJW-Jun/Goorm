package com.example.javareact;

import com.example.javareact.user.domain.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.io.IOException;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;


//class Main {
//
//    public static void main(String[] args) throws IOException {
//        {
//            try {
//
//                List<String> dictionary = new ArrayList<>();
//
//                dictionary.add("");
//                dictionary.add("Y");
//
//                System.out.println("Initial list: " + dictionary);
//
//                List<String> immutablelist = Collections
//                        .unmodifiableList(dictionary);
//
//                immutablelist.add("Apple");
////                immutablelist = immutablelist.stream().map(x->x+"A").collect(Collectors.toList());
////                immutablelist.stream().forEach(System.out::println);
//                // printing the list
////                System.out.println("Unmodifiable list: " + immutablelist.toArray());
//
//
//            } catch (UnsupportedOperationException e) {
//                System.out.println("====================");
//                System.out.println("Exception thrown : " + e);
//                System.out.println("====================");
//            }
//        }
//    }
//        System.out.println(Collections.unmodifiableList(Arrays.asList("a")).getClass());
//        ObjectMapper obm = new ObjectMapper();
//
//
//        /** Json문자열 -> Map */
//        String jsonStr = "{ \"name\" : \"민\" , \"age\" : 28 }";
//        Map<String, Object> map = new HashMap<String, Object>();
//        map = obm.readValue(jsonStr, new TypeReference<Map<String, Object>>() {
//        });
//        Collections.unmodifiableList(Arrays.asList("a"));
//        /**Map -> Json문자열 */
//        Map<String, Object> map2 = new HashMap<String, Object>();
//        map2.put("name", "미니미니");
//        map2.put("age", 100);
//        String jsonStr2 = obm.writerWithDefaultPrettyPrinter().writeValueAsString(map2);
//        //System.out.println("map -> jsonString : " + jsonStr2);
//
//
//        /** json문자열 -> javaObject */
//        User user = obm.readValue(jsonStr, User.class);
//
//        /**javaObject -> json문자열 */
//        User user1 = new User();
//        user1.setUsername("식빵");
//
//        String user1Str = obm.writeValueAsString(user1);
//        //System.out.println(user1Str);
//
//
//        /**List<Object> -> Json문자열 */
//        List<User> userList = new ArrayList<User>();
//
//        User u1 = new User();
//        u1.setUsername("dodo");
//        userList.add(u1);
//
//        User u2 = new User();
//        u2.setUsername("동길");
//        userList.add(u2);
//
//        User u3 = new User();
//        u3.setUsername("통통");
//        userList.add(u3);
//
//        String userListStr = obm.writeValueAsString(userList);
//        System.out.println(userListStr);
//
//        /** JsonList문자열 -> List<Object> */
//        List<User> userList2 = obm.readValue(userListStr, new TypeReference<List<User>>() {
//        });



@Getter
public class Fruit {

    private String kind;
    private String grade;
    private int weight;

    public Fruit(String kind, String grade, int weight) {
        this.kind = kind;
        this.grade = grade;
        this.weight = weight;
    }

    public boolean isApple() {
        return "Apple".equals(getKind());
    }

    public boolean isGrade_A() {
        return "A".equals(getGrade());
    }

    public boolean over30Kg() {
        return getWeight() >= 30;
    }
}

//
class Main {
    public static  <T, E> T catchException (Supplier<T> resolver) {
        try {
            T result = resolver.get();
            return result;
        } catch (Exception e) {
            System.out.println("Exception");
            return null;
        }
    }

    public static void main(String args[]) {

        List<Fruit> fruits = new ArrayList<>();

        Fruit apple = new Fruit("Apple", "A", 2);
        Fruit banana = new Fruit("Banana", "B", 1);
        Fruit coconut = new Fruit("Coconut", "C", 3);

        fruits.add(apple);
        fruits.add(banana);
        fruits.add(coconut);
        List<String> underlyers = null;
//        List<String> underlyers = null;
//        assert false;
        System.out.println(catchException(underlyers::size));
//        int [] arr = {1,2,3,4};
//        Arrays.sort(arr);
//        int idex = Arrays.binarySearch(arr, -3);
//        System.out.println(idex);
//        System.out.println(Arrays.binarySearch(arr, 50));
//        fruits.stream().filter(Fruit -> Fruit.getKind().equals("Apple"))
//                .forEach(System.out::println);
//        fruits.stream().filter(Fruit::isApple)
//                .filter(Fruit::isGrade_A)
//                .forEach(System.out::println);
//
//        List<String> lst = new LinkedList<>();

    }
}
