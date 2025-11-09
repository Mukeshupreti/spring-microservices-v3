package com.example.utils;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)// enable Mockito in junit5
@Tag("unit")
class UserServiceTest {

    // ------- Mockito components -------
    @Mock
    UserRepository repository; // this mock will injected in class
    //undertest that is UserService class

    @Spy// real object you can override method
    ArrayList<String> spyList = new ArrayList<>();

    @InjectMocks
    UserService service; // class under test

    @Captor// capture argurment passed to mock
    ArgumentCaptor<String> nameCaptor;

    // ------- JUnit lifecycle -------
    @BeforeAll
    static void setupAll() {
        System.out.println("== Runs once before all tests ==");
    }

    @BeforeEach
    void setup() {
        System.out.println("== Runs before each test ==");
    }

    @AfterEach
    void tearDown() {
        System.out.println("== Runs after each test ==");
    }

    @AfterAll
    static void cleanupAll() {
        System.out.println("== Runs once after all tests ==");
    }

    // ------- Basic Test -------
    @Test
    @DisplayName("Should save user successfully")
    void testSaveUser() {
        service.addUser("alice");// <-- triggers repository.save("alice")
   /* What verify(repository).save(nameCaptor.capture()) does:
        Checks that the method save(...) was called on repository
        Captures the argument passed to that save(...) call and stores it in nameCaptor
✅       So after this line runs, nameCaptor.getValue() will return the argument used in repository.save(...).*/
        verify(repository).save(nameCaptor.capture());
        System.out.println("after "+nameCaptor.getValue() );
        Assertions.assertEquals("alice", nameCaptor.getValue());
    }

    // ------- Disabled Test -------
    @Test
    @Disabled("Feature not implemented yet")
    void disabledTest() {
        Assertions.fail("Should not run");
    }

    // ------- Parameterized - Single Input -------
    // here three instances of test will rum with difference input
    @ParameterizedTest
    @ValueSource(strings = {"bob", "john", "mark"})
    void testAddUser_MultipleValues(String name) {
        service.addUser(name);
        verify(repository).save(name);
    }

    // ------- Parameterized - CSV -------
    @ParameterizedTest
    @CsvSource({
        "sam, true",
        "kate, true",
        " '', false"
    })
    void testValidateUser(String name, boolean expected) {
        Assertions.assertEquals(expected, service.isValid(name));
    }

    // ------- Testing exception -------
    @Test
    void testExceptionThrown() {
        Mockito.doThrow(new IllegalArgumentException())
                .when(repository).save(null);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> service.addUser(null));
    }

    // ------- Timeout Test -------
    @Test
    @Timeout(1)
    void testCompletesFast() throws InterruptedException {
        Thread.sleep(100);
        Assertions.assertTrue(true);
    }

    // ------- Repeated Test -------
    @RepeatedTest(3)
    void repeatedTest() {
        spyList.add("x");
        Assertions.assertTrue(spyList.size() > 0);
    }

    // ------- Nested Test -------
    @Nested
    class NestedGroup {
        @Test
        void nestedTestExample() {
            Assertions.assertNotNull(service);
        }
    }
}