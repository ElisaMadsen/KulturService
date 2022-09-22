package elisa.kulturservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data // ... hashCode()
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String venue;
    @ManyToOne
    @JsonBackReference // pga. cirkulær reference i @Restcontroller
    @EqualsAndHashCode.Exclude //pga. hashCode() fra @Data
    private Band band;

    @OneToMany(mappedBy = "event")
    private Set<Review> reviews = new HashSet<>();

}
