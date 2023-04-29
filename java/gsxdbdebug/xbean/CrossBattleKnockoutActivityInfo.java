package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface CrossBattleKnockoutActivityInfo
  extends Bean
{
  public abstract CrossBattleKnockoutActivityInfo copy();
  
  public abstract CrossBattleKnockoutActivityInfo toData();
  
  public abstract CrossBattleKnockoutActivityInfo toBean();
  
  public abstract CrossBattleKnockoutActivityInfo toDataIf();
  
  public abstract CrossBattleKnockoutActivityInfo toBeanIf();
  
  public abstract Map<Integer, CrossBattleKnockoutInfo> getKnockout_info_map();
  
  public abstract Map<Integer, CrossBattleKnockoutInfo> getKnockout_info_mapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossBattleKnockoutActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */