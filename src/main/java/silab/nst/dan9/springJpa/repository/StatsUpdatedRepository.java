package silab.nst.dan9.springJpa.repository;

import silab.nst.dan9.springJpa.domain.Stats;

import java.util.List;

public interface StatsUpdatedRepository {
    Stats updateStats(Stats stats) throws Exception;

    List<Stats> getAllStats() throws Exception;

}
