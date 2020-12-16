package silab.nst.dan9.springJpa.service;

import silab.nst.dan9.springJpa.domain.Stats;

import java.util.List;

public interface StatsService {
    Stats updateStats(String key, Long value) throws Exception;

    List<Stats> getAllStats() throws Exception;

}
