package com.example.users.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void success_get_user_id_1() {
//        UserResponse result = restTemplate.getForObject("/users/1", UserResponse.class);
//        assertEquals(1, result.getId());
//        assertEquals("Jengweb", result.getName());
//        assertEquals("jengweb@gmail.com", result.getEmail());

        TableUser jengweb = new TableUser(1, "Jengweb", "jengweb@gmail.com");
        when(userRepository.findById(1))
                .thenReturn(Optional.of(jengweb));
        // Test
        UserResponse result
                = restTemplate.getForObject("/users/1", UserResponse.class);
        assertEquals(1, result.getId());
        assertEquals("Jengweb", result.getName());
        assertEquals("jengweb@gmail.com", result.getEmail());
    }

    @Test
    public void failure_with_invalid_id() {
        ErrorResponse result
                = restTemplate.getForObject("/users/abc", ErrorResponse.class);
        assertEquals(400, result.getCode());
        assertEquals("Invalid id with abc", result.getMessage());
    }

    @Test
    public void user_not_found() {
        ErrorResponse result
                = restTemplate.getForObject("/users/0", ErrorResponse.class);
        assertEquals(4567, result.getCode());
        assertEquals("User not found with id=0", result.getMessage());
    }
}