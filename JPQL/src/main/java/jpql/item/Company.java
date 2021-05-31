package jpql.item;

import jpql.Member;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Setter @Getter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMPANY_ID")
    private Long id;

    private String name;

//    @OneToMany(mappedBy = "company")
//    private List<Member> members = new ArrayList<>();
}
