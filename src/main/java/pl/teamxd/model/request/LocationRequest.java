package pl.teamxd.model.request;

import lombok.AllArgsConstructor;
import pl.teamxd.model.entity.Location;

import java.util.List;


@AllArgsConstructor
public class LocationRequest {
    private final List<Location> locations;
}
