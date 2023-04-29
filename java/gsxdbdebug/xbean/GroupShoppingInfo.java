package xbean;

import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface GroupShoppingInfo
  extends Bean
{
  public abstract GroupShoppingInfo copy();
  
  public abstract GroupShoppingInfo toData();
  
  public abstract GroupShoppingInfo toBean();
  
  public abstract GroupShoppingInfo toDataIf();
  
  public abstract GroupShoppingInfo toBeanIf();
  
  public abstract Map<Integer, BigGroupShoppingItemInfo> getBig_group_infos();
  
  public abstract Map<Integer, BigGroupShoppingItemInfo> getBig_group_infosAsData();
  
  public abstract Map<Integer, SmallGroupShoppingItemInfo> getSmall_group_infos();
  
  public abstract Map<Integer, SmallGroupShoppingItemInfo> getSmall_group_infosAsData();
  
  public abstract Set<Long> getIncompleted_small_groups();
  
  public abstract Set<Long> getIncompleted_small_groupsAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GroupShoppingInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */