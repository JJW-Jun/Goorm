package jpql;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


@Entity
@Data
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

//    @OneToMany(mappedBy = "team")
//    private List<Member> members = new ArrayList<>();




}

//    public static void main(String args []){
//        Stream.of("d2", "a2", "b1", "b3", "c","a1")
//                .sorted((s1, s2) -> {
//                    System.out.printf("sort: %s; %s\n", s1, s2);
//                    return s1.compareTo(s2);
//                })
//                .filter(s -> {
//                    System.out.println("filter: " + s);
//                    return s.startsWith("a");
//                })
//                .map(s -> {
//                    System.out.println("map: " + s);
//                    return s.toUpperCase();
//                })
//                .forEach(s -> System.out.println("forEach: " + s));
//        System.out.println("=================================");
//        Stream.of("d2", "a2", "b1", "b3", "c", "a1")
//                .filter(s -> {
//                    System.out.println("filter: " + s);
//                    return s.startsWith("a");
//                })
//                .sorted((s1, s2) -> {
//                    System.out.printf("sort: %s; %s\n", s1, s2);
//                    return s1.compareTo(s2);
//                })
//                .map(s -> {
//                    System.out.println("map: " + s);
//                    return s.toUpperCase();
//                })
//                .forEach(s -> System.out.println("forEach: " + s));
//        System.out.println("=================================");
//        Stream.of("d2", "a2", "b1", "b3", "c", "a1")
//                .filter(s -> {
//                    System.out.println("filter: " + s);
//                    return s.startsWith("a");
//                })
//                .map(s -> {
//                    System.out.println("map: " + s);
//                    return s.toUpperCase();
//                })
//                .sorted((s1, s2) -> {
//                    System.out.printf("sort: %s; %s\n", s1, s2);
//                    return s1.compareTo(s2);
//                })
//                .forEach(s -> System.out.println("forEach: " + s));
//
//    }