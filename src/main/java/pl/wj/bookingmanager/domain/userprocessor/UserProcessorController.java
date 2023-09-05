package pl.wj.bookingmanager.domain.userprocessor;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.wj.bookingmanager.common.PaginationHelper;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserLoginRequestDto;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserRegisterRequestDto;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserResponseDto;
import pl.wj.bookingmanager.domain.userprocessor.model.dto.UserUpdateRequestDto;
import pl.wj.bookingmanager.infrastructure.security.SecurityService;
import pl.wj.bookingmanager.infrastructure.security.model.dto.JwtResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserProcessorController {
    private final UserProcessorService userProcessorService;
    private final SecurityService securityService;

    @GetMapping
    public Page<UserResponseDto> getUsers(@RequestParam int pageNumber,
                                          @RequestParam int pageSize,
                                          @RequestParam Sort.Direction direction,
                                          @RequestParam String sortBy) {
        Pageable pageable = PaginationHelper.createPagination(pageNumber, pageSize, direction, sortBy);
        return userProcessorService.getUsers(pageable);
    }

    @GetMapping("/archived")
    public Page<UserResponseDto> getArchivedUsers(@RequestParam int pageNumber,
                                                  @RequestParam int pageSize,
                                                  @RequestParam Sort.Direction direction,
                                                  @RequestParam String sortBy) {
        Pageable pageable = PaginationHelper.createPagination(pageNumber, pageSize, direction, sortBy);
        return userProcessorService.getArchivedUsers(pageable);
    }

    @GetMapping("/active")
    public Page<UserResponseDto> getActiveUsers(@RequestParam int pageNumber,
                                                @RequestParam int pageSize,
                                                @RequestParam Sort.Direction direction,
                                                @RequestParam String sortBy) {
        Pageable pageable = PaginationHelper.createPagination(pageNumber, pageSize, direction, sortBy);
        return userProcessorService.getActiveUsers(pageable);
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

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "User update endpoint",
               description = """
                               You have to pass <b>complete user model</b>. Fields that you do not want to update, leave unedited but filled.<br>
                               If you will pass empty field, in worst scenario it will update that field to default value.<br><br>
                               Returns updated user without password field.""")
    public UserResponseDto updateUser(@PathVariable long id, @Valid @RequestBody UserUpdateRequestDto userUpdateRequestDto) {
        return userProcessorService.updateUser(id, userUpdateRequestDto);
    }
}
