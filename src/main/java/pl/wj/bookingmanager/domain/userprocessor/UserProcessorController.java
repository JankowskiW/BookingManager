package pl.wj.bookingmanager.domain.userprocessor;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.wj.bookingmanager.domain.userprocessor.model.User;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserLoginRequestDto;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserRegisterRequestDto;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserResponseDto;
import pl.wj.bookingmanager.infrastructure.security.SecurityService;
import pl.wj.bookingmanager.infrastructure.security.model.dto.JwtResponseDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserProcessorController {
    private final UserProcessorService userProcessorService;
    private final SecurityService securityService;

    @GetMapping
    public List<User> getUsers() {
        return userProcessorService.getUsers();
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto registerUser(@Valid @RequestBody UserRegisterRequestDto userRegisterRequestDto) {
        return userProcessorService.addUser(userRegisterRequestDto);
    }

    @PostMapping("/login")
    public JwtResponseDto login(@Valid @RequestBody UserLoginRequestDto userLoginRequestDto) {
        return securityService.login(userLoginRequestDto);
    }

}
