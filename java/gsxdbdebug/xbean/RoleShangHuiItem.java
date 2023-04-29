package xbean;

import xdb.Bean;

public abstract interface RoleShangHuiItem
  extends Bean
{
  public abstract RoleShangHuiItem copy();
  
  public abstract RoleShangHuiItem toData();
  
  public abstract RoleShangHuiItem toBean();
  
  public abstract RoleShangHuiItem toDataIf();
  
  public abstract RoleShangHuiItem toBeanIf();
  
  public abstract long getShanghuiitemid();
  
  public abstract int getBuynum();
  
  public abstract int getSellnum();
  
  public abstract void setShanghuiitemid(long paramLong);
  
  public abstract void setBuynum(int paramInt);
  
  public abstract void setSellnum(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleShangHuiItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */