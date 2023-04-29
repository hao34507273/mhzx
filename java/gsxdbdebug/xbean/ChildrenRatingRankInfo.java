package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface ChildrenRatingRankInfo
  extends Bean
{
  public abstract ChildrenRatingRankInfo copy();
  
  public abstract ChildrenRatingRankInfo toData();
  
  public abstract ChildrenRatingRankInfo toBean();
  
  public abstract ChildrenRatingRankInfo toDataIf();
  
  public abstract ChildrenRatingRankInfo toBeanIf();
  
  public abstract List<SingleChildRatingRankInfo> getRanklist();
  
  public abstract List<SingleChildRatingRankInfo> getRanklistAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ChildrenRatingRankInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */