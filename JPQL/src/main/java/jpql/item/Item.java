package jpql.item;

import lombok.Data;

import javax.persistence.*;
import java.util.stream.Stream;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data @DiscriminatorColumn
public abstract class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String name;
    private int price;

}
