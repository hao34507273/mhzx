package xbean;

import xdb.Bean;

public abstract interface ShoppingInfo
  extends Bean
{
  public abstract ShoppingInfo copy();
  
  public abstract ShoppingInfo toData();
  
  public abstract ShoppingInfo toBean();
  
  public abstract ShoppingInfo toDataIf();
  
  public abstract ShoppingInfo toBeanIf();
  
  public abstract int getTotalnum();
  
  public abstract Item getItem();
  
  public abstract long getRoleid();
  
  public abstract int getPrice();
  
  public abstract long getExpire();
  
  public abstract void setTotalnum(int paramInt);
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setPrice(int paramInt);
  
  public abstract void setExpire(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ShoppingInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */