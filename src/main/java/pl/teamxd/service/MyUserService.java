package pl.teamxd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.teamxd.model.entity.MyUser;
import pl.teamxd.model.response.MyUserResponse;
import pl.teamxd.repository.MyUserRepository;

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
}
