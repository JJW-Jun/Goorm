import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Member extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Embedded
    private Address officeAddress;

    @Embedded
    private Period period;


}
