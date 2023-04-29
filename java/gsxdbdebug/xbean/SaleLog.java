package xbean;

import xdb.Bean;

public abstract interface SaleLog
  extends Bean
{
  public abstract SaleLog copy();
  
  public abstract SaleLog toData();
  
  public abstract SaleLog toBean();
  
  public abstract SaleLog toDataIf();
  
  public abstract SaleLog toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract long getBuytime();
  
  public abstract int getItemorpetcfgid();
  
  public abstract int getPrice();
  
  public abstract int getNum();
  
  public abstract long getMarketid();
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setBuytime(long paramLong);
  
  public abstract void setItemorpetcfgid(int paramInt);
  
  public abstract void setPrice(int paramInt);
  
  public abstract void setNum(int paramInt);
  
  public abstract void setMarketid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SaleLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */