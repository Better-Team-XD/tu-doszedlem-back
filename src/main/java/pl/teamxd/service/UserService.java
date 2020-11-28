package pl.teamxd.service;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.teamxd.model.security.MyUserDetails;
import pl.teamxd.repository.MyUserRepository;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService{
    private final MyUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new MyUserDetails(repository.findMyUserByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(username + " not found")
        ));
    }
}
