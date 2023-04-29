package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface HideItemInfo
  extends Bean
{
  public abstract HideItemInfo copy();
  
  public abstract HideItemInfo toData();
  
  public abstract HideItemInfo toBean();
  
  public abstract HideItemInfo toDataIf();
  
  public abstract HideItemInfo toBeanIf();
  
  public abstract Set<Integer> getItems();
  
  public abstract Set<Integer> getItemsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\HideItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */