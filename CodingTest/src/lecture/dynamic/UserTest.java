package lecture.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void objectEquals() throws Exception {
        User userA = new User("John", 20);

        User userB = new User("John", 20);

        System.out.println(userA + "/, " + userB);
        assertEquals(userA, userB);
    }

    @Test
    void primitiveEquals() throws Exception{

        int a = 3;

        int b = 4;

        assertEquals(a, b);

    }
    @Test
    void wrapperEquals() throws Exception{
        User userA = new User("John", 20);

        User userB = new User("John", 20);


        System.out.println(userA.getAge().equals(userB.getAge()));
        assertEquals(userA.getAge(), userB.getAge());
    }

    public static void main(String args []){

        Integer a = 3;
        Integer b = 4;

        System.out.println(a.getClass());

    }

}