package jpql.item;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Data
public class Parent {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Child> children = new ArrayList<>();

    // 원래는 이전꺼 있으면 뺴고 이런것 다 고려
    void setChild(Child child){
        children.add(child);
        child.setParent(this);

    }


}
