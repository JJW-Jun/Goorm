package jpql;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Setter @Getter
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FAMILY_ID")
    private Long id;

    private String name;
    private int count;

//    @OneToMany(mappedBy = "family")
//    private List<Member> members = new ArrayList<>();
}
