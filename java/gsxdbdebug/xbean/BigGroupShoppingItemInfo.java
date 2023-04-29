package xbean;

import xdb.Bean;

public abstract interface BigGroupShoppingItemInfo
  extends Bean
{
  public abstract BigGroupShoppingItemInfo copy();
  
  public abstract BigGroupShoppingItemInfo toData();
  
  public abstract BigGroupShoppingItemInfo toBean();
  
  public abstract BigGroupShoppingItemInfo toDataIf();
  
  public abstract BigGroupShoppingItemInfo toBeanIf();
  
  public abstract int getTotal_num();
  
  public abstract int getRemaining_num();
  
  public abstract long getGroup_id();
  
  public abstract void setTotal_num(int paramInt);
  
  public abstract void setRemaining_num(int paramInt);
  
  public abstract void setGroup_id(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BigGroupShoppingItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */