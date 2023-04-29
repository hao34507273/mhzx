package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface SingleCrossFieldSeasonRankBackup
  extends Bean
{
  public abstract SingleCrossFieldSeasonRankBackup copy();
  
  public abstract SingleCrossFieldSeasonRankBackup toData();
  
  public abstract SingleCrossFieldSeasonRankBackup toBean();
  
  public abstract SingleCrossFieldSeasonRankBackup toDataIf();
  
  public abstract SingleCrossFieldSeasonRankBackup toBeanIf();
  
  public abstract List<Long> getLocal_rank_list();
  
  public abstract List<Long> getLocal_rank_listAsData();
  
  public abstract Map<Integer, SingleCrossFieldRankAwardInfo> getRank_award_infos();
  
  public abstract Map<Integer, SingleCrossFieldRankAwardInfo> getRank_award_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SingleCrossFieldSeasonRankBackup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */