package pl.teamxd.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.teamxd.model.security.Role;
import pl.teamxd.model.entity.Location;
import pl.teamxd.model.entity.MyUser;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Repository
@RequiredArgsConstructor
public class MockData {
    private final LocationRepository locationRepository;
    private final MyUserRepository myUserRepository;

    @PostConstruct
    public void init(){
        Location location1 = Location.builder()
                .lat(6.9)
                .lng(21.37)
                .note("Tutaj doszedlem :-)")
                .date(LocalDateTime.now())
                .rate(5)
                .build();

        locationRepository.save(location1);

        MyUser myUser = MyUser.builder()
                .username("kraleppa")
                .password("password")
                .role(Role.ADMIN)
                .build();

        myUserRepository.save(myUser);
    }
}
