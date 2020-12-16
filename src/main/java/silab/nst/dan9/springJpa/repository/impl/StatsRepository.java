package silab.nst.dan9.springJpa.repository.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import silab.nst.dan9.springJpa.domain.Stats;
import silab.nst.dan9.springJpa.repository.StatsUpdatedRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
@Transactional
public class StatsRepository implements StatsUpdatedRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Stats updateStats(Stats stats) throws Exception {
        Stats foundStats = entityManager.find(Stats.class, stats.getKey());

        Query query = entityManager.createQuery("select count(u.id) from User u");
        Long count = -1l;
        if (query.getResultList().size() > 0) {
            count = (Long) query.getResultList().get(0);
        } else {
            throw new Exception(this.getClass().getName() + " -> updateStats()");
        }
        foundStats.setValue(count);

        return entityManager.merge(foundStats);
    }

    @Override
    public List<Stats> getAllStats() throws Exception {
        return entityManager.createQuery("select s from Stats s", Stats.class).getResultList();
    }
}
