package item;

import lombok.Data;

import javax.persistence.*;

@Entity @Inheritance(strategy = InheritanceType.JOINED) @Data
@DiscriminatorColumn
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int price;
}
