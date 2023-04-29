package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface GiveYuanbaoCount
  extends Bean
{
  public abstract GiveYuanbaoCount copy();
  
  public abstract GiveYuanbaoCount toData();
  
  public abstract GiveYuanbaoCount toBean();
  
  public abstract GiveYuanbaoCount toDataIf();
  
  public abstract GiveYuanbaoCount toBeanIf();
  
  public abstract Map<Long, Long> getRoleid2count();
  
  public abstract Map<Long, Long> getRoleid2countAsData();
  
  public abstract long getCleartime();
  
  public abstract void setCleartime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GiveYuanbaoCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */