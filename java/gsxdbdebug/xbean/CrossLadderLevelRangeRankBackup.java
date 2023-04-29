package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface CrossLadderLevelRangeRankBackup
  extends Bean
{
  public abstract CrossLadderLevelRangeRankBackup copy();
  
  public abstract CrossLadderLevelRangeRankBackup toData();
  
  public abstract CrossLadderLevelRangeRankBackup toBean();
  
  public abstract CrossLadderLevelRangeRankBackup toDataIf();
  
  public abstract CrossLadderLevelRangeRankBackup toBeanIf();
  
  public abstract List<Long> getLocal_rank_list();
  
  public abstract List<Long> getLocal_rank_listAsData();
  
  public abstract Map<Integer, CrossLadderRankAwardInfo> getRank_award_infos();
  
  public abstract Map<Integer, CrossLadderRankAwardInfo> getRank_award_infosAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossLadderLevelRangeRankBackup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */