package pl.teamxd.model.entity;

import com.sun.istack.NotNull;
import lombok.*;
import pl.teamxd.model.security.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

    // TODO: fetch type?
    @OneToMany
    private Set<Location> myLocations = new HashSet<>();

    public void addLocation(Location location) {
        if (location == null) {
            throw new NullPointerException("Location cannot be null");
        }

        myLocations.add(location);
    }

    public void updateMyUser(MyUser updatedMyUser) {
        this.username = updatedMyUser.username;
        this.password = updatedMyUser.password;
        this.role = updatedMyUser.role;
        this.myLocations = updatedMyUser.myLocations;
    }

}
