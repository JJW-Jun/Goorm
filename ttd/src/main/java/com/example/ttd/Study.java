package com.example.ttd;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Study {
    private final Status status = Status.DRAFT;
    private int limit;


    public Study(int limit) {
        if(limit<0){
            throw new IllegalStateException("0보다 크거나 같아야 합니다.");
        }
        this.limit = limit;
    }
    public Study() {
    }

}
