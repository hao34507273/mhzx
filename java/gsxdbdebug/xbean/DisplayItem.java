package xbean;

import xdb.Bean;

public abstract interface DisplayItem
  extends Bean
{
  public abstract DisplayItem copy();
  
  public abstract DisplayItem toData();
  
  public abstract DisplayItem toBean();
  
  public abstract DisplayItem toDataIf();
  
  public abstract DisplayItem toBeanIf();
  
  public abstract int getItemid();
  
  public abstract int getPrice();
  
  public abstract long getChannelidornum();
  
  public abstract long getShoppingid();
  
  public abstract void setItemid(int paramInt);
  
  public abstract void setPrice(int paramInt);
  
  public abstract void setChannelidornum(long paramLong);
  
  public abstract void setShoppingid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\DisplayItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */