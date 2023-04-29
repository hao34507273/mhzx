package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface CrossBattleKnockoutOwnServerActivityInfo
  extends Bean
{
  public abstract CrossBattleKnockoutOwnServerActivityInfo copy();
  
  public abstract CrossBattleKnockoutOwnServerActivityInfo toData();
  
  public abstract CrossBattleKnockoutOwnServerActivityInfo toBean();
  
  public abstract CrossBattleKnockoutOwnServerActivityInfo toDataIf();
  
  public abstract CrossBattleKnockoutOwnServerActivityInfo toBeanIf();
  
  public abstract Map<Integer, CrossBattleOwnServerKnockoutInfo> getKnockout_info_map();
  
  public abstract Map<Integer, CrossBattleOwnServerKnockoutInfo> getKnockout_info_mapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossBattleKnockoutOwnServerActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */