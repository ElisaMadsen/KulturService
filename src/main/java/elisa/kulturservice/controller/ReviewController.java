package elisa.kulturservice.controller;
import elisa.kulturservice.model.Band;
import elisa.kulturservice.model.Event;
import elisa.kulturservice.model.Review;
import elisa.kulturservice.model.User;
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
    public ResponseEntity<String> createReview(@RequestBody Review review, @RequestParam Long userId,
                                               @RequestParam Long eventId) {

        Optional<Event> user = eventService.findById(eventId);
        Optional<Event> event = eventService.findById(eventId);

        if (user.isPresent()) {
            user.getUser();
            userService.save(review);

            return new ResponseEntity<>("Event oprettet", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Band ikke fundet " + bandId, HttpStatus.OK);
        }


    }
}
