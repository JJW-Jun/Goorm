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


    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")// access많이 가는곳에서
    private Delivery delivery;
    private LocalDateTime orderDate; // 이거 사용하면 하이버네이트가 알아서 매핑해준다.

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

}
