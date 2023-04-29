package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface ItemUseCount
  extends Bean
{
  public abstract ItemUseCount copy();
  
  public abstract ItemUseCount toData();
  
  public abstract ItemUseCount toBean();
  
  public abstract ItemUseCount toDataIf();
  
  public abstract ItemUseCount toBeanIf();
  
  public abstract long getCleartime();
  
  public abstract Map<Integer, Integer> getId2count();
  
  public abstract Map<Integer, Integer> getId2countAsData();
  
  public abstract void setCleartime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ItemUseCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */