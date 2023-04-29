package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface CrossBattleOwnServerKnockoutInfo
  extends Bean
{
  public abstract CrossBattleOwnServerKnockoutInfo copy();
  
  public abstract CrossBattleOwnServerKnockoutInfo toData();
  
  public abstract CrossBattleOwnServerKnockoutInfo toBean();
  
  public abstract CrossBattleOwnServerKnockoutInfo toDataIf();
  
  public abstract CrossBattleOwnServerKnockoutInfo toBeanIf();
  
  public abstract Map<Integer, FightOwnServerStageInfo> getFight_stage_info_map();
  
  public abstract Map<Integer, FightOwnServerStageInfo> getFight_stage_info_mapAsData();
  
  public abstract Map<Long, FightCorpsInfo> getFight_corps_info_map();
  
  public abstract Map<Long, FightCorpsInfo> getFight_corps_info_mapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossBattleOwnServerKnockoutInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */