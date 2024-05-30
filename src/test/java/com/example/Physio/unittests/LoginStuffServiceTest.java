//package com.example.Physio.unittests;
//
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//public class LoginStuffServiceTest {
//    StuffRepository userRepository;
//    LoginServiceForStuff loginService;
//
//    @BeforeEach
//    void setUp() {void
//        userRepository = Mockito.mock(StuffRepository.class);
//        loginService = new LoginServiceForStuff(userRepository);
//    }
//
//    @Test
//    public void shouldThrowExceptionWhenNotFoundUser() {
//
//        Mockito.when(userRepository.findByUsername("testStuff")).thenReturn(null);
//        assertThrows(RuntimeException.class, () -> loginService.login("testStuff", "testPassword"));
//    }
//    /*@Test
//    public void testLoginNullUser() {
//        Mockito.when(userRepository.findByUsername(null)).thenReturn(null);
//
//        assertThrows(RuntimeException.class, () -> loginService.login(null,"null"));
//    } */
//    @Test
//    public void shouldThrowExceptionWhenProviedPasswordIsNull() {
//        Stuff mockUser = new Stuff();
//        mockUser.setUsername("testStuff");
//        mockUser.setPassword(null);
//
//        Mockito.when(userRepository.findByUsername("testStuff")).thenReturn(mockUser);
//
//        assertThrows(RuntimeException.class, () -> loginService.login("testUser",null));
//    }
//    @Test
//    public void shouldThrowExceptionWhenPasswordDoesNotMatch() {
//        Stuff mockUser = new Stuff();
//        mockUser.setUsername("testUser");
//        mockUser.setPassword("testPassword");
//
//        Mockito.when(userRepository.findByUsername("testUser")).thenReturn(mockUser);
//
//        assertThrows(RuntimeException.class, () -> loginService.login("testUser","wrongPassword"));
//    }
//    @Test
//    public void shouldThrowExceptionWhenPasswordIsNull() {
//        Stuff mockUser = new Stuff();
//        mockUser.setUsername("testUser");
//        mockUser.setPassword(null);
//
//        Mockito.when(userRepository.findByUsername("testUser")).thenReturn(mockUser);
//
//        assertThrows(RuntimeException.class, () -> loginService.login("testUser","testPassword"));
//    }
//
//    @Test
//    public void shouldThrowExceptionWhenUsernameIsNull() {
//        Stuff mockUser = new Stuff();
//        mockUser.setUsername(null);
//        mockUser.setPassword("testPassword");
//        Mockito.when(userRepository.findByUsername(null)).thenReturn(mockUser);
//        assertThrows(RuntimeException.class, () -> loginService.login(null,"testPassword"));
//    }
//}