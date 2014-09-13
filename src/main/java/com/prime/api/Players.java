package com.prime.api;

import com.prime.domain.Player;
import com.prime.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value="/api/players")
public class Players {

  private final PlayerService playerService;

  @Autowired
  public Players(PlayerService playerService) {
    this.playerService = playerService;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{playerId}/stats")
  public @ResponseBody HashMap<String, List<PitchStats>> getPlayerStats(@PathVariable("playerId") Integer playerId) {
    HashMap<String, List<PitchStats>> playerStats = new HashMap<>();
    playerStats.put("month", playerService.getMonthlyPitchStatsByPitcher(playerId));
    playerStats.put("year", playerService.getYearlyPitchStatsByPitcher(playerId));
    return playerStats;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{playerId}")
  public @ResponseBody Player getPlayer(@PathVariable("playerId") Integer playerId) {
    return playerService.getPlayer(playerId);
  }

  @RequestMapping(method = RequestMethod.GET)
  public @ResponseBody Collection<Player> getPlayers() {
    return playerService.getPlayers();
  }
}
