package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface CrossLadderRankBackup
  extends Bean
{
  public abstract CrossLadderRankBackup copy();
  
  public abstract CrossLadderRankBackup toData();
  
  public abstract CrossLadderRankBackup toBean();
  
  public abstract CrossLadderRankBackup toDataIf();
  
  public abstract CrossLadderRankBackup toBeanIf();
  
  public abstract Map<Long, CrossLadderSeasonRankBackup> getBackups();
  
  public abstract Map<Long, CrossLadderSeasonRankBackup> getBackupsAsData();
  
  public abstract long getInit_season_begin_timestamp();
  
  public abstract void setInit_season_begin_timestamp(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossLadderRankBackup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */