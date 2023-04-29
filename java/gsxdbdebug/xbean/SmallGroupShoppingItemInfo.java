package xbean;

import xdb.Bean;

public abstract interface SmallGroupShoppingItemInfo
  extends Bean
{
  public abstract SmallGroupShoppingItemInfo copy();
  
  public abstract SmallGroupShoppingItemInfo toData();
  
  public abstract SmallGroupShoppingItemInfo toBean();
  
  public abstract SmallGroupShoppingItemInfo toDataIf();
  
  public abstract SmallGroupShoppingItemInfo toBeanIf();
  
  public abstract int getTotal_num();
  
  public abstract int getRemaining_num();
  
  public abstract void setTotal_num(int paramInt);
  
  public abstract void setRemaining_num(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SmallGroupShoppingItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */