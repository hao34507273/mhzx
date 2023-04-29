package xbean;

import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface GangRobber
  extends Bean
{
  public abstract GangRobber copy();
  
  public abstract GangRobber toData();
  
  public abstract GangRobber toBean();
  
  public abstract GangRobber toDataIf();
  
  public abstract GangRobber toBeanIf();
  
  public abstract Map<Long, GangMonsterRobber> getGangrobberdatas();
  
  public abstract Map<Long, GangMonsterRobber> getGangrobberdatasAsData();
  
  public abstract int getStage();
  
  public abstract Set<Integer> getRoundopenset();
  
  public abstract Set<Integer> getRoundopensetAsData();
  
  public abstract void setStage(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GangRobber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */