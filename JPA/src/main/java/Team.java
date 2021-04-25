import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Data
public class Team {
    @Id
    @GeneratedValue
    @Column(name = "team_id")
    private Long id;

    @Column
    private String name;

    @OneToMany
    private List<Member> members = new ArrayList<>();
    protected Team (){};
}
