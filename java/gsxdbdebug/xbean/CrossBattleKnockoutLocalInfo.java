package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface CrossBattleKnockoutLocalInfo
  extends Bean
{
  public abstract CrossBattleKnockoutLocalInfo copy();
  
  public abstract CrossBattleKnockoutLocalInfo toData();
  
  public abstract CrossBattleKnockoutLocalInfo toBean();
  
  public abstract CrossBattleKnockoutLocalInfo toDataIf();
  
  public abstract CrossBattleKnockoutLocalInfo toBeanIf();
  
  public abstract Map<Integer, FightZoneLocalInfo> getFight_zone_info_map();
  
  public abstract Map<Integer, FightZoneLocalInfo> getFight_zone_info_mapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossBattleKnockoutLocalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */