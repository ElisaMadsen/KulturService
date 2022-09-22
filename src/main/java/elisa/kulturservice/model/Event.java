package elisa.kulturservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String venue;
    private Timestamp timestamp; //format: 2022-09-22T07:08:52.713+00:00
    @ManyToOne
    @JsonBackReference // pga. cirkulær reference i @Restcontroller
    @EqualsAndHashCode.Exclude //pga. hashCode() fra @Data
    private Band band;

    @OneToMany(mappedBy = "reviewEvent")
    private Set<Review> reviews = new HashSet<>();

}
