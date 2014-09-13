package com.prime.dao;

import com.prime.domain.Player;

import java.util.List;

public interface PlayerDao {

  public Player getPlayer(int eliasId);

  public List<Player> getPlayers();
}
