package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface GroupShoppingBanInfo
  extends Bean
{
  public abstract GroupShoppingBanInfo copy();
  
  public abstract GroupShoppingBanInfo toData();
  
  public abstract GroupShoppingBanInfo toBean();
  
  public abstract GroupShoppingBanInfo toDataIf();
  
  public abstract GroupShoppingBanInfo toBeanIf();
  
  public abstract Set<Integer> getBanned_group_shopping_items();
  
  public abstract Set<Integer> getBanned_group_shopping_itemsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GroupShoppingBanInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */