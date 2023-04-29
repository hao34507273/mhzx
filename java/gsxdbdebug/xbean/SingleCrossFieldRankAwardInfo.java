package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface SingleCrossFieldRankAwardInfo
  extends Bean
{
  public abstract SingleCrossFieldRankAwardInfo copy();
  
  public abstract SingleCrossFieldRankAwardInfo toData();
  
  public abstract SingleCrossFieldRankAwardInfo toBean();
  
  public abstract SingleCrossFieldRankAwardInfo toDataIf();
  
  public abstract SingleCrossFieldRankAwardInfo toBeanIf();
  
  public abstract Map<Long, RoleSingleCrossFieldRankAwardInfo> getRole_rank_award_infos();
  
  public abstract Map<Long, RoleSingleCrossFieldRankAwardInfo> getRole_rank_award_infosAsData();
  
  public abstract boolean getIs_data_complete();
  
  public abstract void setIs_data_complete(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SingleCrossFieldRankAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */