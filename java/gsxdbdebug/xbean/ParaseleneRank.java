package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface ParaseleneRank
  extends Bean
{
  public abstract ParaseleneRank copy();
  
  public abstract ParaseleneRank toData();
  
  public abstract ParaseleneRank toBean();
  
  public abstract ParaseleneRank toDataIf();
  
  public abstract ParaseleneRank toBeanIf();
  
  public abstract List<ParaseleneRankRole> getRanklist();
  
  public abstract List<ParaseleneRankRole> getRanklistAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ParaseleneRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */