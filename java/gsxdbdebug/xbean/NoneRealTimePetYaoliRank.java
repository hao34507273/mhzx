package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface NoneRealTimePetYaoliRank
  extends Bean
{
  public abstract NoneRealTimePetYaoliRank copy();
  
  public abstract NoneRealTimePetYaoliRank toData();
  
  public abstract NoneRealTimePetYaoliRank toBean();
  
  public abstract NoneRealTimePetYaoliRank toDataIf();
  
  public abstract NoneRealTimePetYaoliRank toBeanIf();
  
  public abstract List<NoneRealTimePetYaoliBean> getRankdatas();
  
  public abstract List<NoneRealTimePetYaoliBean> getRankdatasAsData();
  
  public abstract Map<Long, Integer> getKeytorankchange();
  
  public abstract Map<Long, Integer> getKeytorankchangeAsData();
  
  public abstract long getSavetime();
  
  public abstract long getAwardtime();
  
  public abstract void setSavetime(long paramLong);
  
  public abstract void setAwardtime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\NoneRealTimePetYaoliRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */