package com.prime.dao;

import com.prime.api.PitchStats;

import java.util.List;

public interface PitchDao {

  public List<PitchStats> getMonthlyPitchStatsByPitcher(int pitcherId);

  public List<PitchStats> getYearlyPitchStatsByPitcher(int pitcherId);

}
