package pl.teamxd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.teamxd.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
