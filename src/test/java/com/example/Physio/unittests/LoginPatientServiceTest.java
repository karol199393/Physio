package com.example.Physio.unittests;

import com.example.Physio.entity.Patient;
import com.example.Physio.repository.PatientRepository;
import com.example.Physio.service.LoginServiceForPatient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LoginPatientServiceTest {
    PatientRepository userRepository;
    LoginServiceForPatient loginService;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(PatientRepository.class);
        loginService = new LoginServiceForPatient(userRepository);
    }

    @Test
    public void shouldThrowExceptionWhenNotFoundUser() {

        Mockito.when(userRepository.findByUsername("testPatient")).thenReturn(null);
        assertThrows(RuntimeException.class, () -> loginService.login("testPatient", "testPassword"));
    }

    @Test
    public void shouldThrowExceptionWhenProviedPasswordIsNull() {
        Patient mockUser = new Patient();
        mockUser.setUsername("testPatient");
        mockUser.setPassword(null);

        Mockito.when(userRepository.findByUsername("testPatient")).thenReturn(mockUser);

        assertThrows(RuntimeException.class, () -> loginService.login("testPatient", null));
    }
    @Test
    public void shouldThrowExceptionWhenPasswordDoesNotMatch() {
        Patient mockUser = new Patient();
        mockUser.setUsername("testUser");
        mockUser.setPassword("testPassword");

        Mockito.when(userRepository.findByUsername("testUser")).thenReturn(mockUser);

        assertThrows(RuntimeException.class, () -> loginService.login("testUser","wrongPassword"));
    }
    @Test
    public void shouldThrowExceptionWhenPasswordIsNull() {
        Patient mockUser = new Patient();
        mockUser.setUsername("testUser");
        mockUser.setPassword(null);

        Mockito.when(userRepository.findByUsername("testUser")).thenReturn(mockUser);

        assertThrows(RuntimeException.class, () -> loginService.login("testUser","testPassword"));
    }

    @Test
    public void shouldThrowExceptionWhenUsernameIsNull() {
        assertThrows(RuntimeException.class, () -> loginService.login(null, "testPassword"));
    }

}