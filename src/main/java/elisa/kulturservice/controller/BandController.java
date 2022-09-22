package elisa.kulturservice.controller;

import elisa.kulturservice.model.Band;
import elisa.kulturservice.service.IBandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BandController {

    private IBandService bandService;

    public BandController(IBandService bandService){
        this.bandService = bandService;
    }

    @PostMapping("/createBand")
    public ResponseEntity<String> createBand(@RequestBody Band band){
        String message = "";
        if (bandService.save(band)!= null){
            message = band.getName() + " blev oprettet";
        } else {
            message = band.getName() + " blev IKKE oprettet";
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/getBandByName")
    public ResponseEntity<List<Band>> getBandByName(String name){
        return new ResponseEntity<>(bandService.findBandByName(name), HttpStatus.OK);
    }
}
