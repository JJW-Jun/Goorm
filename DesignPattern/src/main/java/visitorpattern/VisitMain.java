package visitorpattern;

import java.util.ArrayList;

public class VisitMain {
    public static void main(String args[]) {
        VisitableA a = new VisitableA(-1);

        ArrayList<Visitable> visitables = new ArrayList<>();
        visitables.add(new VisitableA(1));
        visitables.add(new VisitableA(2));
        visitables.add(new VisitableA(3));
        visitables.add(new VisitableA(4));
        visitables.add(new VisitableA(5));
        int ageSum = 0;
        Visitor visitor = new VisitorA();
        for (Visitable visitable : visitables) {

            ageSum+=((VisitableA) visitable).getAge();
//            visitable.accept(visitor);
        }
        System.out.println(((VisitorA) visitor).getAgeSum());
        System.out.println(ageSum);
    }
}
