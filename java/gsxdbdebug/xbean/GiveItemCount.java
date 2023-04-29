package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface GiveItemCount
  extends Bean
{
  public abstract GiveItemCount copy();
  
  public abstract GiveItemCount toData();
  
  public abstract GiveItemCount toBean();
  
  public abstract GiveItemCount toDataIf();
  
  public abstract GiveItemCount toBeanIf();
  
  public abstract Map<Long, Integer> getRoleid2count();
  
  public abstract Map<Long, Integer> getRoleid2countAsData();
  
  public abstract long getCleartime();
  
  public abstract void setCleartime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GiveItemCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */