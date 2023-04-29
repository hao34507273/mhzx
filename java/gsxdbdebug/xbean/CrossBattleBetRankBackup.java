package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface CrossBattleBetRankBackup
  extends Bean
{
  public abstract CrossBattleBetRankBackup copy();
  
  public abstract CrossBattleBetRankBackup toData();
  
  public abstract CrossBattleBetRankBackup toBean();
  
  public abstract CrossBattleBetRankBackup toDataIf();
  
  public abstract CrossBattleBetRankBackup toBeanIf();
  
  public abstract Map<Integer, CrossBattleBetSeasonRankBackup> getBackups();
  
  public abstract Map<Integer, CrossBattleBetSeasonRankBackup> getBackupsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossBattleBetRankBackup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */