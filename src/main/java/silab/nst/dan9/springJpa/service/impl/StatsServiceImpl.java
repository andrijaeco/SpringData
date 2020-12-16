package silab.nst.dan9.springJpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import silab.nst.dan9.springJpa.domain.Stats;
import silab.nst.dan9.springJpa.repository.StatsUpdatedRepository;
import silab.nst.dan9.springJpa.service.StatsService;

import java.util.List;

@Component
@Transactional
public class StatsServiceImpl implements StatsService {

    @Autowired
    private StatsUpdatedRepository statsRepository;

    @Override
    public Stats updateStats(String key, Long value) throws Exception {
        return statsRepository.updateStats(new Stats(key, value));
    }

    @Override
    public List<Stats> getAllStats() throws Exception {
        return statsRepository.getAllStats();
    }
}
