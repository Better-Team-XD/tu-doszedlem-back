package pl.teamxd.model.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private double latitude;

    @NotNull
    private double longitude;

    @NotNull
    private String note;

    @NotNull
    private LocalDateTime date;

    @NotNull
    private int rating;

    public void updateLocation(Location newLocation){
        this.latitude = newLocation.latitude;
        this.longitude = newLocation.longitude;
        this.note = newLocation.note;
        this.date = newLocation.date;
        this.rating = newLocation.rating;
    }
}
