package silab.nst.dan9.springJpa.service;

import silab.nst.dan9.springJpa.domain.User;

import java.util.List;

public interface UserService {
    User add(User user) throws Exception;

    User delete(User user) throws Exception;

    User update(User user) throws Exception;

    User findUserById(Long id) throws Exception;

    List<User> getAllUsers() throws Exception;


}
