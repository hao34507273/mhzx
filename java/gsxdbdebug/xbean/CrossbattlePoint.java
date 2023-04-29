package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface CrossbattlePoint
  extends Bean
{
  public abstract CrossbattlePoint copy();
  
  public abstract CrossbattlePoint toData();
  
  public abstract CrossbattlePoint toBean();
  
  public abstract CrossbattlePoint toDataIf();
  
  public abstract CrossbattlePoint toBeanIf();
  
  public abstract Map<Integer, CrossbattlePointRaceInfo> getPoint_races();
  
  public abstract Map<Integer, CrossbattlePointRaceInfo> getPoint_racesAsData();
  
  public abstract int getTime_point_cfgid();
  
  public abstract Map<Long, Integer> getCorps_result();
  
  public abstract Map<Long, Integer> getCorps_resultAsData();
  
  public abstract void setTime_point_cfgid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossbattlePoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */