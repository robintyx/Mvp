package cn.microvideo.framework3.project.controller;

import cn.microvideo.framework3.project.entity.User;
import cn.microvideo.framework3.project.mapper.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test findAll() when users exist
     */
    @Test
    void findAll_ShouldReturnUserList_WhenUsersExist() {
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("User1");
        User user2 = new User();
        user2.setId(2);
        user2.setUsername("User2");
        // Arrange
        List<User> expectedUsers = Arrays.asList(
                user1, user2
        );
        when(userMapper.findAll()).thenReturn(expectedUsers);

        // Act
        Object result = userController.findAll();

        // Assert
        assertEquals(expectedUsers, result);
        verify(userMapper, times(1)).findAll();
    }

    /**
     * Test findAll() when no users exist
     */
    @Test
    void findAll_ShouldReturnEmptyList_WhenNoUsersExist() {
        // Arrange
        when(userMapper.findAll()).thenReturn(Collections.emptyList());

        // Act
        Object result = userController.findAll();

        // Assert
        assertTrue(((List<?>) result).isEmpty());
        verify(userMapper, times(1)).findAll();
    }

    /**
     * Test getUserById() when user exists
     */
    @Test
    void getUserById_ShouldReturnUser_WhenUserExists() {
        // Arrange
        Integer userId = 1;
        User expectedUser = new User();
        expectedUser.setId(userId);
        expectedUser.setUsername("ExistingUser");
        when(userMapper.selectById(userId)).thenReturn(expectedUser);

        // Act
        User result = userController.getUserById(userId);

        // Assert
        assertEquals(expectedUser, result);
        verify(userMapper, times(1)).selectById(userId);
    }

    /**
     * Test getUserById() when user does not exist
     */
    @Test
    void getUserById_ShouldReturnNull_WhenUserDoesNotExist() {
        // Arrange
        Integer userId = 999;
        when(userMapper.selectById(userId)).thenReturn(null);

        // Act
        User result = userController.getUserById(userId);

        // Assert
        assertNull(result);
        verify(userMapper, times(1)).selectById(userId);
    }

    /**
     * Test findAll() when database access fails
     */
    @Test
    void findAll_ShouldThrowException_WhenDatabaseFails() {
        // Arrange
        when(userMapper.findAll()).thenThrow(new RuntimeException("Database error"));

        // Act & Assert
        assertThrows(RuntimeException.class, () -> userController.findAll());
        verify(userMapper, times(1)).findAll();
    }

    /**
     * Test getUserById() when database access fails
     */
    @Test
    void getUserById_ShouldThrowException_WhenDatabaseFails() {
        // Arrange
        Integer userId = 1;
        when(userMapper.selectById(userId)).thenThrow(new RuntimeException("Database error"));

        // Act & Assert
        assertThrows(RuntimeException.class, () -> userController.getUserById(userId));
        verify(userMapper, times(1)).selectById(userId);
    }
}
