package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface JingJiDailyRank
  extends Bean
{
  public abstract JingJiDailyRank copy();
  
  public abstract JingJiDailyRank toData();
  
  public abstract JingJiDailyRank toBean();
  
  public abstract JingJiDailyRank toDataIf();
  
  public abstract JingJiDailyRank toBeanIf();
  
  public abstract List<RoleJingJiBean> getRank_datas();
  
  public abstract List<RoleJingJiBean> getRank_datasAsData();
  
  public abstract long getTime();
  
  public abstract Map<Long, Integer> getRole_ranks();
  
  public abstract Map<Long, Integer> getRole_ranksAsData();
  
  public abstract void setTime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\JingJiDailyRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */