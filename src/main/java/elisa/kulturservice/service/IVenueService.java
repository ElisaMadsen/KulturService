package elisa.kulturservice.service;

import elisa.kulturservice.model.Venue;
import org.springframework.data.repository.CrudRepository;

public interface IVenueService extends ICrudService<Venue, Long> {
}
