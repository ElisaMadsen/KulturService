package elisa.kulturservice.controller;
import elisa.kulturservice.model.Band;
import elisa.kulturservice.model.User;
import elisa.kulturservice.model.Venue;
import elisa.kulturservice.service.IUserService;
import elisa.kulturservice.service.IVenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private IUserService userService;
    private IVenueService venueService;

    public UserController(IUserService userService, IVenueService venueService) {
        this.userService = userService;
        this.venueService = venueService;
    }

    @PostMapping("/createLike")
    public ResponseEntity<String> createLike(@RequestParam Long userId, @RequestParam Long venueId){
        Optional<User> user = userService.findById(userId);
        Optional<Venue> venue = venueService.findById(userId);
        if (user.isPresent() && venue.isPresent()){
            user.get().getVenuesLiked().add(venue.get());
            userService.save(user.get());
            return new ResponseEntity<>("Gemt user " + userId + " med like venue "
                                                                + venueId, HttpStatus.OK);
        }
        return new ResponseEntity<>("Fejl at oprette like ", HttpStatus.OK);

    }

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody User user){
        System.out.println(user);
        String message = "";
        if (userService.save(user)!=null){
            message = user.getName() + " blev gemt.";
        } else {
            message = "fejl i oprettelse af " + user.getName();
        }
            return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/getUserByName")
    public ResponseEntity<List<User>> getUserByName(String name){
        return new ResponseEntity<>(userService.findUserByName(name), HttpStatus.OK);
    }
}
