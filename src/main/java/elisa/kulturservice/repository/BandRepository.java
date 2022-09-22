package elisa.kulturservice.repository;

import elisa.kulturservice.model.Band;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandRepository extends JpaRepository<Band, Long> {
}
