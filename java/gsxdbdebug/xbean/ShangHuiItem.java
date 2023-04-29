package xbean;

import xdb.Bean;

public abstract interface ShangHuiItem
  extends Bean
{
  public abstract ShangHuiItem copy();
  
  public abstract ShangHuiItem toData();
  
  public abstract ShangHuiItem toBean();
  
  public abstract ShangHuiItem toDataIf();
  
  public abstract ShangHuiItem toBeanIf();
  
  public abstract int getRiserate();
  
  public abstract int getOrginalprice();
  
  public abstract void setRiserate(int paramInt);
  
  public abstract void setOrginalprice(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ShangHuiItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */