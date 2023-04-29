package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface ShoppingGroupInfo
  extends Bean
{
  public static final int INCOMPLETED = 0;
  public static final int COMPLETED = 1;
  public static final int FAILED = 2;
  public static final int CANCELLED = 3;
  
  public abstract ShoppingGroupInfo copy();
  
  public abstract ShoppingGroupInfo toData();
  
  public abstract ShoppingGroupInfo toBean();
  
  public abstract ShoppingGroupInfo toDataIf();
  
  public abstract ShoppingGroupInfo toBeanIf();
  
  public abstract int getGroup_shopping_item_cfgid();
  
  public abstract long getCreator_roleid();
  
  public abstract int getCreate_time();
  
  public abstract int getClose_time();
  
  public abstract int getStatus();
  
  public abstract int getPrice();
  
  public abstract int getGroup_size();
  
  public abstract Set<Long> getMembers();
  
  public abstract Set<Long> getMembersAsData();
  
  public abstract void setGroup_shopping_item_cfgid(int paramInt);
  
  public abstract void setCreator_roleid(long paramLong);
  
  public abstract void setCreate_time(int paramInt);
  
  public abstract void setClose_time(int paramInt);
  
  public abstract void setStatus(int paramInt);
  
  public abstract void setPrice(int paramInt);
  
  public abstract void setGroup_size(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ShoppingGroupInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */