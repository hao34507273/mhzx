package xbean;

import java.util.NavigableMap;
import xdb.Bean;

public abstract interface CrossLadderRank
  extends Bean
{
  public abstract CrossLadderRank copy();
  
  public abstract CrossLadderRank toData();
  
  public abstract CrossLadderRank toBean();
  
  public abstract CrossLadderRank toDataIf();
  
  public abstract CrossLadderRank toBeanIf();
  
  public abstract long getSeason_begin_timestamp();
  
  public abstract NavigableMap<Integer, CrossLadderRankList> getLevel_range_ranks();
  
  public abstract NavigableMap<Integer, CrossLadderRankList> getLevel_range_ranksAsData();
  
  public abstract void setSeason_begin_timestamp(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossLadderRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */