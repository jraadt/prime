package com.prime.dao.hibernate;

import com.prime.api.PitchStats;
import com.prime.dao.PitchDao;
import com.prime.domain.Pitch;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("pitchDao")
public class HibernatePitchDao implements PitchDao {

  @Autowired(required = true)
  @Qualifier(value = "sessionFactory")
  private SessionFactory sessionFactory;

  public List<PitchStats> getMonthlyPitchStatsByPitcher(int pitcherId) {
    return getPitchStatsByPitcher(pitcherId, "pitch.monthThrown");
  }

  public List<PitchStats> getYearlyPitchStatsByPitcher(int pitcherId) {
    return getPitchStatsByPitcher(pitcherId, "substring(pitch.monthThrown, 1, 2)");
  }

  private List<PitchStats> getPitchStatsByPitcher(int pitcherId, String grouping) {
    return (List<PitchStats>)this.sessionFactory.getCurrentSession().createQuery("select " + grouping + " as date, " +
        "pitch.pitchType as pitchType, " +
        "count(pitch.pitchId) as total, " +
        "avg(pitch.x0) as x0Average, " +
        "sqrt((sum(pitch.x0 * pitch.x0) / count(pitch.x0)) - (avg(pitch.x0) * avg(pitch.x0))) as x0StandardDeviation, " +
        "avg(pitch.z0) as z0Average, " +
        "sqrt((sum(pitch.z0 * pitch.z0) / count(pitch.z0)) - (avg(pitch.z0) * avg(pitch.z0))) as z0StandardDeviation, " +
        "avg(pitch.vx0) as vx0Average, " +
        "sqrt((sum(pitch.vx0 * pitch.vx0) / count(pitch.vx0)) - (avg(pitch.vx0) * avg(pitch.vx0))) as vx0StandardDeviation, " +
        "avg(pitch.vy0) as vy0Average, " +
        "sqrt((sum(pitch.vy0 * pitch.vy0) / count(pitch.vy0)) - (avg(pitch.vy0) * avg(pitch.vy0))) as vy0StandardDeviation, " +
        "avg(pitch.vz0) as vz0Average, " +
        "sqrt((sum(pitch.vz0 * pitch.vz0) / count(pitch.vz0)) - (avg(pitch.vz0) * avg(pitch.vz0))) as vz0StandardDeviation, " +
        "avg(pitch.ax) as axAverage, " +
        "sqrt((sum(pitch.ax * pitch.ax) / count(pitch.ax)) - (avg(pitch.ax) * avg(pitch.ax))) as axStandardDeviation, " +
        "avg(pitch.ay) as ayAverage, " +
        "sqrt((sum(pitch.ay * pitch.ay) / count(pitch.ay)) - (avg(pitch.ay) * avg(pitch.ay))) as ayStandardDeviation, " +
        "avg(pitch.az) as azAverage, " +
        "sqrt((sum(pitch.az * pitch.az) / count(pitch.az)) - (avg(pitch.az) * avg(pitch.az))) as azStandardDeviation " +
        "from Pitch pitch where pitch.atBat.pitcher = :pitcherId and pitch.y0 = 50 and (pitch.monthThrown like '0%' or pitch.monthThrown like '1%') group by " + grouping + ", pitch.pitchType order by pitch.timeThrown")
        .setInteger("pitcherId", pitcherId)
        .setResultTransformer(Transformers.aliasToBean(PitchStats.class)).list();
  }
}
