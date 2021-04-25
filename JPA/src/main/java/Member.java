import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Member {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "username")
    private String name;

    @Column(name = "team_id")
    private Long teamId;

    protected Member (){};
}
