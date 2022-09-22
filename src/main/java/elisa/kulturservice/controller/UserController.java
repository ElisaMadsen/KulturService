package elisa.kulturservice.controller;
import elisa.kulturservice.model.User;
import elisa.kulturservice.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private IUserService userService;

    public UserController(IUserService userService){
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody User user){
        String message = "";
        if (userService.save(user)!=null){
            message = user.getName() + " blev gemt.";
        } else {
            message = "fejl i oprettelse af " + user.getName();
        }
            return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
