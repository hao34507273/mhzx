package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface QMHWRank
  extends Bean
{
  public abstract QMHWRank copy();
  
  public abstract QMHWRank toData();
  
  public abstract QMHWRank toBean();
  
  public abstract QMHWRank toDataIf();
  
  public abstract QMHWRank toBeanIf();
  
  public abstract List<QMHWRankRole> getRanklist();
  
  public abstract List<QMHWRankRole> getRanklistAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\QMHWRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */