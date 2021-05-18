package com.example.ttd;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All");
    }

    @Test
    @Disabled
    void disabled() {
        System.out.println("Disabled");
    }

    @Test
    @DisplayName("안녕!")
    void create_again() {
        Study study = new Study();
        study.setLimit(10);
        assertAll(
                () -> assertNotNull(study),
                () -> assertEquals(Status.DRAFT, study.getStatus(), () -> "초기 값은 null"),
                () -> assertTrue(study.getLimit() > 0, "0보다 커야 한다.")
        );

        // Message에는 Supplier이 들어온다.
        assertEquals(Status.DRAFT, study.getStatus(), () -> "초기 값은 null");
        assertEquals(Status.DRAFT, study.getStatus(), new Supplier<String>() {
            @Override
            public String get() {
                return "초기 값은 null";
            }
        });

        assertTrue(study.getLimit() > 0, "0보다 커야 한다.");

    }

    @Test
    @DisplayName("에러 테스트")
    void create_new() {
        IllegalStateException exception =
                assertThrows(IllegalStateException.class, () -> new Study(-10));
        assertEquals("0보다 크거나 같아야 합니다.", exception.getMessage());

    }

    @Test
    void timeout() {
//        assertTimeout(Duration.ofMillis(100), () ->
//        {
//            new Study(10);
//            Thread.sleep(99);
//        });

        // 별도의 ThreadLocal을 사용하기 때문에 예상치 못한 결과가 발생할 수도 있다.
        // Junit에서 Spring Transactional은 Threadlocal을  사용, 이거승ㄴ 공유되지 앟는다. 이것은 스프링이 만든 트랜잭션이 작동안 될 수 있다.
        // DB에 반영 아, 트랜잭셔널 스레드랑 이거랑 다르게 동작해서 이걸로 테스트를 못한다는거지.
        assertTimeoutPreemptively(Duration.ofMillis(100), () ->
        {
            new Study(10);
            Thread.sleep(99);
        });
    }


    @AfterEach
    void afterEach() {
        System.out.println("After Each");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After All");
    }


}