package xbean;

import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface Role2TreasureHuntWorldInfo
  extends Bean
{
  public abstract Role2TreasureHuntWorldInfo copy();
  
  public abstract Role2TreasureHuntWorldInfo toData();
  
  public abstract Role2TreasureHuntWorldInfo toBean();
  
  public abstract Role2TreasureHuntWorldInfo toDataIf();
  
  public abstract Role2TreasureHuntWorldInfo toBeanIf();
  
  public abstract long getWorld_id();
  
  public abstract int getChapter_cfg_id();
  
  public abstract int getProcess();
  
  public abstract long getSession_id();
  
  public abstract Map<Integer, Integer> getTrigger_effect_map();
  
  public abstract Map<Integer, Integer> getTrigger_effect_mapAsData();
  
  public abstract Set<Integer> getTrigger_buff_set();
  
  public abstract Set<Integer> getTrigger_buff_setAsData();
  
  public abstract void setWorld_id(long paramLong);
  
  public abstract void setChapter_cfg_id(int paramInt);
  
  public abstract void setProcess(int paramInt);
  
  public abstract void setSession_id(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Role2TreasureHuntWorldInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */