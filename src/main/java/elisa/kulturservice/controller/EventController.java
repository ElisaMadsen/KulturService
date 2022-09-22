package elisa.kulturservice.controller;
import elisa.kulturservice.model.Band;
import elisa.kulturservice.model.Event;
import elisa.kulturservice.service.IBandService;
import elisa.kulturservice.service.IEventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
public class EventController {

    private IEventService eventService;

    private IBandService bandService;

    public EventController(IEventService eventService, IBandService bandService) {
        this.eventService = eventService;
        this.bandService = bandService;
    }

    @PostMapping("/createEvent")
    public ResponseEntity<String> createEvent(@RequestBody Event event, @RequestParam Long bandId) {
        //1. hent band
        Optional<Band> band = bandService.findById(bandId);
        if (band.isPresent()) {
            event.setBand(band.get());
            eventService.save(event);
            return new ResponseEntity<>("Event oprettet", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Band ikke fundet " + bandId, HttpStatus.OK);
        }
    }

    @GetMapping("/getEvents")
    public ResponseEntity<Set<Event>> alleEvents(){
        Set allEvents = eventService.findAll();
        return new ResponseEntity<>(allEvents, HttpStatus.OK);
    }
}
