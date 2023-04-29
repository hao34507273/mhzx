package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface BanTradeItems
  extends Bean
{
  public abstract BanTradeItems copy();
  
  public abstract BanTradeItems toData();
  
  public abstract BanTradeItems toBean();
  
  public abstract BanTradeItems toDataIf();
  
  public abstract BanTradeItems toBeanIf();
  
  public abstract Set<Integer> getItemids();
  
  public abstract Set<Integer> getItemidsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BanTradeItems.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */