package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface NoneRealTimeRoleLevelRank
  extends Bean
{
  public abstract NoneRealTimeRoleLevelRank copy();
  
  public abstract NoneRealTimeRoleLevelRank toData();
  
  public abstract NoneRealTimeRoleLevelRank toBean();
  
  public abstract NoneRealTimeRoleLevelRank toDataIf();
  
  public abstract NoneRealTimeRoleLevelRank toBeanIf();
  
  public abstract List<NoneRealRoleLevelBean> getRankdatas();
  
  public abstract List<NoneRealRoleLevelBean> getRankdatasAsData();
  
  public abstract Map<Long, Integer> getKeytorankchange();
  
  public abstract Map<Long, Integer> getKeytorankchangeAsData();
  
  public abstract long getSavetime();
  
  public abstract long getAwardtime();
  
  public abstract void setSavetime(long paramLong);
  
  public abstract void setAwardtime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\NoneRealTimeRoleLevelRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */