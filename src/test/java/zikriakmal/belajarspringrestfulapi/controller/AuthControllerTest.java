package zikriakmal.belajarspringrestfulapi.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import zikriakmal.belajarspringrestfulapi.entity.User;
import zikriakmal.belajarspringrestfulapi.model.LoginUserRequest;
import zikriakmal.belajarspringrestfulapi.model.TokenResponse;
import zikriakmal.belajarspringrestfulapi.model.WebResponse;
import zikriakmal.belajarspringrestfulapi.repository.UserRepository;
import zikriakmal.belajarspringrestfulapi.security.BCrypt;

import javax.print.attribute.standard.Media;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Test
    void loginFailedUserNotFound() throws Exception {
        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setUsername("test");
        loginUserRequest.setPassword("test");

        mockMvc.perform(
                post("/api/auth/login")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginUserRequest))
        ).andExpectAll(
                status().isUnauthorized()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });
            assertNotNull(response.getErrors());
        });
    }

    @Test
    void loginFailedUserWrongPassword() throws Exception {

        User user = new User();
        user.setName("Test");
        user.setUsername("test");
        user.setPassword(BCrypt.hashpw("rahasia", BCrypt.gensalt()));
        userRepository.save(user);

        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setUsername("Test");
        loginUserRequest.setPassword("test");

        mockMvc.perform(
                post("/api/auth/login")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginUserRequest))
        ).andExpectAll(
                status().isUnauthorized()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });
            assertNotNull(response.getErrors());
        });
    }


    @Test
    void loginSuccess() throws Exception {

        User user = new User();
        user.setName("Test");
        user.setUsername("test");
        user.setPassword(BCrypt.hashpw("rahasia", BCrypt.gensalt()));
        userRepository.save(user);

        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setUsername("Test");
        loginUserRequest.setPassword("rahasia");

        mockMvc.perform(
                post("/api/auth/login")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginUserRequest))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<TokenResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });
            assertNull(response.getErrors());
            assertNotNull(response.getData().getToken());
            assertNotNull(response.getData().getExpiredAt());

            User userDb = userRepository.findById("test").orElse(null);
            assertNotNull(userDb);
            assertEquals(userDb.getToken(), response.getData().getToken());
            assertEquals(userDb.getTokenExpiredAt(), response.getData().getExpiredAt());
        });
    }
}