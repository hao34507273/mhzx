package xbean;

import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface CompetitionTmp
  extends Bean
{
  public abstract CompetitionTmp copy();
  
  public abstract CompetitionTmp toData();
  
  public abstract CompetitionTmp toBean();
  
  public abstract CompetitionTmp toDataIf();
  
  public abstract CompetitionTmp toBeanIf();
  
  public abstract Set<Long> getFights();
  
  public abstract Set<Long> getFightsAsData();
  
  public abstract Map<CompetitionMatch, MercenaryFights> getMercenary_fights();
  
  public abstract Map<CompetitionMatch, MercenaryFights> getMercenary_fightsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CompetitionTmp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */