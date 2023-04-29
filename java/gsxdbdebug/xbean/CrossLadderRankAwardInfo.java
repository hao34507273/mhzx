package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface CrossLadderRankAwardInfo
  extends Bean
{
  public abstract CrossLadderRankAwardInfo copy();
  
  public abstract CrossLadderRankAwardInfo toData();
  
  public abstract CrossLadderRankAwardInfo toBean();
  
  public abstract CrossLadderRankAwardInfo toDataIf();
  
  public abstract CrossLadderRankAwardInfo toBeanIf();
  
  public abstract Map<Long, RoleCrossLadderRankAwardInfo> getRole_rank_award_infos();
  
  public abstract Map<Long, RoleCrossLadderRankAwardInfo> getRole_rank_award_infosAsData();
  
  public abstract boolean getIs_data_complete();
  
  public abstract void setIs_data_complete(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossLadderRankAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */