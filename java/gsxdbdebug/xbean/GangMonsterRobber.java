package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface GangMonsterRobber
  extends Bean
{
  public abstract GangMonsterRobber copy();
  
  public abstract GangMonsterRobber toData();
  
  public abstract GangMonsterRobber toBean();
  
  public abstract GangMonsterRobber toDataIf();
  
  public abstract GangMonsterRobber toBeanIf();
  
  public abstract Map<Integer, MonsterRobberRound> getRobberrounddatas();
  
  public abstract Map<Integer, MonsterRobberRound> getRobberrounddatasAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GangMonsterRobber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */