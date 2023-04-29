package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface NoneRealTimeMultiFightValueRank
  extends Bean
{
  public abstract NoneRealTimeMultiFightValueRank copy();
  
  public abstract NoneRealTimeMultiFightValueRank toData();
  
  public abstract NoneRealTimeMultiFightValueRank toBean();
  
  public abstract NoneRealTimeMultiFightValueRank toDataIf();
  
  public abstract NoneRealTimeMultiFightValueRank toBeanIf();
  
  public abstract List<NoneRealRoleMultiFightValueBean> getRankdatas();
  
  public abstract List<NoneRealRoleMultiFightValueBean> getRankdatasAsData();
  
  public abstract Map<Long, Integer> getKeytorankchange();
  
  public abstract Map<Long, Integer> getKeytorankchangeAsData();
  
  public abstract long getSavetime();
  
  public abstract long getAwardtime();
  
  public abstract void setSavetime(long paramLong);
  
  public abstract void setAwardtime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\NoneRealTimeMultiFightValueRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */