package com.example.code.fruit;

import org.springframework.data.jpa.repository.JpaRepository;


public interface FruitRepository extends JpaRepository<Fruit, Long> {
}
