package jpql;

import jpql.item.Company;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Setter @Getter @ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "MEMBER_NAME")
    private String membername;

    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @Enumerated(EnumType.STRING)
    private MemberType type;

//    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "COMPANY_ID")
//    private Company company;
//
//    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "FAMILY_ID")
//    private Family family;

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }

}
