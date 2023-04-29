package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface CrossBattleKnockoutActivityLocalInfo
  extends Bean
{
  public abstract CrossBattleKnockoutActivityLocalInfo copy();
  
  public abstract CrossBattleKnockoutActivityLocalInfo toData();
  
  public abstract CrossBattleKnockoutActivityLocalInfo toBean();
  
  public abstract CrossBattleKnockoutActivityLocalInfo toDataIf();
  
  public abstract CrossBattleKnockoutActivityLocalInfo toBeanIf();
  
  public abstract Map<Integer, CrossBattleKnockoutLocalInfo> getKnockout_info_map();
  
  public abstract Map<Integer, CrossBattleKnockoutLocalInfo> getKnockout_info_mapAsData();
  
  public abstract Map<Integer, CrossBattleKnockoutLocalRankInfo> getAward_server_info_map();
  
  public abstract Map<Integer, CrossBattleKnockoutLocalRankInfo> getAward_server_info_mapAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossBattleKnockoutActivityLocalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */