package pl.teamxd.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.teamxd.model.entity.Location;

import java.util.List;


@AllArgsConstructor
@Getter
public class LocationResponse {
    private final List<Location> locations;
}
