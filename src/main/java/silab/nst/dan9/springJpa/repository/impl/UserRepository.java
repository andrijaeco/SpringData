package silab.nst.dan9.springJpa.repository.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import silab.nst.dan9.springJpa.domain.User;
import silab.nst.dan9.springJpa.repository.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Component
@Transactional(propagation = Propagation.MANDATORY)
public class UserRepository implements Repository<User, Long> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User add(User user) throws Exception {
        entityManager.persist(user); // if user already exists this performs update
        return user;
    }

    @Override
    public User update(User user) throws Exception {
        return entityManager.merge(user);
    }

    @Override
    public User delete(User user) throws Exception {
        entityManager.remove(entityManager.find(User.class, user.getId()));
        return user;
    }

    @Override
    public List<User> getAll() throws Exception {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User findById(Long id) throws Exception {
        return entityManager.find(User.class, id);
    }
}
