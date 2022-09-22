package elisa.kulturservice.service;

import elisa.kulturservice.model.Band;
import elisa.kulturservice.model.User;
import elisa.kulturservice.service.ICrudService;

import java.util.List;

public interface IUserService extends ICrudService<User, Long> {
    List<User> findUserByName(String name);

}
