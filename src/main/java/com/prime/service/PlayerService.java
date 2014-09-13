package com.prime.service;

import com.prime.api.PitchStats;
import com.prime.dao.PitchDao;
import com.prime.dao.PlayerDao;
import com.prime.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PlayerService {

  @Autowired(required = true)
  private PitchDao pitchDao;

  @Autowired(required = true)
  private PlayerDao playerDao;

  public Player getPlayer(int eliasId) {
    return playerDao.getPlayer(eliasId);
  }

  public List<Player> getPlayers() {
    return playerDao.getPlayers();
  }

  public List<PitchStats> getMonthlyPitchStatsByPitcher(int pitcherId) {
    return pitchDao.getMonthlyPitchStatsByPitcher(pitcherId);
  }

  public List<PitchStats> getYearlyPitchStatsByPitcher(int pitcherId) {
    return pitchDao.getYearlyPitchStatsByPitcher(pitcherId);
  }
}
