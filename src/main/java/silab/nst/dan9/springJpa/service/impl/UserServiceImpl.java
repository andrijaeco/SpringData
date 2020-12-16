package silab.nst.dan9.springJpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import silab.nst.dan9.springJpa.domain.User;
import silab.nst.dan9.springJpa.repository.Repository;
import silab.nst.dan9.springJpa.service.UserService;

import java.util.List;

@Component
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private Repository userRepository;

    @Override
    public User add(User user) throws Exception {
        return (User) userRepository.add(user);
    }

    @Override
    public User delete(User user) throws Exception {
        return (User) userRepository.delete(user);
    }

    @Override
    public User update(User user) throws Exception {
        return (User) userRepository.update(user);
    }

    @Override
    public User findUserById(Long id) throws Exception {
        return (User) userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() throws Exception {
        return userRepository.getAll();
    }
}
