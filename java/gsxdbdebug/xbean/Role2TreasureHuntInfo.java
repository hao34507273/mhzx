package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface Role2TreasureHuntInfo
  extends Bean
{
  public abstract Role2TreasureHuntInfo copy();
  
  public abstract Role2TreasureHuntInfo toData();
  
  public abstract Role2TreasureHuntInfo toBean();
  
  public abstract Role2TreasureHuntInfo toDataIf();
  
  public abstract Role2TreasureHuntInfo toBeanIf();
  
  public abstract Map<Integer, RoleTreasureHuntActivityInfo> getTreasure_hunt_activity_map();
  
  public abstract Map<Integer, RoleTreasureHuntActivityInfo> getTreasure_hunt_activity_mapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Role2TreasureHuntInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */