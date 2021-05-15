package jpql;

import jpql.item.BaseEntity;
import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "MEMBER_NAME")
    private String membername;

    @Column(name = "TEAM_ID")
    private Long teamId;


    protected Member() { }

}


//@Entity
//@Data
//public class Member {
//    @Id
//    @GeneratedValue
//    @Column(name = "MEMBER_ID")
//    private Long id;
//
//    @Column(name = "MEMBER_NAME")
//    private String memberName;
//
//    @ManyToOne
//    @JoinColumn(name = "TEAM_ID")
//    private Team team;
//
//    public void setTeam(@NonNull Team team) {
//        this.team = team;
//        List<Member> lst = team.getMembers();
//        lst.removeIf(x -> lst.contains(this));
//        lst.add(this);
//    }
//
//    protected Member() {
//    }
//
//}


