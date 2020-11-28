package pl.teamxd.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.teamxd.model.entity.Location;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Repository
@RequiredArgsConstructor
public class MockData {
    private final LocationRepository locationRepository;

    @PostConstruct
    public void init(){
        Location location1 = Location.builder()
                .latitude(6.9)
                .longitude(21.37)
                .note("Tutaj doszedlem :-)")
                .date(LocalDateTime.now())
                .rating(5)
                .build();

        locationRepository.save(location1);
    }
}
