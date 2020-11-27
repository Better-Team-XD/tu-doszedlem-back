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
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private double lat;

    @NotNull
    private double lng;

    @NotNull
    private String note;

    @NotNull
    private LocalDateTime date;

    @NotNull
    private int rate;

    public void updateLocation(Location newLocation){
        this.lat = newLocation.lat;
        this.lng = newLocation.lng;
        this.note = newLocation.note;
        this.date = newLocation.date;
        this.rate = newLocation.rate;


    }
}