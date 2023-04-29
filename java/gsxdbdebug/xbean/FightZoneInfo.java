package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface FightZoneInfo
  extends Bean
{
  public abstract FightZoneInfo copy();
  
  public abstract FightZoneInfo toData();
  
  public abstract FightZoneInfo toBean();
  
  public abstract FightZoneInfo toDataIf();
  
  public abstract FightZoneInfo toBeanIf();
  
  public abstract Map<Long, FightCorpsInfo> getFight_corps_info_map();
  
  public abstract Map<Long, FightCorpsInfo> getFight_corps_info_mapAsData();
  
  public abstract Map<Integer, FightStageInfo> getFight_stage_info_map();
  
  public abstract Map<Integer, FightStageInfo> getFight_stage_info_mapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FightZoneInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */