package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface ShoppingIds
  extends Bean
{
  public abstract ShoppingIds copy();
  
  public abstract ShoppingIds toData();
  
  public abstract ShoppingIds toBean();
  
  public abstract ShoppingIds toDataIf();
  
  public abstract ShoppingIds toBeanIf();
  
  public abstract List<Long> getShoppingids();
  
  public abstract List<Long> getShoppingidsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ShoppingIds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */