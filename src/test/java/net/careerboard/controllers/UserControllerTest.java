package net.careerboard.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.careerboard.models.User;
import net.careerboard.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.security.test.context.support.WithMockUser;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;


@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;



    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    @WithMockUser
    public void testCreateUserSuccess() throws Exception {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setUsername("john.doe");

        User createdUser = new User();
        createdUser.setUserId(1L);
        createdUser.setFirstName("John");
        createdUser.setLastName("Doe");
        createdUser.setUsername("john.doe");

        when(userService.addUser(any(User.class))).thenReturn(createdUser);

        mockMvc.perform(post("/api/user").with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isCreated())
                .andExpect(content().string("User is created successfully: " + createdUser.toString()));
    }

    @Test
    @WithMockUser
    public void testCreateUserFailure() throws Exception {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setUsername("john.doe");

        when(userService.addUser(any(User.class))).thenThrow(new RuntimeException("User creation failed"));

        mockMvc.perform(post("/api/user").with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("User is creation failed"));
    }
}