package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface LadderRank
  extends Bean
{
  public abstract LadderRank copy();
  
  public abstract LadderRank toData();
  
  public abstract LadderRank toBean();
  
  public abstract LadderRank toDataIf();
  
  public abstract LadderRank toBeanIf();
  
  public abstract List<LadderRankRole> getRanklist();
  
  public abstract List<LadderRankRole> getRanklistAsData();
  
  public abstract long getInittime();
  
  public abstract void setInittime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LadderRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */