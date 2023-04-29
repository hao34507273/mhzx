package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface JiuXiaoRank
  extends Bean
{
  public abstract JiuXiaoRank copy();
  
  public abstract JiuXiaoRank toData();
  
  public abstract JiuXiaoRank toBean();
  
  public abstract JiuXiaoRank toDataIf();
  
  public abstract JiuXiaoRank toBeanIf();
  
  public abstract List<JiuXiaoRankRole> getRanklist();
  
  public abstract List<JiuXiaoRankRole> getRanklistAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\JiuXiaoRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */