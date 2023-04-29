package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface NoneRealTimeFightValueRank
  extends Bean
{
  public abstract NoneRealTimeFightValueRank copy();
  
  public abstract NoneRealTimeFightValueRank toData();
  
  public abstract NoneRealTimeFightValueRank toBean();
  
  public abstract NoneRealTimeFightValueRank toDataIf();
  
  public abstract NoneRealTimeFightValueRank toBeanIf();
  
  public abstract List<NoneRealRoleFightValueBean> getRankdatas();
  
  public abstract List<NoneRealRoleFightValueBean> getRankdatasAsData();
  
  public abstract Map<Long, Integer> getKeytorankchange();
  
  public abstract Map<Long, Integer> getKeytorankchangeAsData();
  
  public abstract long getSavetime();
  
  public abstract long getAwardtime();
  
  public abstract void setSavetime(long paramLong);
  
  public abstract void setAwardtime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\NoneRealTimeFightValueRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */