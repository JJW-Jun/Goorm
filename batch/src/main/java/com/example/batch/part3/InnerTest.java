package com.example.batch.part3;


import java.util.Objects;

import static java.lang.Math.max;
import static java.lang.Math.min;




class Car{
    private class Excel{
        private int price;
        private int gear;
    }
}


class InnerTest {
    private class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return x == pos.x && y == pos.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    Pos s, e;

    InnerTest(int x1, int y1, int x2, int y2) {
        s = new Pos(min(x1, x2), min(y1, y2));
        e = new Pos(max(x1, x2), max(y1, y2));
    }

    Pos getStartPoint() {
        return s;
    }

    Pos getEndPoint() {
        return e;
    }


}


class TTTT{
    public static void main(String args []){
        InnerTest r = new InnerTest(1,2,3,4);
        InnerTest r2 = new InnerTest(1,2,3,4);
        boolean result = r.equals(r2);
        System.out.println(result);

    }
}

