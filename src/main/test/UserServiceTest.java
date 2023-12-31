import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.example.Entity.User;
import org.example.Repository.UserRepository;
import org.example.Service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetUserById() {
        // Arrange
        long userId = 1L;
        User mockUser = new User(userId, "John", "Doe", "john@example.com", "JohnDoe", "password", "TestBees", null, false);

        // Define the behavior of the mock repository
        when(userRepository.findById(userId)).thenReturn(Optional.of(mockUser));

        // Act
        User result = userService.getUserById(userId);

        // Assert
        assertEquals(mockUser, result);
    }

    @Test
    void testSaveUser() {
        // Arrange
        User userToSave = new User(1L, "John", "Doe", "john@example.com", "JohnDoe", "password", "TestBees", null, false);
        User savedUser = new User(1L, "John", "Doe", "john@example.com", "JohnDoe", "password", "TestBees", null, false);

        // Define the behavior of the mock repository
        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        // Act
        // userService.addUser(userToSave);

        userRepository.save(userToSave);

        User result = userService.getUserById(1L);

        // Assert
        assertEquals(savedUser, result);
    }
}