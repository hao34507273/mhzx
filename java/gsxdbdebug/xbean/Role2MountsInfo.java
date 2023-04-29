package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface Role2MountsInfo
  extends Bean
{
  public abstract Role2MountsInfo copy();
  
  public abstract Role2MountsInfo toData();
  
  public abstract Role2MountsInfo toBean();
  
  public abstract Role2MountsInfo toDataIf();
  
  public abstract Role2MountsInfo toBeanIf();
  
  public abstract Map<Long, MountsInfo> getMounts_info_map();
  
  public abstract Map<Long, MountsInfo> getMounts_info_mapAsData();
  
  public abstract Map<Integer, BattleMountsInfo> getBattle_mounts_info_map();
  
  public abstract Map<Integer, BattleMountsInfo> getBattle_mounts_info_mapAsData();
  
  public abstract Map<Long, AppearenceMountsInfo> getAppearence_mounts_info_map();
  
  public abstract Map<Long, AppearenceMountsInfo> getAppearence_mounts_info_mapAsData();
  
  public abstract long getCurrent_ride_mounts_id();
  
  public abstract int getCurrent_chief_battle_mounts();
  
  public abstract void setCurrent_ride_mounts_id(long paramLong);
  
  public abstract void setCurrent_chief_battle_mounts(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Role2MountsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */