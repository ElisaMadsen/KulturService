package elisa.kulturservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Band {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "band") // Event klassen har allerede mappet til denne Band klasse.
                                // Derfor behøver JPA ikke at mappe fra Band til Event
    private Set<Event> events = new HashSet<>();
}
