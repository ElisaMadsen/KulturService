package elisa.kulturservice.service;

import elisa.kulturservice.model.Band;
import elisa.kulturservice.repository.BandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BandService implements IBandService{

    private BandRepository bandRepository;

    public BandService(BandRepository bandRepository){
        this.bandRepository = bandRepository;
    }

    @Override
    public Set<Band> findAll() {
        return null;
    }

    @Override
    public Band save(Band object) {
        return bandRepository.save(object);
    }

    @Override
    public void delete(Band object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Band> findById(Long aLong) {
        return bandRepository.findById(aLong);
    }

    @Override
    public List<Band> findBandByName(String name) {
        return bandRepository.findBandByName(name);
    }
}
