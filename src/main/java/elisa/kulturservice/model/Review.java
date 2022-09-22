package elisa.kulturservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne
    @JsonBackReference // pga. cirkulær reference i @Restcontroller
    @EqualsAndHashCode.Exclude //pga. hashCode() fra @Data
    private Event event;

    private String reviewText;
    private int rating;

    @ManyToOne
    @JsonBackReference // pga. cirkulær reference i @Restcontroller
    @EqualsAndHashCode.Exclude //pga. hashCode() fra @Data
    private User user;


}
