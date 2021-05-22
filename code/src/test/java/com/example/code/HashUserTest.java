package com.example.code;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class HashUserTest {


    @Test
    void equals_test() throws Exception{
        HashUser userA = new HashUser("Alice", 25, "Seoul");

        HashUser userB = new HashUser("Alice", 25, "Seoul");

        assertThat(userA, is(userB));
    }

    @Test
    void hashcode_test() throws Exception{
        HashUser userA = new HashUser("Alice", 25, "Seoul");

        HashUser userB = new HashUser("Alice", 25, "Seoul");

        assertThat(userA.hashCode(), is(userB.hashCode()));
    }



}