package jpql;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;


@Entity @Data @ToString
public class Member {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    private int age;

    @Enumerated(EnumType.STRING)
    private MemberType type;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "TEAM_ID")
    private Team team;

    public void changeTeam(Team team){
        this.team = team;
        team.getMembers().add(this);
    }

}
