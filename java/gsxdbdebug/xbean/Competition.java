package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface Competition
  extends Bean
{
  public abstract Competition copy();
  
  public abstract Competition toData();
  
  public abstract Competition toBean();
  
  public abstract Competition toDataIf();
  
  public abstract Competition toBeanIf();
  
  public abstract Map<CompetitionMatch, Integer> getMatch2times();
  
  public abstract Map<CompetitionMatch, Integer> getMatch2timesAsData();
  
  public abstract int getMatchtimes();
  
  public abstract Map<CompetitionMatch, CompetitionAgainst> getAgainsts();
  
  public abstract Map<CompetitionMatch, CompetitionAgainst> getAgainstsAsData();
  
  public abstract Map<Long, MissTurn> getMiss_turns();
  
  public abstract Map<Long, MissTurn> getMiss_turnsAsData();
  
  public abstract void setMatchtimes(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Competition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */