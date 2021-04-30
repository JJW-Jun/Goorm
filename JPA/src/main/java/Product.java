import lombok.Data;

import javax.persistence.*;

@Entity @Data
public class Product {

    @Id @GeneratedValue
    @Column(name = "PRODUCT_ID")
    private Long id;
    private int orderAmount;

    @Embedded
    private Address address;

}
