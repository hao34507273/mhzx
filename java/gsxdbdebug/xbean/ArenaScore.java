package xbean;

import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface ArenaScore
  extends Bean
{
  public abstract ArenaScore copy();
  
  public abstract ArenaScore toData();
  
  public abstract ArenaScore toBean();
  
  public abstract ArenaScore toDataIf();
  
  public abstract ArenaScore toBeanIf();
  
  public abstract int getCamp();
  
  public abstract int getScore();
  
  public abstract int getAction_point();
  
  public abstract int getWin_times();
  
  public abstract Set<Integer> getGet_awards();
  
  public abstract Set<Integer> getGet_awardsAsData();
  
  public abstract boolean getParticipated();
  
  public abstract Map<Long, Integer> getMatchroles();
  
  public abstract Map<Long, Integer> getMatchrolesAsData();
  
  public abstract void setCamp(int paramInt);
  
  public abstract void setScore(int paramInt);
  
  public abstract void setAction_point(int paramInt);
  
  public abstract void setWin_times(int paramInt);
  
  public abstract void setParticipated(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ArenaScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */