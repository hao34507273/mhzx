package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface GangRaceRoleInfo
  extends Bean
{
  public abstract GangRaceRoleInfo copy();
  
  public abstract GangRaceRoleInfo toData();
  
  public abstract GangRaceRoleInfo toBean();
  
  public abstract GangRaceRoleInfo toDataIf();
  
  public abstract GangRaceRoleInfo toBeanIf();
  
  public abstract int getGameid();
  
  public abstract Map<Integer, Integer> getRaceid2money();
  
  public abstract Map<Integer, Integer> getRaceid2moneyAsData();
  
  public abstract void setGameid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GangRaceRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */