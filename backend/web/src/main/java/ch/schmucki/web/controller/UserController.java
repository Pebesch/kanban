package ch.schmucki.web.controller;

import ch.schmucki.core.board.KanbanBoard;
import ch.schmucki.services.UserService;
import ch.schmucki.web.dto.BoardDto;
import ch.schmucki.web.dto.LoginDto;
import ch.schmucki.web.dto.NewBoardDto;
import ch.schmucki.web.dto.RegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterDto dto) {
        if(dto.isValid()) {
            this.userService.register(dto.username(), dto.password());
            return "success";
        }
        return "failure";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDto dto) {
        try {
            userService.login(dto.username(), dto.password());
            return "success";
        } catch (IllegalArgumentException e) {
            return "failure";
        }
    }
}
