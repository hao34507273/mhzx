package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface CrossBattleBetSeasonRankBackup
  extends Bean
{
  public abstract CrossBattleBetSeasonRankBackup copy();
  
  public abstract CrossBattleBetSeasonRankBackup toData();
  
  public abstract CrossBattleBetSeasonRankBackup toBean();
  
  public abstract CrossBattleBetSeasonRankBackup toDataIf();
  
  public abstract CrossBattleBetSeasonRankBackup toBeanIf();
  
  public abstract Map<Integer, CrossBattleBetRankAwardInfo> getRank_award_infos();
  
  public abstract Map<Integer, CrossBattleBetRankAwardInfo> getRank_award_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossBattleBetSeasonRankBackup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */