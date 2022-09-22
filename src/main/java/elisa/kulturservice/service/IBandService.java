package elisa.kulturservice.service;

import elisa.kulturservice.model.Band;

import java.util.List;

public interface IBandService extends ICrudService<Band, Long>{
    List<Band> findBandByName(String name);
}
