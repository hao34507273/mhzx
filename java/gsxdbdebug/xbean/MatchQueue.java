package xbean;

import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface MatchQueue
  extends Bean
{
  public abstract MatchQueue copy();
  
  public abstract MatchQueue toData();
  
  public abstract MatchQueue toBean();
  
  public abstract MatchQueue toDataIf();
  
  public abstract MatchQueue toBeanIf();
  
  public abstract Map<MatchKey, TeamMatchQueue> getTeamqueue();
  
  public abstract Map<MatchKey, TeamMatchQueue> getTeamqueueAsData();
  
  public abstract Map<MatchKey, TeamMatchQueue> getRolequeue();
  
  public abstract Map<MatchKey, TeamMatchQueue> getRolequeueAsData();
  
  public abstract Set<Long> getRepeatteamids();
  
  public abstract Set<Long> getRepeatteamidsAsData();
  
  public abstract Set<Long> getRepeatleaderids();
  
  public abstract Set<Long> getRepeatleaderidsAsData();
  
  public abstract Map<Long, MatchActivityCfg> getRoleinfo();
  
  public abstract Map<Long, MatchActivityCfg> getRoleinfoAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MatchQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */