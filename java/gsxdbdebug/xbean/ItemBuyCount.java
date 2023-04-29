package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface ItemBuyCount
  extends Bean
{
  public abstract ItemBuyCount copy();
  
  public abstract ItemBuyCount toData();
  
  public abstract ItemBuyCount toBean();
  
  public abstract ItemBuyCount toDataIf();
  
  public abstract ItemBuyCount toBeanIf();
  
  public abstract long getCleartime();
  
  public abstract Map<Integer, Integer> getId2count();
  
  public abstract Map<Integer, Integer> getId2countAsData();
  
  public abstract void setCleartime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ItemBuyCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */