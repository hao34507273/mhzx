package xbean;

import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface FactionPVETmp
  extends Bean
{
  public abstract FactionPVETmp copy();
  
  public abstract FactionPVETmp toData();
  
  public abstract FactionPVETmp toBean();
  
  public abstract FactionPVETmp toDataIf();
  
  public abstract FactionPVETmp toBeanIf();
  
  public abstract long getWorld();
  
  public abstract int getStage();
  
  public abstract long getSessionid();
  
  public abstract Map<Integer, Integer> getGoal();
  
  public abstract Map<Integer, Integer> getGoalAsData();
  
  public abstract long getEnd_sessionid();
  
  public abstract Set<Long> getFights();
  
  public abstract Set<Long> getFightsAsData();
  
  public abstract Map<Integer, Integer> getKilled_boss();
  
  public abstract Map<Integer, Integer> getKilled_bossAsData();
  
  public abstract void setWorld(long paramLong);
  
  public abstract void setStage(int paramInt);
  
  public abstract void setSessionid(long paramLong);
  
  public abstract void setEnd_sessionid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FactionPVETmp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */