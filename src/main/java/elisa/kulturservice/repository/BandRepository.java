package elisa.kulturservice.repository;

import elisa.kulturservice.model.Band;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BandRepository extends JpaRepository<Band, Long> {

    List<Band> findBandByName(String name);
}
