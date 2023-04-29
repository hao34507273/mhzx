package xbean;

import xdb.Bean;

public abstract interface JewelInfo
  extends Bean
{
  public abstract JewelInfo copy();
  
  public abstract JewelInfo toData();
  
  public abstract JewelInfo toBean();
  
  public abstract JewelInfo toDataIf();
  
  public abstract JewelInfo toBeanIf();
  
  public abstract int getJewelcfgid();
  
  public abstract void setJewelcfgid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\JewelInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */