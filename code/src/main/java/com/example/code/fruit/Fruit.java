package com.example.code.fruit;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return Double.compare(fruit.weight, weight) == 0
                && price == fruit.price
                && Objects.equals(kind, fruit.kind)
                && this.grade.equals(fruit.grade)
                && this.kind.equals(fruit.kind);

    }

    public static void main(String args[]) {

        Fruit fruit = new Fruit();
//        String b= "aaa'";
//        int a = b.compareTo("a");
//        System.out.println("a".compareTo("b"));
    }

    // Objects.equals(kind, fruit.kind) && Objects.equals(grade, fruit.grade);
    @Override
    public int hashCode() {
        return Objects.hash(id, kind, grade, weight, price);
    }
}
