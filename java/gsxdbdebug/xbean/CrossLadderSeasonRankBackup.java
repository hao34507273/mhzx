package xbean;

import java.util.NavigableMap;
import xdb.Bean;

public abstract interface CrossLadderSeasonRankBackup
  extends Bean
{
  public abstract CrossLadderSeasonRankBackup copy();
  
  public abstract CrossLadderSeasonRankBackup toData();
  
  public abstract CrossLadderSeasonRankBackup toBean();
  
  public abstract CrossLadderSeasonRankBackup toDataIf();
  
  public abstract CrossLadderSeasonRankBackup toBeanIf();
  
  public abstract NavigableMap<Integer, CrossLadderLevelRangeRankBackup> getLevel_range_rank_backups();
  
  public abstract NavigableMap<Integer, CrossLadderLevelRangeRankBackup> getLevel_range_rank_backupsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossLadderSeasonRankBackup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */