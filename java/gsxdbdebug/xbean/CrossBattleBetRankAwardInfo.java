package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface CrossBattleBetRankAwardInfo
  extends Bean
{
  public abstract CrossBattleBetRankAwardInfo copy();
  
  public abstract CrossBattleBetRankAwardInfo toData();
  
  public abstract CrossBattleBetRankAwardInfo toBean();
  
  public abstract CrossBattleBetRankAwardInfo toDataIf();
  
  public abstract CrossBattleBetRankAwardInfo toBeanIf();
  
  public abstract Map<Long, RoleCrossBattleBetRankAwardInfo> getRole_rank_award_infos();
  
  public abstract Map<Long, RoleCrossBattleBetRankAwardInfo> getRole_rank_award_infosAsData();
  
  public abstract boolean getIs_data_complete();
  
  public abstract void setIs_data_complete(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossBattleBetRankAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */