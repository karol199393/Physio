package com.example.Physio.unittests;


import com.example.Physio.controller.RegisterController;
import com.example.Physio.entity.User;
import com.example.Physio.service.RegisterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RegisterController.class)
public class RegisterControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RegisterService registerService;



//@Test
//public void testRegisterUser() throws Exception {
//    User newUser = new User("testUser", "testPassword", "test@Email");
//    when(registerService.registerUser(newUser)).thenReturn(newUser);
//
//    mockMvc.perform(post("/api/v1/register")
//                    .with(csrf())
//                    .with(user("username").password("password"))
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content("{ \"username\": \"testUser\", \"password\": \"testPassword\", \"email\": \"test@Email\" }"))
//            .andExpect(status().isCreated());
//}
    @Test
    public void testRegisterUserWithInvalidData() throws Exception {
        // Nie próbujemy rzucać wyjątku, tylko oczekujemy statusu BadRequest
        mockMvc.perform(post("/api/v1/register")
                        .with(csrf())
                        .with(user("username").password("password"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"username\": \"\", \"password\": \"\", \"email\": \"\" }"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testRegisterUserWithInvalidMailField() throws Exception {

        mockMvc.perform(post("/api/v1/register")
                        .with(csrf())
                        .with(user("username").password("password"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"username\": \"exampleUsername\", \"password\": \"examplePassword\", \"email\": \"bademail\" }"))
                .andExpect(status().isBadRequest());
    }

}
