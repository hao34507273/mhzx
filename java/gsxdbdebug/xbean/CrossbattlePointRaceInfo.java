package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface CrossbattlePointRaceInfo
  extends Bean
{
  public abstract CrossbattlePointRaceInfo copy();
  
  public abstract CrossbattlePointRaceInfo toData();
  
  public abstract CrossbattlePointRaceInfo toBean();
  
  public abstract CrossbattlePointRaceInfo toDataIf();
  
  public abstract CrossbattlePointRaceInfo toBeanIf();
  
  public abstract int getTime_point_cfgid();
  
  public abstract Map<Long, PointRaceInfo> getCorps();
  
  public abstract Map<Long, PointRaceInfo> getCorpsAsData();
  
  public abstract Map<Long, Boolean> getNext_mailed();
  
  public abstract Map<Long, Boolean> getNext_mailedAsData();
  
  public abstract List<Integer> getBackup_zones();
  
  public abstract List<Integer> getBackup_zonesAsData();
  
  public abstract void setTime_point_cfgid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossbattlePointRaceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */