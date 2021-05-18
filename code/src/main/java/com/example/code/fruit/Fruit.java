package com.example.code.fruit;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class Fruit {
    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", kind='" + kind + '\'' +
                ", grade='" + grade + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String kind;
    private String grade;
    private double weight;
    private int price;

    public Fruit(String kind, String grade, double weight, int price) {
        this.kind = kind;
        this.grade = grade;
        this.weight = weight;
        this.price = price;
    }

    public Fruit() {
    }

    public boolean isApple() {
        return "Apple".equals(getKind());
    }

    public boolean isGradeA() {
        return "A".equals(getGrade());
    }

    public boolean over3Kg() {
        return getWeight() >= 3.0;
    }


}
