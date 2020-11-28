package pl.teamxd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.teamxd.model.entity.Location;
import pl.teamxd.model.entity.MyUser;
import pl.teamxd.model.response.MyUserResponse;
import pl.teamxd.repository.MyUserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyUserService {

    private final MyUserRepository myUserRepository;

    public MyUserResponse getAllUsers() {
        return new MyUserResponse((myUserRepository.findAll()));
    }

    public MyUser addMyUser(MyUser myUser) {

        if (myUser == null) {
            throw new NullPointerException("User cannot be null");
        }

        return myUserRepository.save(myUser);
    }

    public void deleteMyUser(String username) {
        myUserRepository.deleteMyUserByUsername(username);
    }

    public MyUser editMyUser(String username, MyUser newMyUser) {
        MyUser oldMyUser = myUserRepository.findMyUserByUsername(username)
                .orElseThrow(IllegalAccessError::new);

        oldMyUser.updateMyUser(newMyUser);
        return myUserRepository.save(oldMyUser);
    }

    public MyUser getMyUserByUsername(String username) {
        return myUserRepository.findMyUserByUsername(username).orElseThrow(EntityNotFoundException::new);
    }

    public List<Location> getMyUserLocations(String username) {
        MyUser myUser = myUserRepository.findMyUserByUsername(username)
                .orElseThrow(EntityNotFoundException::new);

        return new ArrayList<>(myUser.getMyLocations());
    }
}
