package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface BattleGatherData
  extends Bean
{
  public abstract BattleGatherData copy();
  
  public abstract BattleGatherData toData();
  
  public abstract BattleGatherData toBean();
  
  public abstract BattleGatherData toDataIf();
  
  public abstract BattleGatherData toBeanIf();
  
  public abstract Map<Long, GatherItemData> getGatheritemdatas();
  
  public abstract Map<Long, GatherItemData> getGatheritemdatasAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BattleGatherData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */