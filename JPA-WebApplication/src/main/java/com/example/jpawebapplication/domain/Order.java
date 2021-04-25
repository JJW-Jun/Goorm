package com.example.jpawebapplication.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // cas->persist를 전파한다.
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();
    // em.persist(orderItemA)
    // em.persist(orderItemB)
    // em.persist(orderItemC)
    // 한 후 em.persist(order) 까지 해줘야 한다.  엔티티당 펄시스트해줘야한다.

    // 그러나 이경우 Order만 하면 된다.

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")// access많이 가는곳에서
    private Delivery delivery;
    private LocalDateTime orderDate; // 이거 사용하면 하이버네이트가 알아서 매핑해준다.

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    private void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    private void setDelivery(Delivery delivery){
        this.delivery = delivery;
        delivery.setOrder(this);
    }

}
