package com.prime.dao.hibernate;

import com.prime.dao.PlayerDao;
import com.prime.domain.Player;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("playerDao")
public class HibernatePlayerDao implements PlayerDao {

  @Autowired(required = true)
  @Qualifier(value = "sessionFactory")
  private SessionFactory sessionFactory;

  public Player getPlayer(int eliasId) {
    return (Player)this.sessionFactory.getCurrentSession().createQuery("from Player player where player.eliasId = :eliasId")
        .setInteger("eliasId", eliasId).uniqueResult();
  }

  public List<Player> getPlayers() {
    return this.sessionFactory.getCurrentSession().createQuery("from Player player").list();
  }
}
