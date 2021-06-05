package jpql;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    // Address
    private String city;
    private String street;
    private String zipcode;

    protected Address() {}

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
