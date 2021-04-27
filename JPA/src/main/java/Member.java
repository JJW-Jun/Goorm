import lombok.Data;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;


@Entity @Data
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @ManyToOne @JoinColumn(name = "TEAM_ID")
    private Team team;

    public void setTeam(Team team){
        this.team=team;
        team.getMembers().add(this);

    }

    protected Member (){};

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", team=" + team +
                '}';
    }
}
