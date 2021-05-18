package builderpattern.practice;

import builder.practice.UserDto;
import builder.second.MemberDto;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;

import java.io.File;
import java.time.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class UserDtoTest {
    @Test
    void dto() throws Exception {
        UserDto.Builder builder = new UserDto.Builder(null, "1234", "abcde@gmail.com");
        UserDto user = builder.address("Busan")
                .gender("Female")
                .phoneNUmber("")
                .build();
        System.out.println(user.toString());
    }

    @Test
    void builderAnnotatioin() {
        MemberDto memberDto =
                MemberDto.builder()
                        .id(1L)
                        .name("Jun")
                        .build();

//        Member member = new Member(memberDto);

    }

    @Test
    void try_catch() {
        try {
            System.out.println(0 / 0);
        } catch (ArithmeticException e) {
            if (e instanceof ArithmeticException) {
                System.out.println("====================");
                e.printStackTrace();
                System.out.println("====================");
                System.out.println("Error message= " + e.getMessage());
                System.out.println("This error is ArithmeticException");
            }
        } catch (Exception e) {
            System.out.println("Exception");

        }
    }


    @Test
    void throw_exception() {
        try {
            Exception e = new Exception("Error message");
            throw e;
        } catch (Exception e) {
            System.out.println("Error= " + e.getMessage());
            System.out.println("====================");
            e.printStackTrace();
            System.out.println("====================");
        }
    }

    @Test
    void throw_exception2() {
        LocalDate.ofEpochDay(1).toString();

    }

    //    @Test
//    public void testLocal(){
//        Map<String,Object> result = new HashMap<>(8);
//        result.put("date1", new Date());
//        result.put("date2", LocalDate.now());
//        result.put("date3", LocalDateTime.now());
//        System.out.println(JsonKit.toString(result));
//    }
    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate asLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDateTime asLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public void CachedItem(File file, int from) {
        LocalDate.now().plusDays(1);
    }

    //

    public static Date toDate(final LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

//    @Test
//    public long toEpochSecond() {
//        return LocalDate.now().atStartOfDay().toEpochSecond(ZoneOffset.UTC);
//    }


    @Test
    public void multy() {
        try {

        } catch (AbstractMethodError | ArithmeticException e) {
            if (e instanceof AbstractMethodError) {
                System.out.println("AbstractMethodError");
            }
            if (e instanceof ArithmeticException) {
                System.out.println("ArithmeticException");
            }


        }


    }

    public static void main(String args[]) {
        try {
            install();
        } catch (InstallException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    static void install() throws InstallException {
        try {
            startInstall();
            copyFiles();
        } catch (SpaceException se) {
            InstallException ie = new InstallException("Install error");
            ie.initCause(se);
            throw ie;
        } catch (MemoryException me) {
            InstallException ie = new InstallException("Install error");
            ie.initCause(me);
            throw ie;
        } finally {
            deleteTempFiles();
        }
    }

    static void startInstall() throws SpaceException, MemoryException {
        if (!enoughSpace()) {
            throw new SpaceException("Not enough space");
        }

        if (!enoughMemory()) {
            throw new MemoryException("Not enough memoery");
//            throw new RuntimeException(new MemoryException("Not enough memoery"));
        }

    }

    static void copyFiles() {
        System.out.println("Copy files");
    }

    static void deleteTempFiles() {
        System.out.println("Delete temp files");
    }

    static boolean enoughSpace() {
        return false;
    }

    static boolean enoughMemory() {
        return true;
    }

    static class InstallException extends Exception {
        InstallException(String message) {
            super(message);
        }
    }

    static class SpaceException extends Exception {
        SpaceException(String message) {
            super(message);
        }
    }

    static class MemoryException extends Exception {
        MemoryException(String message) {
            super(message);
        }
    }

//    public void exceptionWork(boolean exception) throws WorkException{
//        System.out.println("exceptionWork("+exception+"가 호출");
//        if(exception){
//            throw new WorkException("WorkException");
//        }
//
//        public void close() throws CloseException{
//            System.out.println("close() 호출");
//        }
//    }

    @Test
    void testttt() {
        String a = null;
        a  = Objects.requireNonNullElseGet(a, ()-> "Test");
//        a  = Objects.requireNonNullElseGet(a, );

//        String b  = Objects.requireNonNullElseGet(a, RequrieNo);

//        int c = Objects.requireNonNullElseGet(a.length(), ()->1);
//        System.out.println(result);
//        System.out.println(c);
    }

    private String errorMessage() {
        return "";
    }
    private void tttte33(int n){
        for(int i=0; i<50000; i++){
        }
    }
    @Test @Benchmark
    void benchmark(){
        long start = System.nanoTime();
        tttte33(3);
        long elapsedTime = System.nanoTime()-start;
        double seconds = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
        double secondDecimalPrecision = (double) elapsedTime/1000000000.0;
        double ms = TimeUnit.MICROSECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
        double minutes = TimeUnit.MINUTES.convert(elapsedTime, TimeUnit.NANOSECONDS);
        System.out.printf("Manoseconds: %d ms\n", elapsedTime);
    }

    @Test
    void testtttttt() {
        Optional<String> str = Optional.ofNullable("썬더");
        str.ifPresentOrElse(
                x -> System.out.println("섹스"),
                () -> System.out.println("기모띠 쎅쓰"));

        Consumer<Integer> t = System.out::println;
    }
    static Consumer<String> st = System.out::println;

    @Test
    void osrttt() {
        LocalDate date = LocalDate.now();
        date.withYear(2010);
        date.withMonth(12);
        System.out.println(date.withDayOfMonth(16));
        System.out.println(date.withDayOfYear(99));

    }

}
