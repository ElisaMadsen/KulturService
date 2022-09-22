package elisa.kulturservice.controller;
import elisa.kulturservice.model.*;
import elisa.kulturservice.service.IBandService;
import elisa.kulturservice.service.IEventService;
import elisa.kulturservice.service.IReviewService;
import elisa.kulturservice.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ReviewController {

    private IReviewService reviewService;
    private IEventService eventService;
    private IUserService userService;


    @PostMapping("/createReview")
    public ResponseEntity<Review> createReview(@RequestBody Review review, @RequestParam Long userId,
                                                @RequestParam Long eventId) {
        if (review == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Optional<User> user = userService.findById(userId);
            Optional<Event> event = eventService.findById(eventId);
            if (user.isPresent() && event.isPresent()) {
                review.setReviewUser(user.get());
                review.setReviewEvent(event.get());
                reviewService.save(review);
                return new ResponseEntity<>(review, HttpStatus.OK);
            }
            return new ResponseEntity<>(review, HttpStatus.OK);

        }
    }
}
