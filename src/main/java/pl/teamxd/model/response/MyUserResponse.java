package pl.teamxd.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.teamxd.model.entity.MyUser;

import java.util.List;

@AllArgsConstructor
@Getter
public class MyUserResponse {
    private final List<MyUser> myUserList;
}
