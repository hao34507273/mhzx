package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface CrossBattleKnockoutInfo
  extends Bean
{
  public abstract CrossBattleKnockoutInfo copy();
  
  public abstract CrossBattleKnockoutInfo toData();
  
  public abstract CrossBattleKnockoutInfo toBean();
  
  public abstract CrossBattleKnockoutInfo toDataIf();
  
  public abstract CrossBattleKnockoutInfo toBeanIf();
  
  public abstract Map<Integer, FightZoneInfo> getFight_zone_info_map();
  
  public abstract Map<Integer, FightZoneInfo> getFight_zone_info_mapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossBattleKnockoutInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */